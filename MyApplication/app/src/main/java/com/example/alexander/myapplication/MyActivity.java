package com.example.alexander.myapplication;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import static android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        android.app.ActionBar actionbar = getActionBar();
        if (actionbar != null) {
            actionbar.setNavigationMode(NAVIGATION_MODE_TABS);
        }

        android.app.ActionBar.Tab tab1 = actionbar.newTab().setText("Tab 1");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab1);

        android.app.ActionBar.Tab tab2 = actionbar.newTab().setText("Tab 2");
        tab2.setTabListener(new MyTabListener());
        actionbar.addTab(tab2);

        android.app.ActionBar.Tab tab3 = actionbar.newTab().setText("Tab 3");
        tab3.setTabListener(new MyTabListener());
        actionbar.addTab(tab3);
    }


    public static class MyActivity extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_item_grid);
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new PlaceholderFragment())
                        .commit();
            }
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.action_settings:
                    settings();
                    return true;
                case R.id.action_search:
                    search();
                    return true;
                case R.id.action_add:
                    add();
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }

        private void add() {
            Toast toast = Toast.makeText(this, "Adding", Toast.LENGTH_SHORT);
            toast.show();
        }

        private void search() {
            Toast toast = Toast.makeText(this, "Search", Toast.LENGTH_SHORT);
            toast.show();
        }

        private void settings() {
            Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            toast.show();
        }

        /**
         * A placeholder fragment containing a simple view.
         */
        public static class PlaceholderFragment extends Fragment {

            public PlaceholderFragment() {
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_item_grid, container, false);
                return rootView;
            }
        }
    }
}