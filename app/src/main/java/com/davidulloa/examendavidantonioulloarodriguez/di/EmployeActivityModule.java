package com.davidulloa.examendavidantonioulloarodriguez.di;


import com.davidulloa.examendavidantonioulloarodriguez.ui.EmployeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class EmployeActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersEmployeeModule.class)
    abstract EmployeActivity contributeEmployeeActivity();
}
