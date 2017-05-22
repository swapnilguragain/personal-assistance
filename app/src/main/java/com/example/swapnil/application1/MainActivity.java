package com.example.swapnil.application1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

//    FragmentManager manager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        manager = getSupportFragmentManager();
//
//        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.mainDrawer);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
//
//        setSupportActionBar(toolbar);
//
//        ActionBarDrawerToggle drawerToogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
//        drawerLayout.addDrawerListener(drawerToogle);
//        drawerToogle.syncState();
//
//        manager.beginTransaction().replace(R.id.fragmentHolder, new Home()).commit();
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.addwork:
//                        manager.beginTransaction().replace(R.id.fragmentHolder, new Work()).commit();
//                        break;
//                }
//
//                drawerLayout.closeDrawers();
//                return true;
//            }
//        });



    }

}
