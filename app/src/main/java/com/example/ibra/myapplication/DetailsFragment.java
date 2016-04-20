package com.example.ibra.myapplication;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    TextView tvName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_details, container, false);
        tvName = (TextView) fragment.findViewById(R.id.tvName);
        //Get the selected "name" from the received "extras" bundle
        String name = getArguments().getString("name");
        tvName.setText("");

        tvName.setText("Welcome " + name);
        return fragment;
    }


}
