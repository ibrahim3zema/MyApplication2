package com.example.ibra.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    ArrayList<String> mNamesList;
    NameListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_list, container, false);
        ListView lvNames = (ListView) fragment.findViewById(R.id.lvItems);
        //Fill the names list with dummy data
        mNamesList = new ArrayList<>();
        mNamesList.add("Eslam");
        mNamesList.add("Karim");
        mNamesList.add("Moaz");
        mNamesList.add("Ola");
        mNamesList.add("Yehia");
        mNamesList.add("Ahmed");
        mNamesList.add("Mahmoud");
        mNamesList.add("Salah");
        mNamesList.add("Mona");
        mNamesList.add("Eman");
        mNamesList.add("Marwa");
        mNamesList.add("Amal");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, mNamesList);
        lvNames.setAdapter(adapter);
        lvNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Start Details Activity with selected Name
                String selectedName = mNamesList.get(position);
                mListener.setSelectedName(selectedName);

            }
        });
        return fragment;
    }

    public void setNameListener(NameListener nameListener) {
      mListener=nameListener;
    }
}
