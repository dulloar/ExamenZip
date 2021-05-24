package com.davidulloa.examendavidantonioulloarodriguez.di;

import android.app.Application;

import androidx.room.Room;

import com.davidulloa.examendavidantonioulloarodriguez.api.ExamenService;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.RoomDatabseEmployes;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.dao.EmployeesDao;
import com.davidulloa.examendavidantonioulloarodriguez.data.remote.ApiConstants;
import com.davidulloa.examendavidantonioulloarodriguez.util.LiveDataCallAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Singleton
    @Provides
    ExamenService provideExamenService(){


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(ExamenService.class);
    }

    @Singleton
    @Provides
    ExamenService provideFileService(){


        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(ExamenService.class);
    }


    @Singleton
    @Provides
    RoomDatabseEmployes provideDB(Application app){
        return Room.databaseBuilder(app, RoomDatabseEmployes.class,"employess_db").build();
    }


    @Singleton
    @Provides
    EmployeesDao providesEmployeeResponse(RoomDatabseEmployes db){return db.getEmployeeDao();}

}
