package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FacialEmotion extends Fragment {
    private ImageButton facialEmotionBackArrowBtn;
    private ImageView facialEmotionCurrentEmotionImage;

    public FacialEmotion() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_facial_emotion, container, false);
        facialEmotionBackArrowBtn=v.findViewById(R.id.facialEmotionBackArrowBtn);
        facialEmotionCurrentEmotionImage=v.findViewById(R.id.facialEmotionCurrentEmotionImage);
        facialEmotionCurrentEmotionImage.setOnClickListener(toNextFragment);
        facialEmotionBackArrowBtn.setOnClickListener(toPreviousFragment);
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
}