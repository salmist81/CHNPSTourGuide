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
public class ActivitiesFragment extends Fragment {


    public ActivitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.service_list, container, false);

        //Create a list of services
        final ArrayList<Service> services = new ArrayList<Service>();
        services.add(new Service(getString(R.string.art), getString(R.string.art_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.fungame), getString(R.string.fungame_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.excursion), getString(R.string.excursion_note),getString(R.string.library_description), R.drawable.nursery));
        services.add(new Service(getString(R.string.outdoor), getString(R.string.outdoor_note),getString(R.string.library_description), R.drawable.nursery));
        services.add(new Service(getString(R.string.music), getString(R.string.music_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.tixileex), getString(R.string.tixileex_note),getString(R.string.library_description),R.drawable.nursery));



        ServiceAdapter adapter = new ServiceAdapter(getActivity(), services, R.color.category_activities);
        //we have to create a custom Adapter(DetailApter)
        // that will inherit behavior from the ArrayAdapter class and replace the ArrayAdapter


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // service_list layout file.
        ListView listView =  rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each detail in the list of services.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;

    }

}
