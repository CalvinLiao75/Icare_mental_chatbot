package com.example.icare2;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EmotionDiary extends Fragment {

    private ImageButton fragment13BackArrowBtn;

    public EmotionDiary() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ProgressDialog dialog = ProgressDialog.show(this.getActivity(), "", "請稍候");
        View view=inflater.inflate(R.layout.fragment_emotion_diary, container, false);
        new Thread(() -> {
            /**由於此開源庫的Calender為耗時工作，故加入背景執行使載入介面時不會閃退*/
            this.getActivity().runOnUiThread(() -> {
                //setContentView(R.layout.activity_main);
                dialog.dismiss();
                setView(view);
            });
        }).start();
        return view;
    }

    private void setView(View view) {
        Button btSetTarget, btClearTarget, btToday, btGetDay;
        ImageButton mood1,mood2,mood3,mood4;
        mood1 = view.findViewById(R.id.mood1);
        mood2 = view.findViewById(R.id.mood2);
        mood3 = view.findViewById(R.id.mood3);
        mood4 = view.findViewById(R.id.mood4);
        CalendarView calendarView = view.findViewById(R.id.calendarView);
        // btSetTarget = findViewById(R.id.button_SetTarget);
        btClearTarget = view.findViewById(R.id.button_CancelTarget);
        btToday = view.findViewById(R.id.button_Today);
        btGetDay = view.findViewById(R.id.button_GetTheDay);

        List<EventDay> event = new ArrayList<>();


        /**設置標記(喜)*/

        mood1.setOnClickListener(v -> {
            new Thread(() -> {
                /**利用forEach迴圈找出指定元素*/
                for (Calendar calendar : calendarView.getSelectedDates()) {
                    /**取得選定日之Date*/
                    calendar.setTime(calendar.getTime());
                    /**在event陣列中新增一個元素*/
                    event.add(new EventDay(calendar, R.drawable.happy_foreground));
                    this.getActivity().runOnUiThread(() -> {
                        /**刷新介面*/
                        calendarView.setEvents(event);
                    });
                }
            }).start();
        });
        /**設置標記(怒)*/
        mood2.setOnClickListener(v -> {
            new Thread(() -> {
                /**利用forEach迴圈找出指定元素*/
                for (Calendar calendar : calendarView.getSelectedDates()) {
                    /**取得選定日之Date*/
                    calendar.setTime(calendar.getTime());
                    /**在event陣列中新增一個元素*/
                    event.add(new EventDay(calendar, R.drawable.mood2sad_foreground));
                    this.getActivity().runOnUiThread(() -> {
                        /**刷新介面*/
                        calendarView.setEvents(event);
                    });
                }
            }).start();
        });
        /**設置標記(哀)*/
        mood3.setOnClickListener(v -> {
            new Thread(() -> {
                /**利用forEach迴圈找出指定元素*/
                for (Calendar calendar : calendarView.getSelectedDates()) {
                    /**取得選定日之Date*/
                    calendar.setTime(calendar.getTime());
                    /**在event陣列中新增一個元素*/
                    event.add(new EventDay(calendar, R.drawable.sad_foreground));
                    this.getActivity().runOnUiThread(() -> {
                        /**刷新介面*/
                        calendarView.setEvents(event);
                    });
                }
            }).start();
        });
        /**設置標記(樂)*/
        mood4.setOnClickListener(v -> {
            new Thread(() -> {
                /**利用forEach迴圈找出指定元素*/
                for (Calendar calendar : calendarView.getSelectedDates()) {
                    /**取得選定日之Date*/
                    calendar.setTime(calendar.getTime());
                    /**在event陣列中新增一個元素*/
                    event.add(new EventDay(calendar, R.drawable.nomood_foreground));
                    this.getActivity().runOnUiThread(() -> {
                        /**刷新介面*/
                        calendarView.setEvents(event);
                    });
                }
            }).start();
        });

        /**解除標記*/
        btClearTarget.setOnClickListener(v -> {
            new Thread(() -> {
                /**利用forEach迴圈找出指定元素*/
                for (Calendar calendar : calendarView.getSelectedDates()) {
                    /**取得選定日之Date*/
                    calendar.setTime(calendar.getTime());
                    /**利用for迴圈找出指定元素之index*/
                    for (int i = 0; i < event.size(); i++) {
                        Long select = calendar.getTimeInMillis();
                        Long target = event.get(i).getCalendar().getTimeInMillis();
                        if (select.equals(target)){
                            /**刪除指定元素*/
                            event.remove(i);
                            this.getActivity().runOnUiThread(() -> {
                                /**刷新介面*/
                                calendarView.setEvents(event);
                            });
                        }
                    }
                }
            }).start();
        });

        /**取得選中之日期*/
        btGetDay.setOnClickListener(v -> {
            /**利用forEach迴圈找出指定元素*/
            for (Calendar calendar : calendarView.getSelectedDates()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Toast.makeText(this.getActivity(), sdf.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        });

        /**跳至今日(指定)日期*/
        btToday.setOnClickListener(v -> {
            /**取得今日之Date*/
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfM = new SimpleDateFormat("MM");
            SimpleDateFormat sdfD = new SimpleDateFormat("dd");
            /**calender設置為今日*/
            calendar.set(Integer.parseInt(sdfY.format(date))
                    , Integer.parseInt(sdfM.format(date)) - 1
                    , Integer.parseInt(sdfD.format(date)));
            try {
                /**刷新介面*/
                calendarView.setDate(calendar);
            } catch (OutOfDateRangeException e) {
                e.printStackTrace();
            }
        });
    }
}