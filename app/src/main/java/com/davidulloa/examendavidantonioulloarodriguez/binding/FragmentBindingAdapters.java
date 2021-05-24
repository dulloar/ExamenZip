package com.davidulloa.examendavidantonioulloarodriguez.binding;

import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public class FragmentBindingAdapters {
    final Fragment fragment;

    @Inject
    public FragmentBindingAdapters(Fragment fragment){
        this.fragment = fragment;
    }

}
