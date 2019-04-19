package ru.intera.weatherapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.TextView;


public class WeatherFragment extends Fragment {

    private TextView textView;
    private View weatherLayout;
    private View speedLayout;
    private View pressureLayout;
    private View humidityLayout;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_weather, container, false);

        textView = fragmentView.findViewById(R.id.weather_title_city);

        weatherLayout = fragmentView.findViewById(R.id.weather_layout);
        weatherLayout.setVisibility(View.GONE);

        speedLayout = fragmentView.findViewById(R.id.speed_layout);
        speedLayout.setVisibility(View.GONE);

        pressureLayout = fragmentView.findViewById(R.id.pressure_layout);
        pressureLayout.setVisibility(View.GONE);

        humidityLayout = fragmentView.findViewById(R.id.humidity_layout);
        humidityLayout.setVisibility(View.GONE);


        if(getArguments() != null) {
            String str = getArguments().getString(WeatherActivity.EXTRA_CITY_KEY);
            boolean checkboxTempValue = getArguments().getBoolean(WeatherActivity.EXTRA_TEMP_KEY, false);
            boolean checkboxSpeedValue = getArguments().getBoolean(WeatherActivity.EXTRA_SPEED_KEY, false);
            boolean checkboxPressureValue = getArguments().getBoolean(WeatherActivity.EXTRA_PRESSURE_KEY, false);
            boolean checkboxHumidityValue = getArguments().getBoolean(WeatherActivity.EXTRA_HUMIDITY_KEY, false);
            textView.setText(str);
            if (checkboxTempValue) {
                weatherLayout.setVisibility(View.VISIBLE);
            }
            if (checkboxSpeedValue) {
                speedLayout.setVisibility(View.VISIBLE);
            }
            if (checkboxPressureValue) {
                pressureLayout.setVisibility(View.VISIBLE);
            }
            if (checkboxHumidityValue) {
                humidityLayout.setVisibility(View.VISIBLE);
            }
        }
        return fragmentView;
    }

}
