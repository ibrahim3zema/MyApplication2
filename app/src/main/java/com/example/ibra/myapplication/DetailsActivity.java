package com.example.ibra.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //Receive the selected namesent Bundle.
        Bundle extras = getIntent().getExtras();
        if (null == savedInstanceState) {
            DetailsFragment mDetailsFragment = new DetailsFragment();
            //Pass the "extras" Bundle that contains the selected "name" to the fragment
            mDetailsFragment.setArguments(extras);
            getFragmentManager().beginTransaction().add(R.id.llDetailsContainer, mDetailsFragment).commit();
        }


    }

}
