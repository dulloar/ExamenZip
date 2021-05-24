package com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.davidulloa.examendavidantonioulloarodriguez.data.repository.RepositoryFile;

import javax.inject.Inject;

public class FileViewModel extends ViewModel {
    private RepositoryFile repositoryFile;

    @Inject
    public FileViewModel(RepositoryFile repositoryFile) {
        this.repositoryFile = repositoryFile;
    }

    public void getData(){

    }
}
