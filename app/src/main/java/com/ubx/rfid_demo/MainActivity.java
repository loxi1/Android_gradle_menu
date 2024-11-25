package com.ubx.rfid_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private String[] menuItems = {"Escanear", "Configurar", "Salir"};
    private int[] menuIcons = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3};  // Aquí se pasan los iconos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.drawer_list);

        // Configurar el adaptador del menú lateral
        DrawerAdapter adapter = new DrawerAdapter(this, menuItems, menuIcons);
        drawerList.setAdapter(adapter);

        // Configurar el ActionBarDrawerToggle para abrir/cerrar el Drawer
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_close
        );

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Configurar la acción de abrir/cerrar el Drawer al hacer click en el icono del ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
}