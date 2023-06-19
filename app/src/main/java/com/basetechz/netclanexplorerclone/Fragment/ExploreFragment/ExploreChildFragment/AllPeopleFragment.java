package com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreChildFragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.basetechz.netclanexplorerclone.Adapter.UsersAdapter;
import com.basetechz.netclanexplorerclone.R;
import com.basetechz.netclanexplorerclone.databinding.FragmentAllPeopleBinding;

import java.util.ArrayList;

import com.basetechz.netclanexplorerclone.Models.model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AllPeopleFragment extends Fragment {

    public AllPeopleFragment() {
        // Required empty public constructor
    }

    FragmentAllPeopleBinding binding;
    private int progressValue = 0;

    ArrayList<model> modelArrayList = new ArrayList<>();
    UsersAdapter usersAdapter;
    androidx.appcompat.widget.SearchView searchView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAllPeopleBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);

        // LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.peopleRecycler.setLayoutManager(layoutManager);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("AllUsers");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelArrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    model model = dataSnapshot.getValue(com.basetechz.netclanexplorerclone.Models.model.class);
                    modelArrayList.add(model);
                }
                usersAdapter = new UsersAdapter(modelArrayList, getContext());
                binding.peopleRecycler.setAdapter(usersAdapter);
                usersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(requireContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return binding.getRoot();
    }

    private void filteredList(String newText) {
        // Filter the ArrayList based on the search query
        ArrayList<model> filteredList = new ArrayList<>();
        for (model model : modelArrayList) {
            if (model.getName().toLowerCase().contains(newText.toLowerCase()) && !filteredList.contains(model)) {
                filteredList.add(model);
            }
        }
        // Update the RecyclerView adapter with the filtered data
        if (filteredList.isEmpty()) {
            Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
        } else {
            usersAdapter.setFilter(filteredList);
        }
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_items, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();

        // Set the query text listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle search query submission if needed
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the ArrayList based on the search query
                filteredList(newText);

                return true;
            }
        });

        // Get the search AutoCompleteTextView
        SearchView.SearchAutoComplete searchAutoComplete = searchView.findViewById(androidx.appcompat.R.id.search_src_text);

        // Change the search text color
        searchAutoComplete.setTextColor(Color.WHITE);

        // Change the hint and hit text color
        searchAutoComplete.setHintTextColor(Color.WHITE);
        searchAutoComplete.setHighlightColor(Color.WHITE);

        // Set the hint text
        searchView.setQueryHint("Search.."); // Replace "search" with your desired hint text

        // Change the close button color
        ImageView closeButton = searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        closeButton.setColorFilter(Color.WHITE);

        // Change the back button color
        int backButtonId = androidx.appcompat.R.id.search_mag_icon;
        ImageView backButton = searchView.findViewById(backButtonId);
        if (backButton != null) {
            backButton.setColorFilter(Color.WHITE);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_search) {
            // Handle search action here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
