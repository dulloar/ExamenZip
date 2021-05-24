package com.davidulloa.examendavidantonioulloarodriguez;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.davidulloa.examendavidantonioulloarodriguez.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(binding == null ){
            binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        }
    }
}