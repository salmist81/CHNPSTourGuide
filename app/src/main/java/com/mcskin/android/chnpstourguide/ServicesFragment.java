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
public class ServicesFragment extends Fragment {


    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.service_list, container, false);

        //Create a list of services
        final ArrayList<Service> services = new ArrayList<Service>();
        services.add(new Service(getString(R.string.daycare), getString(R.string.daycare_note),getString(R.string.daycare_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.breakfast), getString(R.string.breakfast_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.afterschool), getString(R.string.afterschool_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.teatime), getString(R.string.teatime_note),getString(R.string.library_description),R.drawable.nursery));
        services.add(new Service(getString(R.string.holiday), getString(R.string.holiday_note),getString(R.string.library_description), R.drawable.nursery));
        services.add(new Service(getString(R.string.special), getString(R.string.special_note),getString(R.string.library_description), R.drawable.nursery));


        ServiceAdapter adapter = new ServiceAdapter(getActivity(), services, R.color.category_services);
        //we have to create a custom Adapter(ServiceApter)
        // that will inherit behavior from the ArrayAdapter class and replace the ArrayAdapter


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // {@link ListView} will display list items for each service in the list of services.
        listView.setAdapter(adapter);

        return rootView;

    }

}
