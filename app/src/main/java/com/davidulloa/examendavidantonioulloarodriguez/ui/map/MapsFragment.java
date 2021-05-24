package com.davidulloa.examendavidantonioulloarodriguez.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidulloa.examendavidantonioulloarodriguez.R;
import com.davidulloa.examendavidantonioulloarodriguez.binding.FragmentDataBindingComponent;
import com.davidulloa.examendavidantonioulloarodriguez.ui.adapter.EmployeeAdapter;
import com.davidulloa.examendavidantonioulloarodriguez.ui.viewmodel.EmployeViewModel;
import com.davidulloa.examendavidantonioulloarodriguez.util.AutoClearedValue;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

public class MapsFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private EmployeeAdapter.ColaboradorOnclick colaboradorOnClick;
    private RecyclerView recyclerView;

    AutoClearedValue<EmployeeAdapter> adapter;


    private EmployeViewModel employeViewModel;


    private static final String ARG_PARAM1 = "employeId";

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    public static MapsFragment newInstance(int employeId) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, employeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}