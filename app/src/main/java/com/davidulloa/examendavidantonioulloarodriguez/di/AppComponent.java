package com.davidulloa.examendavidantonioulloarodriguez.di;

import android.app.Application;


import com.davidulloa.examendavidantonioulloarodriguez.ExamenApp;
import com.davidulloa.examendavidantonioulloarodriguez.ui.common.NavigationFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
                        AppModule.class
                        ,MainActivityModule.class
                        , EmployeActivityModule.class
                        })
public interface AppComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(ExamenApp myApp);
}
