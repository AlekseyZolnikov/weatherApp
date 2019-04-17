package ru.intera.weatherapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    public static final String EXTRA_CITY_KEY = "EXTRA_CITY_KEY";
    public static final String EXTRA_TEMP_KEY = "EXTRA_TEMP_KEY";
    public static final String EXTRA_SPEED_KEY = "EXTRA_SPEED_KEY";
    public static final String EXTRA_PRESSURE_KEY = "EXTRA_PRESSURE_KEY";
    public static final String EXTRA_HUMIDITY_KEY = "EXTRA_HUMIDITY_KEY";
    private TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        textView = findViewById(R.id.weather_title_city);
        Intent intent = getIntent();
        String cityField = intent.getStringExtra(EXTRA_CITY_KEY);
        boolean checkboxTempValue = intent.getBooleanExtra(EXTRA_TEMP_KEY, false);
        boolean checkboxSpeedValue = intent.getBooleanExtra(EXTRA_SPEED_KEY, false);
        boolean checkboxPressureValue = intent.getBooleanExtra(EXTRA_PRESSURE_KEY, false);
        boolean checkboxTHumidityValue = intent.getBooleanExtra(EXTRA_HUMIDITY_KEY, false);

        Bundle bundle = new Bundle();
        Fragment fragment = new WeatherFragment();
        bundle.putString(EXTRA_CITY_KEY, cityField );
        bundle.putBoolean(EXTRA_TEMP_KEY, checkboxTempValue );
        bundle.putBoolean(EXTRA_SPEED_KEY, checkboxSpeedValue );
        bundle.putBoolean(EXTRA_PRESSURE_KEY, checkboxPressureValue );
        bundle.putBoolean(EXTRA_HUMIDITY_KEY, checkboxTHumidityValue );

        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_activity_weather, fragment)
                .commit();


    }
}
