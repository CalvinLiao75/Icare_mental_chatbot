package com.example.icare2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class ChatBot extends Fragment {

    private ImageButton chatbot;
    private ImageButton BotBackArrowBtn;

    public ChatBot() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_chat_bot, container, false);
        BotBackArrowBtn=v.findViewById(R.id.fragment11BackArrowBtn);
        BotBackArrowBtn.setOnClickListener(toPreviousFragment);
        chatbot=v.findViewById(R.id.chatBotMentalBtn);
        chatbot.setOnClickListener(toNextFragment);

        return v;
    }

    private View.OnClickListener toNextFragment=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity=(MainActivity)getActivity();

            
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