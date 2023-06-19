package com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreChildFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basetechz.netclanexplorerclone.R;
import com.basetechz.netclanexplorerclone.databinding.FragmentJobBinding;

public class JobFragment extends Fragment {


    public JobFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentJobBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJobBinding.inflate(getLayoutInflater());

        return binding.getRoot();
    }
}