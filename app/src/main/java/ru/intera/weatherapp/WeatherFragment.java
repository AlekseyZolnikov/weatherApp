package ru.intera.weatherapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.TextView;


public class WeatherFragment extends Fragment {

    private TextView textView;
    private TextView tempValue;
    private TextView tempLabel;
    private TextView speedValue;
    private TextView speedLabel;
    private TextView pressureValue;
    private TextView pressureLabel;
    private TextView humidityValue;
    private TextView humidityLabel;

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_weather, container, false);

        textView = fragmentView.findViewById(R.id.weather_title_city);

        tempValue = fragmentView.findViewById(R.id.weather_temp_value);
        tempLabel = fragmentView.findViewById(R.id.weather_temp_label);
        tempValue.setVisibility(View.INVISIBLE);
        tempLabel.setVisibility(View.INVISIBLE);

        speedValue = fragmentView.findViewById(R.id.weather_speed_value);
        speedLabel = fragmentView.findViewById(R.id.weather_speed_label);
        speedValue.setVisibility(View.INVISIBLE);
        speedLabel.setVisibility(View.INVISIBLE);

        pressureValue = fragmentView.findViewById(R.id.weather_pressure_value);
        pressureLabel = fragmentView.findViewById(R.id.weather_pressure_label);
        pressureValue.setVisibility(View.INVISIBLE);
        pressureLabel.setVisibility(View.INVISIBLE);

        humidityValue = fragmentView.findViewById(R.id.weather_humidity_value);
        humidityLabel = fragmentView.findViewById(R.id.weather_humidity_label);
        humidityValue.setVisibility(View.INVISIBLE);
        humidityLabel.setVisibility(View.INVISIBLE);

        if(getArguments() != null) {
            String str = getArguments().getString(WeatherActivity.EXTRA_CITY_KEY);
            boolean checkboxTempValue = getArguments().getBoolean(WeatherActivity.EXTRA_TEMP_KEY, false);
            boolean checkboxSpeedValue = getArguments().getBoolean(WeatherActivity.EXTRA_SPEED_KEY, false);
            boolean checkboxPressureValue = getArguments().getBoolean(WeatherActivity.EXTRA_PRESSURE_KEY, false);
            boolean checkboxHumidityValue = getArguments().getBoolean(WeatherActivity.EXTRA_HUMIDITY_KEY, false);
            textView.setText(str);
            if (checkboxTempValue) {
                tempValue.setVisibility(View.VISIBLE);
                tempLabel.setVisibility(View.VISIBLE);
            }
            if (checkboxSpeedValue) {
                speedValue.setVisibility(View.VISIBLE);
                speedLabel.setVisibility(View.VISIBLE);
            }
            if (checkboxPressureValue) {
                pressureValue.setVisibility(View.VISIBLE);
                pressureLabel.setVisibility(View.VISIBLE);
            }
            if (checkboxHumidityValue) {
                humidityValue.setVisibility(View.VISIBLE);
                humidityLabel.setVisibility(View.VISIBLE);
            }
        }
        return fragmentView;
    }

}
