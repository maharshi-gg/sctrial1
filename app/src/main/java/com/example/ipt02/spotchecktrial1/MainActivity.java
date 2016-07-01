package com.example.ipt02.spotchecktrial1;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
//
//        if(savedInstanceState==null)
//        {
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new MainActivityFragment()).commit();
//        }
//
        FragmentManager fm = getSupportFragmentManager();
        MainActivityFragment fragment = (MainActivityFragment) fm.findFragmentByTag("main_fragment");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment =new MainActivityFragment();
            ft.add(android.R.id.content,fragment,"main_fragment");
            ft.commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

//if(savedInstanceState == null){
//
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment,new MainActivityFragment())
//                    .addToBackStack(null).commit();
//        }
//        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
//            @Override
//            public void onBackStackChanged() {
//                int backCount = getSupportFragmentManager().getBackStackEntryCount();
//                if(backCount==0) finish();
//            }
//        });


