package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class YourGoal extends Fragment {

    private ImageButton yourGoalBackArrowBtn;
    private  ImageButton yourGoaldestressmusic;
    private  ImageButton yourGoalMap;
    private Button yourGoalMentalExamBtn;

    public YourGoal() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_your_goal, container, false);
        yourGoalBackArrowBtn=v.findViewById(R.id.yourGoalBackArrowBtn);
        yourGoalMentalExamBtn=v.findViewById((R.id.yourGoalMentalExamBtn));
        yourGoaldestressmusic=v.findViewById((R.id.destressmusic));
        yourGoalMap = v.findViewById(R.id.clinicmap);
        yourGoalBackArrowBtn.setOnClickListener(toPreviousFragment);
        yourGoalMentalExamBtn.setOnClickListener(toMentalStateFragment);
        yourGoaldestressmusic.setOnClickListener(todestressmusicFragment);
        yourGoalMap.setOnClickListener(toHospitalMaps);

        return v;
    }

    private View.OnClickListener toNextFragment=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toNextFragment();
            }
        }
    };

    private View.OnClickListener toPreviousFragment=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(15);
            }
        }
    };

    private View.OnClickListener toMentalStateFragment=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(13);
            }
        }
    };
    private View.OnClickListener todestressmusicFragment=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(14);
            }
        }
    };
    private View.OnClickListener toHospitalMaps=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(16);
            }
        }
    };

}