package com.zubchenok.mtghelper.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.zubchenok.mtghelper.R;
import com.zubchenok.mtghelper.model.CardResponse;
import com.zubchenok.mtghelper.model.SetResponse;
import com.zubchenok.mtghelper.network.RetrofitClient;
import com.zubchenok.mtghelper.network.requests.GetCardRequest;
import com.zubchenok.mtghelper.network.requests.GetSetRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationDrawer();
        sendCardRequest();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_show_set:
                break;
            default:
                throw new IllegalStateException("Navigation Drawer: no handling implementation for menu item");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
        getMenuInflater().inflate(R.menu.main, menu);
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

    private void initNavigationDrawer() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void sendSetRequest() {
        GetSetRequest request = RetrofitClient.getRetrofit().create(GetSetRequest.class);
        request.getSet("ktk").enqueue(new Callback<SetResponse>() {
            @Override
            public void onResponse(Call<SetResponse> call, Response<SetResponse> response) {
                SetResponse set = response.body();
                TextView textView = (TextView) findViewById(R.id.set_text);
                textView.setText(set.getSet().getName());
            }

            @Override
            public void onFailure(Call<SetResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendCardRequest() {
        GetCardRequest request = RetrofitClient.getRetrofit().create(GetCardRequest.class);
        request.getCard(386616).enqueue(new Callback<CardResponse>() {
            @Override
            public void onResponse(Call<CardResponse> call, Response<CardResponse> response) {
                CardResponse card = response.body();
                TextView textView = (TextView) findViewById(R.id.set_text);
                textView.setText(card.getCard().getName());
            }

            @Override
            public void onFailure(Call<CardResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
