package com.basetechz.netclanexplorerclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.basetechz.netclanexplorerclone.Fragment.ChatFragment;
import com.basetechz.netclanexplorerclone.Fragment.ContactsFragment;
import com.basetechz.netclanexplorerclone.Fragment.ExploreFragment.ExploreFragment;
import com.basetechz.netclanexplorerclone.Fragment.NetworkFragment;
import com.basetechz.netclanexplorerclone.Fragment.RefineFragment;
import com.basetechz.netclanexplorerclone.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        // Customize the app name color
        int titleTextColor = getResources().getColor(android.R.color.white);
        toolbar.setTitleTextColor(titleTextColor);


        // click item preform operation
       binding.bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id = item.getItemId();

               if(id == R.id.refine){

                   loadFragment(new RefineFragment(), false);
               } else if (id == R.id.explore) {

                   loadFragment(new ExploreFragment(), false);
               } else if (id == R.id.network) {

                   loadFragment(new NetworkFragment(), false);
               } else if (id == R.id.chat) {

                   loadFragment(new ChatFragment(), false);
               } else if (id == R.id.contacts) {

                   loadFragment(new ContactsFragment(), false);
               }
               return true;
           }
       });
       binding.bnView.setSelectedItemId(R.id.explore);
    }
    private void loadFragment(Fragment fragment , boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag){
            ft.add(R.id.fragmentContainer, fragment);
        }else {
            ft.replace(R.id.fragmentContainer, fragment);
        }
        ft.commit();
    }
}