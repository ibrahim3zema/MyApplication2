package com.example.ibra.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity implements NameListener {
    boolean mTwopane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout flpanel2 = (FrameLayout) findViewById(R.id.flPanel_two);
        if (null == flpanel2) {
            mTwopane = false;
        } else {
            mTwopane = true;
        }
        if (null == savedInstanceState) {
            ListFragment fragment = new ListFragment();
            fragment.setNameListener(this);
            getFragmentManager().beginTransaction().add(R.id.flPanel_One, fragment).commit();
        }
    }

    @Override
    public void setSelectedName(String name) {
        //Case Two Pane UI
        if (mTwopane) {
            DetailsFragment detailsFragment= new DetailsFragment();
            Bundle extras= new Bundle();
            extras.putString("name", name);
            detailsFragment.setArguments(extras);
            getFragmentManager().beginTransaction().replace(R.id.flPanel_two,detailsFragment).commit();
        } else {
            //Case Single Pane UI
            Intent i = new Intent(this, DetailsActivity.class);
            i.putExtra("name", name);
            startActivity(i);
        }
    }
}
