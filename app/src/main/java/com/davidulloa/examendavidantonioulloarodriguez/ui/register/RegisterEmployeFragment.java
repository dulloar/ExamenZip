package com.davidulloa.examendavidantonioulloarodriguez.ui.register;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidulloa.examendavidantonioulloarodriguez.R;
import com.davidulloa.examendavidantonioulloarodriguez.binding.FragmentDataBindingComponent;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.Employee;
import com.davidulloa.examendavidantonioulloarodriguez.databinding.FragmentListBinding;
import com.davidulloa.examendavidantonioulloarodriguez.databinding.FragmentRegisterEmployeBinding;
import com.davidulloa.examendavidantonioulloarodriguez.databinding.FragmentRegisterFragmentBinding;
import com.davidulloa.examendavidantonioulloarodriguez.di.Injectable;
import com.davidulloa.examendavidantonioulloarodriguez.ui.adapter.EmployeeAdapter;
import com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel.EmployeViewModel;
import com.davidulloa.examendavidantonioulloarodriguez.util.AutoClearedValue;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterEmployeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterEmployeFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    androidx.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    AutoClearedValue<FragmentRegisterEmployeBinding> binding;

    private EmployeViewModel employeViewModel;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterEmployeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterEmployeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterEmployeFragment newInstance(String param1, String param2) {
        RegisterEmployeFragment fragment = new RegisterEmployeFragment();
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
        FragmentRegisterFragmentBinding fragmentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_register_employe
                , container, false,dataBindingComponent);
        binding = new AutoClearedValue<>(this,fragmentBinding);

        binding.get().bSave.setOnClickListener( v -> save());

        // Inflate the layout for this fragment
        return binding.get().getRoot();
    }

    private void save() {
        Employee employee = new Employee();
        employee.setName(binding.get().tietName.getText().toString());
        employee.setMail(binding.get().tietEmail.getText().toString());

        employeViewModel.getEmployess(employee);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        employeViewModel = ViewModelProviders.of(this,viewModelFactory).get(EmployeViewModel.class);
    }
}