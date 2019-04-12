package ru.intera.weatherapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WeatherFragment extends Fragment {

    public static final String BUNDLE_FRAGMENT_KEY = "BUNDLE_FRAGMENT_KEY";
    private TextView textView;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String city = bundle.getString(BUNDLE_FRAGMENT_KEY);

        View fragmentView = inflater.inflate(R.layout.fragment_weather, container, false);

        textView = fragmentView.findViewById(R.id.weather_title_city);
        textView.setText(city);

        return fragmentView;
    }

}
