package com.example.icare2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.content.ContentValues.TAG;

public class SignIn extends Fragment {

    private Button signInNextBtn;
    private FirebaseAuth mAuth;
    private String account,password;
    private EditText accountEdit,passwordEdit;

    public SignIn() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_sign_in, container, false);
        signInNextBtn=v.findViewById(R.id.signInNextBtn);
        signInNextBtn.setOnClickListener(toNextFragment);
        accountEdit = v.findViewById(R.id.account_in);
        passwordEdit = v.findViewById(R.id.password_in);
        mAuth = FirebaseAuth.getInstance();
        return v;
    }

    private View.OnClickListener toNextFragment=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity=(MainActivity)getActivity();
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            Log.i(TAG, "onClick: login ,"+ account + password);
            if(TextUtils.isEmpty(account)){
                Toast.makeText(getActivity(), "未填信箱", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(getActivity(), "未填密碼", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(account, password)
                    .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getContext(), "登入成功", Toast.LENGTH_SHORT).show();
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
}