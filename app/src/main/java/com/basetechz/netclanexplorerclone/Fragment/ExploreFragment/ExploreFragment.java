package com.basetechz.netclanexplorerclone.Fragment.ExploreFragment;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.basetechz.netclanexplorerclone.Adapter.ViewPagerAdapter;
import com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreChildFragment.AllPeopleFragment;
import com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreChildFragment.JobFragment;
import com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreChildFragment.StoreFragment;
import com.basetechz.netclanexplorerclone.R;
import com.basetechz.netclanexplorerclone.databinding.FragmentExploreBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class ExploreFragment extends Fragment {

    public ExploreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentExploreBinding binding;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Boolean isAllFABVisible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExploreBinding.inflate(getLayoutInflater());

        // Tabbed Activity
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        // viewPagerAdapter
        viewPagerAdapter.AddFragment(new AllPeopleFragment(),"");
        viewPagerAdapter.AddFragment(new JobFragment(),"");
        viewPagerAdapter.AddFragment(new StoreFragment(),"");

        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.tab.setupWithViewPager(binding.viewPager);

        binding.tab.getTabAt(0).setIcon(R.drawable.baseline_people_24);
        binding.tab.getTabAt(1).setIcon(R.drawable.job);
        binding.tab.getTabAt(2).setIcon(R.drawable.store);



        // Floating Action Button  function
        FloatingActionButton fab = binding.addFab;
        Drawable drawable = getResources().getDrawable(R.drawable.baseline_add_24);
        drawable.setColorFilter(ContextCompat.getColor(requireContext(), R.color.white), PorterDuff.Mode.SRC_IN);
        fab.setImageDrawable(drawable);


        // Floating Action Button
        binding.notesFab.setVisibility(View.GONE);
        binding.notesFabText.setVisibility(View.GONE);

        // now make the boolean variable as false
        isAllFABVisible = false;

        // add click listener to the ex FAB'S
        binding.addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isAllFABVisible){
                    binding.notesFab.show();
                    binding.notesFabText.setVisibility(View.VISIBLE);

                    Drawable drawableCross = getResources().getDrawable(R.drawable.cross);
                    drawableCross.setColorFilter(ContextCompat.getColor(requireContext(), R.color.white), PorterDuff.Mode.SRC_IN);
                    fab.setImageDrawable(drawableCross);

                    isAllFABVisible = true;
                }else{
                    // hide sub FAB's
                    binding.notesFabText.setVisibility(View.GONE);
                    binding.notesFab.hide();
                    fab.setImageDrawable(drawable);
                    isAllFABVisible = false;
                }
            }
        });

        // click Listener on the SUB FAB's
        binding.notesFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Click NOtes", Toast.LENGTH_SHORT).show();
            }
        });





        return binding.getRoot();
    }
}