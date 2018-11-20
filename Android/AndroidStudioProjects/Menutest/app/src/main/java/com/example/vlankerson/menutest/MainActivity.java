package com.example.vlankerson.menutest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StringRes;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferencesHelper mSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDefaultFragment();
        mSharedPreferences = new SharedPreferencesHelper(this);
        addEngines();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionSetings:

                getSettingsFragment();
                break;
            case R.id.actionSearch:

                getSearchFragment();
                break;
            case R.id.actionExit:
                onExitPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        getDefaultFragment();
    }

    private void onExitPressed() {
        showMessage(R.string.exit);

        finish();
        System.exit(0);
    }

    private void showMessage(@StringRes int string) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }

    private void getDefaultFragment() {

        DefaultFragment def = new DefaultFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, def)
                .addToBackStack(DefaultFragment.class.getName())
                .commit();
    }

    private void getSettingsFragment() {
        getSupportFragmentManager().popBackStack();
        showMessage(R.string.settings);

        SettingsFragment settings = new SettingsFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, settings)
                .addToBackStack(SettingsFragment.class.getName())
                .commit();
    }

    private void getSearchFragment() {
        getSupportFragmentManager().popBackStack();
        showMessage(R.string.search);

        SearchFragment search = new SearchFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, search)
                .addToBackStack(SettingsFragment.class.getName())
                .commit();
    }

    private void addEngines() {
        mSharedPreferences.addEngine(new Engine(getString(R.string.google), getString(R.string.google_request), true));
        mSharedPreferences.addEngine(new Engine(getString(R.string.yandex), getString(R.string.yandex_request), false));
        mSharedPreferences.addEngine(new Engine(getString(R.string.bing), getString(R.string.bing_request), false));

    }

}
