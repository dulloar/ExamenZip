package com.davidulloa.examendavidantonioulloarodriguez.ui.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.davidulloa.examendavidantonioulloarodriguez.MainActivity;
import com.davidulloa.examendavidantonioulloarodriguez.R;
import com.davidulloa.examendavidantonioulloarodriguez.binding.FragmentDataBindingComponent;
import com.davidulloa.examendavidantonioulloarodriguez.data.local.models.User;
import com.davidulloa.examendavidantonioulloarodriguez.databinding.FragmentLoginBinding;
import com.davidulloa.examendavidantonioulloarodriguez.di.Injectable;
import com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel.AuthViewModel;
import com.davidulloa.examendavidantonioulloarodriguez.util.AutoClearedValue;

import java.lang.annotation.Annotation;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements Injectable, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject
    ViewModelProvider.Factory viewModelFactory;


    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

    AutoClearedValue<FragmentLoginBinding> binding;

    private AuthViewModel authViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

        FragmentLoginBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false, dataBindingComponent);
        binding = new AutoClearedValue<>(this,dataBinding);
        binding.get().bSave.setOnClickListener(v -> register());
        // Inflate the layout for this fragment
        return binding.get().getRoot();
    }

    private void register() {
        User user = new User();
        user.setPassword(binding.get().tietEmail.getText().toString());
        user.setEmail(binding.get().tietName.getText().toString());
        authViewModel.auth(getActivity(),user).observe(getViewLifecycleOwner(),v->{
            if(v){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        authViewModel = ViewModelProviders.of(this,viewModelFactory).get(AuthViewModel.class);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}