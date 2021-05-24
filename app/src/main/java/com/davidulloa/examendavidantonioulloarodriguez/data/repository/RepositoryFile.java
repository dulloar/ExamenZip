package com.davidulloa.examendavidantonioulloarodriguez.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.davidulloa.examendavidantonioulloarodriguez.AppExecutors;
import com.davidulloa.examendavidantonioulloarodriguez.api.FileService;

import javax.inject.Inject;

import okhttp3.ResponseBody;

public class RepositoryFile {
    private FileService fileService;
    private AppExecutors appExecutors;

    @Inject
    public RepositoryFile(FileService fileService, AppExecutors appExecutors) {
        this.fileService = fileService;
        this.appExecutors = appExecutors;
    }


    public MutableLiveData<ResponseBody> getresponse(String url){
        MutableLiveData<ResponseBody> responseBodyMutableLiveData = new MutableLiveData<>();
        appExecutors.networkIO(new Runnable() {
            @Override
            public void run() {
                LiveData<ResponseBody> responseBody = fileService.getFile(url);
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        responseBodyMutableLiveData.setValue(responseBody.getValue());
                    }
                });
            }
        });
        return responseBodyMutableLiveData;
    }
}
