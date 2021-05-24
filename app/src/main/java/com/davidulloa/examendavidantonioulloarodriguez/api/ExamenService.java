package com.davidulloa.examendavidantonioulloarodriguez.api;

import androidx.lifecycle.LiveData;


import com.davidulloa.examendavidantonioulloarodriguez.data.remote.response.ResponseData;

import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ExamenService {

    @GET("s/5u21281sca8gj94/getFile.json?dl=0")
    LiveData<ResponseData> getData();


}
