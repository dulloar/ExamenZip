package com.davidulloa.examendavidantonioulloarodriguez.api;

import androidx.lifecycle.LiveData;

import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FileService {
    @GET("{url}")
    LiveData<String> getFile(@Url String url);
}
