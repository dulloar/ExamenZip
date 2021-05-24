package com.davidulloa.examendavidantonioulloarodriguez.di;

import com.davidulloa.examendavidantonioulloarodriguez.ui.auth.LoginFragment;
import com.davidulloa.examendavidantonioulloarodriguez.ui.auth.RegisterFragmentFragment;
import com.davidulloa.examendavidantonioulloarodriguez.ui.list.ListFragment;
import com.davidulloa.examendavidantonioulloarodriguez.ui.map.MapsFragment;
import com.davidulloa.examendavidantonioulloarodriguez.ui.register.RegisterEmployeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersEmployeeModule {
    @ContributesAndroidInjector
    abstract RegisterEmployeFragment contributeRegistereEmployeeFragment();

    @ContributesAndroidInjector
    abstract ListFragment contributeListFragment();

    @ContributesAndroidInjector
    abstract MapsFragment contributeMapsFragment();

}
