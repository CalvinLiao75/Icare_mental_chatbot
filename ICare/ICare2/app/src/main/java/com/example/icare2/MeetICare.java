package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MeetICare extends Fragment {

    private Button meetICareNextBtn, meetICareLoginBtn;
    private FirebaseAuth mAuth;

    public MeetICare() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meet_i_care, container, false);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null) {
            meetICareNextBtn = v.findViewById(R.id.meetICareGetStartedBtn);
            meetICareNextBtn.setOnClickListener(toNextFragment);
            meetICareLoginBtn = v.findViewById(R.id.meetICareLoginBtn);
            meetICareLoginBtn.setOnClickListener(toLoginFragment);

        }else{
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(15);
            }
        }
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

    private View.OnClickListener toLoginFragment=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(6);
            }
        }
    };
}