package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class PrivacyPolicy extends Fragment {

    private Button privacyPolicyUnderStandBtn;
    private ImageButton privacyPolicyBackArrowBtn;

    public PrivacyPolicy() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_privacy_policy, container, false);
        privacyPolicyUnderStandBtn=v.findViewById(R.id.privacyPolicyUnderStandBtn);
        privacyPolicyBackArrowBtn=v.findViewById(R.id.privacyPolicyBackArrowBtn);
        privacyPolicyBackArrowBtn.setOnClickListener(toPreviousFragment);
        privacyPolicyUnderStandBtn.setOnClickListener(toNextFragment);

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