package com.basetechz.netclanexplorerclone.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreFragment;
import com.basetechz.netclanexplorerclone.R;
import com.basetechz.netclanexplorerclone.databinding.FragmentRefineBinding;

public class RefineFragment extends Fragment implements View.OnClickListener {

    private FragmentRefineBinding binding;
    private ArrayAdapter<String> adapterItems;
    private String[] colorStringArray = {"Available | Hey Let Us Connect",
            "Away | Stay Discreet And Watch",
            "Busy | Do Not Distrub | Will Catch Up Later",
            "SOS | Emergency! Need Assistance! HELP"};

    public RefineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRefineBinding.inflate(inflater, container, false);

        adapterItems = new ArrayAdapter<>(requireContext(), R.layout.list_item, colorStringArray);
        binding.autoCompleteTxt.setAdapter(adapterItems);

        // seekBarRange implementation
        binding.seekBarRange.setMax(100);
        binding.seekBarRange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateRangeText(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Select Purpose Operation
        binding.optionCoffee.setOnClickListener(this);
        binding.optionBusiness.setOnClickListener(this);
        binding.optionHobbies.setOnClickListener(this);
        binding.optionFriendship.setOnClickListener(this);
        binding.optionMovies.setOnClickListener(this);
        binding.optionDinning.setOnClickListener(this);
        binding.optionDating.setOnClickListener(this);
        binding.optionMatrimony.setOnClickListener(this);


        // save and go to Explore Fragment
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // call navigateFragment method
                navigateFragment();

            }
        });


        return binding.getRoot();
    }

    private void updateRangeText(int progress) {
        String progressText = String.valueOf(progress);
        binding.textViewRange.setText(progressText);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.optionCoffee) {
            updateTextViewBackground(binding.optionCoffee);
        } else if (v.getId() == R.id.optionBusiness) {
            updateTextViewBackground(binding.optionBusiness);
        } else if (v.getId() == R.id.optionHobbies) {
            updateTextViewBackground(binding.optionHobbies);
        } else if (v.getId() == R.id.optionFriendship) {
            updateTextViewBackground(binding.optionFriendship);
        } else if (v.getId() == R.id.optionMovies) {
            updateTextViewBackground(binding.optionMovies);
        } else if (v.getId() == R.id.optionDinning) {
            updateTextViewBackground(binding.optionDinning);
        } else if (v.getId() == R.id.optionDating) {
            updateTextViewBackground(binding.optionDating);
        } else if (v.getId() == R.id.optionMatrimony) {
            updateTextViewBackground(binding.optionMatrimony);
        }
    }

    // select and unselect of textview
    private void updateTextViewBackground(TextView textView) {
        if (textView.isSelected()) {
            textView.setSelected(false);
            textView.setBackgroundResource(R.drawable.text_view_background);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white));
        } else {
            textView.setSelected(true);
            textView.setBackgroundResource(R.drawable.text_view_background_before_click);
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
        }
    }

    // navigate fragment to fragment
    void navigateFragment(){
        ExploreFragment targetFragment = new ExploreFragment();

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, targetFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
