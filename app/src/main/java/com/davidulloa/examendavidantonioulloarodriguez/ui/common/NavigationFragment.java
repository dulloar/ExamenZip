package com.davidulloa.examendavidantonioulloarodriguez.ui.common;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import com.davidulloa.examendavidantonioulloarodriguez.R;
import com.davidulloa.examendavidantonioulloarodriguez.ui.EmployeActivity;
import com.davidulloa.examendavidantonioulloarodriguez.ui.map.MapsFragment;
import com.davidulloa.examendavidantonioulloarodriguez.ui.register.RegisterEmployeFragment;

import javax.inject.Inject;

public class NavigationFragment {
    private final int containerId;
    private final FragmentManager fragmentManager;

    @Inject
    public NavigationFragment(EmployeActivity employeActivity){
        this.containerId = R.id.container;
        this.fragmentManager = employeActivity.getSupportFragmentManager();
    }

    public void navigateHome(){
        ListFragment listFragment = new ListFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, listFragment)
                .commit();
    }

    public void navigateMaps(int id){
        MapsFragment mapsFragment = new MapsFragment().newInstance(id);
        fragmentManager.beginTransaction()
                .replace(containerId, mapsFragment,"maps")
                .commit();
    }
    public void navigateRegister(){
        RegisterEmployeFragment registerEmployeFragment = new RegisterEmployeFragment();
        fragmentManager.beginTransaction()
                .replace(containerId, registerEmployeFragment,"register")
                .commit();
    }

}
