package com.example.relaxapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.relaxapp.R;
import com.example.relaxapp.databinding.ActivityMainBinding;
import com.example.relaxapp.db.User;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private User loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loggedUser = (User) getIntent().getSerializableExtra("user");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_feed, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        ImageView customisedHamburger = findViewById(R.id.main_menu_image);
        customisedHamburger.setOnClickListener(lambda -> drawerLayout.openDrawer(Gravity.LEFT));
        setupMainMenu();

        TextView exitTextView = findViewById(R.id.exit_text);
        exitTextView.setOnClickListener(this::exit);
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    private void setupMainMenu() {
        NavigationView navView = findViewById(R.id.main_menu);
        navView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.user_guide: {
                    Intent toReferenceActivity = new Intent(this, UserGuideActivity.class);
                    startActivity(toReferenceActivity);
                    break;
                }
                case R.id.horoscope: {
                    Intent toHoroscopeActivity = new Intent(this, HoroscopeActivity.class);
                    startActivity(toHoroscopeActivity);
                    break;
                }
                case R.id.about: {
                    Intent toDeveloperActivity = new Intent(this, AboutActivity.class);
                    startActivity(toDeveloperActivity);
                    break;
                }
            }
            return true;
        });
    }

    private void exit(View view) {
        Intent goToWelcomeActivity = new Intent(this, WelcomeActivity.class);
        goToWelcomeActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(goToWelcomeActivity);
    }
}