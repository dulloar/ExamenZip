package com.davidulloa.examendavidantonioulloarodriguez.binding;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

public class ActivityBindingAdapters {
    final AppCompatActivity activity;

    @Inject
    public ActivityBindingAdapters(AppCompatActivity activity){
        this.activity = activity;
    }


}
