package com.davidulloa.examendavidantonioulloarodriguez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.davidulloa.examendavidantonioulloarodriguez.databinding.ActivityMainBinding;
import com.davidulloa.examendavidantonioulloarodriguez.ui.EmployeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(binding == null){
            binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
        } else {
            // Permission has already been granted
        }

        binding.bAddEmployee.setOnClickListener(this);
        binding.bEmployees.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(this, EmployeActivity.class);
        if(v == binding.bAddEmployee){
            intent.putExtra("fragment",0);
        }else{
            intent.putExtra("fragment",1);
        }
        startActivity(intent);
    }
}
