package ru.intera.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {

    public static final String EXTRA_CITY_KEY = "EXTRA_CITY_KEY";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        textView = findViewById(R.id.weather_title_city);
        Intent intent = getIntent();
        String str = intent.getStringExtra(EXTRA_CITY_KEY);
        textView.setText(str);

    }
}
