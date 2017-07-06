package com.mcskin.android.chnpstourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomsFragment extends Fragment {


    public RoomsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.service_list, container, false);

        //Create a list of services
        final ArrayList<Service> services = new ArrayList<Service>();
        services.add(new Service(getString(R.string.baby), getString(R.string.baby_note),getString(R.string.baby_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.toddler), getString(R.string.toddler_note),getString(R.string.toddler_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.preschool), getString(R.string.preschool_note),getString(R.string.preschool_description), R.drawable.nursery));
        services.add(new Service(getString(R.string.under8), getString(R.string.under8_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.over8), getString(R.string.over8_note),getString(R.string.library_description),R.drawable.nursery));





        ServiceAdapter adapter = new ServiceAdapter(getActivity(), services, R.color.category_rooms);
        //we have to create a custom Adapter(WordApter)
        // that will inherit behavior from the ArrayAdapter class and replace the ArrayAdapter


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;

    }

}
