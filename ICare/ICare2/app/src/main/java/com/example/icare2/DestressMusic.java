package com.example.icare2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class DestressMusic extends Fragment {
    private ImageButton destressMusicBackArrowBtn;
    private Button Music1, Music2, Music3;

    public DestressMusic() {
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_destress_music, container, false);
        destressMusicBackArrowBtn = v.findViewById((R.id.destressMusicBackArrowBtn));
        Music1 = v.findViewById(R.id.Music1);
        Music2 = v.findViewById(R.id.Music2);
        Music3 = v.findViewById(R.id.Music3);
        destressMusicBackArrowBtn.setOnClickListener(toYourGoal);
        Music1.setOnClickListener(Music1_onclick);
        Music2.setOnClickListener(Music2_onclick);
        Music3.setOnClickListener(Music3_onclick);
        return v;
    }
    private View.OnClickListener toYourGoal=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(8);
            }
        }
    };
    private View.OnClickListener Music1_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("https://www.youtube.com/watch?v=wDpW8HHSgQY");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener Music2_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("https://www.youtube.com/watch?v=7maJOI3QMu0");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener Music3_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("https://www.youtube.com/watch?v=rA0GKIGTCsk&t=13s");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}