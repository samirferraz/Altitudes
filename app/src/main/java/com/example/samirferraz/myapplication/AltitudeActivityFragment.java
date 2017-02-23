package com.example.samirferraz.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.samirferraz.myapplication.database.AltitudeDatabaseHelper;

/**
 * A placeholder fragment containing a simple view.
 */
public class AltitudeActivityFragment extends Fragment {

    private AltitudeDatabaseHelper databaseHelper;

    TextView textView;

    public AltitudeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_altitude, container, false);
        inflate.findViewById(R.id.bt_print_locations).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printLocations(view);
            }
        });
        textView = (TextView) inflate.findViewById(R.id.textResult);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseHelper = new AltitudeDatabaseHelper(getActivity());
    }

    public void printLocations(View v) {
        float lat = -12.9956f;
        float lng = -38.501293f;
        float altitude = databaseHelper.getAltitude(lat, lng);

        textView.setText(String.format("Latitude: %2$.6f Long: %3$.6f Altitude: %1$.3f ",altitude, lat, lng));
        textView.append("\n");
        textView.append(databaseHelper.getPrintableAltitudePoints(lat, lng));
    }
}
/////////////////////////////////////////