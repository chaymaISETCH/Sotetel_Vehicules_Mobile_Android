package com.example.chayma.sotetel_vehicule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.vehicules) {

           Intent intent_next = new Intent(menu.this,ListVehicule.class);
           startActivity(intent_next);
           overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
           finish();

        } else if (id == R.id.visites) {

           Intent intent_next = new Intent(menu.this,ListVisite.class);
           startActivity(intent_next);
           overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
           finish();
        }
       else if (id == R.id.maintenance) {
           Intent intent_next = new Intent(menu.this,ListMaintenance.class);
           startActivity(intent_next);
           overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
           finish();
        } else if (id == R.id.assurance) {
           Intent intent_next = new Intent(menu.this,ListAssurance.class);
           startActivity(intent_next);
           overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
           finish();
       }
       else if (id == R.id.employe) {
           Intent intent_next = new Intent(menu.this,ListEmploye.class);
           startActivity(intent_next);
           overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
           finish();
       }
       else if (id == R.id.carte) {
           Intent intent_next = new Intent(menu.this,ListCarte.class);
           startActivity(intent_next);
           overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
           finish();
       }
        /*
  if (id == R.id.nav_camara) {
            // Handle the camera action
        }
        } else if (id == R.id.nav_send) {

        }
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
