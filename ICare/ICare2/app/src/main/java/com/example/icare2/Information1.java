package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Information1 extends Fragment {

    ImageButton information1BackArrowBtn;
    Button information1SkipBtn;
    Button information1ContinueBtn;

    public Information1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_information1, container, false);

        information1BackArrowBtn=v.findViewById(R.id.information1BackArrowBtn);
        information1BackArrowBtn.setOnClickListener(toPreviousFragment);
        information1SkipBtn=v.findViewById(R.id.information1SkipBtn);
        information1SkipBtn.setOnClickListener(toNextFragment);
        information1ContinueBtn=v.findViewById(R.id.information1ContinueBtn);
        information1ContinueBtn.setOnClickListener(toNextFragment);
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
                activity.topreviousFragment();
            }
        }
    };
}