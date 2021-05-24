package com.davidulloa.examendavidantonioulloarodriguez.ui.list;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidulloa.examendavidantonioulloarodriguez.R;
import com.davidulloa.examendavidantonioulloarodriguez.binding.FragmentDataBindingComponent;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.Employee;
import com.davidulloa.examendavidantonioulloarodriguez.databinding.FragmentListBinding;
import com.davidulloa.examendavidantonioulloarodriguez.di.Injectable;
import com.davidulloa.examendavidantonioulloarodriguez.ui.adapter.EmployeeAdapter;
import com.davidulloa.examendavidantonioulloarodriguez.ui.common.NavigationFragment;
import com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel.AuthViewModel;
import com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel.EmployeViewModel;
import com.davidulloa.examendavidantonioulloarodriguez.util.AutoClearedValue;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements Injectable, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EmployeeAdapter.ColaboradorOnclick colaboradorOnClick;
    private RecyclerView recyclerView;

    androidx.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    AutoClearedValue<FragmentListBinding> binding;
    AutoClearedValue<EmployeeAdapter> adapter;


    private EmployeViewModel employeViewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @Inject
    NavigationFragment navigationFragment;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list,
                container, false, dataBindingComponent);
        binding = new AutoClearedValue<>(this,dataBinding);

        EmployeeAdapter adapter = new EmployeeAdapter(getContext(), new EmployeeAdapter.ColaboradorOnclick() {
            @Override
            public void OnClick(Employee employee) {
                navigationFragment.navigateMaps(employee.getId());
            }
        });
        this.adapter = new AutoClearedValue<>(this,adapter);
        binding.get().rvEmployee.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.get().rvEmployee.setAdapter(adapter);
        // Inflate the layout for this fragment
        return binding.get().getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        employeViewModel = ViewModelProviders.of(this,viewModelFactory).get(EmployeViewModel.class);
        employeViewModel.getEmployess().observe(getViewLifecycleOwner(),v ->{
            adapter.get().setEmployees(v);
            adapter.notifyAll();
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}