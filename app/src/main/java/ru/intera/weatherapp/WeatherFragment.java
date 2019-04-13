package ru.intera.weatherapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;


public class WeatherFragment extends Fragment {

    private TextView textView;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_weather, container, false);

        textView = fragmentView.findViewById(R.id.weather_title_city);
        if(getArguments() != null) {
            String str = getArguments().getString(WeatherActivity.EXTRA_CITY_KEY);
            textView.setText(str);
        }
        return fragmentView;
    }

}
