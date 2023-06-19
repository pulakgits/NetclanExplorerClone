package com.basetechz.netclanexplorerclone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basetechz.netclanexplorerclone.R;
import com.basetechz.netclanexplorerclone.databinding.FragmentNetworkBinding;

public class NetworkFragment extends Fragment {

    public NetworkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentNetworkBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNetworkBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }
}