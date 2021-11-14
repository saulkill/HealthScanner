package com.example.healthscanner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.healthscanner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    SaveFragment saveFragment;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }
//    public void onFragmentChange(int fragmentNum) {
//        saveFragment=(SaveFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_main);
//        switch (fragmentNum){
//            case 1 :
//                getSupportFragmentManager().beginTransaction().replace(R.id.nav_view, saveFragment).commit();
//        }
//
//    }

}