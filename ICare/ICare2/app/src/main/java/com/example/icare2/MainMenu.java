package com.example.icare2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class MainMenu extends Fragment {


    private ImageButton toFacialEmotionBtn,toChatBotBtn,toEmotionDiaryBtn,toEmotionScoreBtn;

    public MainMenu() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_main_menu, container, false);
        toFacialEmotionBtn=v.findViewById(R.id.toFacialEmotionBtn);
        toChatBotBtn=v.findViewById((R.id.toChatBotBtn));
        toEmotionDiaryBtn=v.findViewById((R.id.toEmotionDiaryBtn));
        toEmotionScoreBtn=v.findViewById(R.id.toEmotionScoreBtn);

        toFacialEmotionBtn.setOnClickListener(toFacialEmotion);
        toChatBotBtn.setOnClickListener(toChatBot);
        toEmotionDiaryBtn.setOnClickListener(toEmotionDiary);
        toEmotionScoreBtn.setOnClickListener(toEmotionScore);

        return v;
    }

    private View.OnClickListener toFacialEmotion=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();
            Uri uri;
            if(activity != null){
                uri = Uri.parse("http://192.168.115.86:5000/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        }
    };


    private View.OnClickListener toChatBot=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(11);
            }
        }
    };

    private View.OnClickListener toEmotionDiary=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(12);
            }
        }
    };
    private View.OnClickListener toEmotionScore=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(8);
            }
        }
    };

}
