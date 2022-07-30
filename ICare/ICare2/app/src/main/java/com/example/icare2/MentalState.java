package com.example.icare2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import static androidx.core.content.PermissionChecker.checkCallingOrSelfPermission;

public class MentalState extends Fragment {
    private ImageButton mentalStateBackArrowBtn;
    private Button Button1,Button2,Button3,Button4,Button5;

    public MentalState() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_mental_state, container, false);
        if ( ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET},1);
        }
        mentalStateBackArrowBtn=v.findViewById(R.id.mentalStateBackArrowBtn);
        mentalStateBackArrowBtn.setOnClickListener(backToYourGoalFragment);
        Button1 = v.findViewById(R.id.mentalStateMelancholy);
        Button1.setOnClickListener(Bt1_onclick);
        Button2 = v.findViewById(R.id.mentalStateBipolar);
        Button2.setOnClickListener(Bt2_onclick);
        Button3 = v.findViewById(R.id.mentalStateAnxiety);
        Button3.setOnClickListener(Bt3_onclick);
        Button4 = v.findViewById(R.id.mentalPanic);
        Button4.setOnClickListener(Bt4_onclick);
        Button5 = v.findViewById(R.id.mentalInsomnia);
        Button5.setOnClickListener(Bt5_onclick);
        return v;
    }
    private View.OnClickListener backToYourGoalFragment=new View.OnClickListener() {
        @Override
        public void onClick(View v){
            MainActivity activity=(MainActivity)getActivity();

            if(activity != null){
                activity.toTargetFragment(8);
            }
        }
    };
    private View.OnClickListener Bt1_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.jtf.org.tw/overblue/taiwan1/"));
            startActivity(intent);
        }
    };
    private View.OnClickListener Bt2_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.kimogi.org.tw/scale.php?ps=form;1"));
            startActivity(intent);
        }
    };
    private View.OnClickListener Bt3_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.hmdc.cuhk.edu.hk/gad-test/"));
            startActivity(intent);
        }
    };
    private View.OnClickListener Bt4_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.hmdc.cuhk.edu.hk/panic-disorder-test/"));
            startActivity(intent);
        }
    };
    private View.OnClickListener Bt5_onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.nicemind.tw/self-diagnosis/%E5%A4%B1%E7%9C%A0%E7%97%87%E8%87%AA%E6%88%91%E8%A9%95%E9%87%8F%E8%A1%A8"));
            startActivity(intent);
        }
    };
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults[0]== PackageManager.PERMISSION_GRANTED) {
            }
        }
    }
}