package com.davidulloa.examendavidantonioulloarodriguez.di;

import com.davidulloa.examendavidantonioulloarodriguez.ui.EmployeActivity;
import com.davidulloa.examendavidantonioulloarodriguez.ui.auth.LoginFragment;

import dagger.android.ContributesAndroidInjector;

public abstract class LoginActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract LoginFragment contributeEmployeeActivity();
}
