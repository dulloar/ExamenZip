package com.davidulloa.examendavidantonioulloarodriguez.di;

import com.davidulloa.examendavidantonioulloarodriguez.ui.EmployeActivity;
import com.davidulloa.examendavidantonioulloarodriguez.ui.auth.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildesrAuthModule.class)
    abstract LoginFragment contributeEmployeeActivity();
}
