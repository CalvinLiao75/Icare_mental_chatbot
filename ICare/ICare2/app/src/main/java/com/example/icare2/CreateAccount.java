package com.example.icare2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends Fragment {

    ImageButton createAccountBackArrowBtn;
    Button createAccountSkipBtn;
    Button createAccountNextBtn;
    private FirebaseAuth mAuth;
    EditText accountEdit, passwordEdit;

    public CreateAccount() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_create_account, container, false);

        createAccountBackArrowBtn=v.findViewById(R.id.createAccountBackArrowBtn);
        createAccountBackArrowBtn.setOnClickListener(toPreviousFragment);
        createAccountSkipBtn=v.findViewById(R.id.createAccountSkipBtn);
        createAccountSkipBtn.setOnClickListener(toNextFragment);
        createAccountNextBtn=v.findViewById(R.id.createAccountNextBtn);
        createAccountNextBtn.setOnClickListener(toNextFragment);
        mAuth = FirebaseAuth.getInstance();
        accountEdit = v.findViewById(R.id.account_edit);
        passwordEdit = v.findViewById(R.id.password_edit);

        return v;
    }

    private View.OnClickListener toNextFragment=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity=(MainActivity)getActivity();
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            if(TextUtils.isEmpty(account)){
                Toast.makeText(getActivity(), "未填信箱", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(getActivity(), "未填密碼", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(account, password)
                    .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "註冊成功", Toast.LENGTH_SHORT).show();
                                if(activity != null){
                                    activity.toTargetFragment(15);
                                }
                            } else {
                                Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
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