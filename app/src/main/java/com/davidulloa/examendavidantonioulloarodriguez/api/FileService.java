package com.davidulloa.examendavidantonioulloarodriguez.api;

import androidx.lifecycle.LiveData;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface FileService {
    @Streaming
    @GET
    LiveData<ResponseBody> getFile(@Url String url);
}
