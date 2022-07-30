package com.example.icare2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int currentFragmentIndex;
    private Fragment[]  mFragments;
    private final int miniFragmentIndex=0;
    private final int maxFragmentIndex=16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments=new Fragment[maxFragmentIndex+1];

        mFragments[0]=new MeetICare();
        mFragments[1]=new Information1();
        mFragments[2]=new Warning();
        mFragments[3]=new Information2();
        mFragments[4]=new Information3();
        mFragments[5]=new CreateAccount();
        mFragments[6]=new SignIn();
        mFragments[7]=new Menu();
        mFragments[8]=new YourGoal();
        mFragments[9]=new PrivacyPolicy();
        mFragments[10]=new FacialEmotion();
        mFragments[11]=new ChatBot();
        mFragments[12]=new EmotionDiary();
        mFragments[13]=new MentalState();
        mFragments[14]=new DestressMusic();
        mFragments[15]=new MainMenu();
        mFragments[16]=new CMap();


        FragmentTransaction tmpTransaction=getSupportFragmentManager().beginTransaction();
        for(int i=0;i <= maxFragmentIndex;i++){
            tmpTransaction
                    .add(R.id.frameLay, mFragments[i], "Fragment"+String.valueOf(i+1))
                    .hide(mFragments[i]);
        }

        tmpTransaction.show(mFragments[0]);
        tmpTransaction.commit();
        currentFragmentIndex=0;
    }

    public void toNextFragment(){
        if(currentFragmentIndex+1 > maxFragmentIndex) return;

        getSupportFragmentManager().beginTransaction()
                .show(mFragments[currentFragmentIndex+1])
                .hide(mFragments[currentFragmentIndex])
                .commit();

        currentFragmentIndex++;
    }

    public void topreviousFragment(){
        if(currentFragmentIndex-1 < miniFragmentIndex) return;

        getSupportFragmentManager().beginTransaction()
                .show(mFragments[currentFragmentIndex-1])
                .hide(mFragments[currentFragmentIndex])
                .commit();

        currentFragmentIndex--;
    }

    public void toTargetFragment(int position){
        if(currentFragmentIndex == position) return;

        getSupportFragmentManager().beginTransaction()
                .show(mFragments[position])
                .hide(mFragments[currentFragmentIndex])
                .commit();

        currentFragmentIndex=position;
    }
}