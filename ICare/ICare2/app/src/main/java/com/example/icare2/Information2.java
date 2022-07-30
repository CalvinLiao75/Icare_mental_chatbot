package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Information2 extends Fragment {

    private Button information2UnderstandBtn;


    public Information2() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_information2, container, false);
        information2UnderstandBtn=v.findViewById(R.id.information2UnderstandBtn);
        information2UnderstandBtn.setOnClickListener(toNextFragment);
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
}