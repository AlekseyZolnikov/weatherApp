package ru.intera.weatherapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private static final String TAG = "MainActivity";
    private static final String KEY_EDIT_TEXT = "KEY_EDIT_TEXT";
    private FrameLayout frameLayout;
    private String cityField;

    private CheckBox checkTemp;
    private CheckBox checkSpeed;
    private CheckBox checkPressure;
    private CheckBox checkHumidity;
    public static final String CHECKBOX_TEMP_KEY = "CHECKBOX_TEMP_KEY";
    public static final String CHECKBOX_SPEED_KEY = "CHECKBOX_SPEED_KEY";
    public static final String CHECKBOX_PRESSURE_KEY = "CHECKBOX_PRESSURE_KEY";
    public static final String CHECKBOX_HUMIDITY_KEY = "CHECKBOX_HUMIDITY_KEY";
    public static boolean checkboxTempValue;
    public static boolean checkboxSpeedValue;
    public static boolean checkboxPressureValue;
    public static boolean checkboxHumidityValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkTemp = findViewById(R.id.checkBox1);
        checkSpeed = findViewById(R.id.checkBox2);
        checkPressure = findViewById(R.id.checkBox3);
        checkHumidity = findViewById(R.id.checkBox4);

        editText = findViewById(R.id.main_input_city);
        frameLayout = findViewById(R.id.frame_layout_activity_weather);
    }
    private void checkOrientation() {
        if (frameLayout != null) {
            showFragment();
        }else {
            startWeatherActivity();
        }
    }

    public void onClick(View view)  {
        cityField = editText.getText().toString();
        checkboxTempValue = checkTemp.isChecked();
        checkboxSpeedValue = checkSpeed.isChecked();
        checkboxPressureValue = checkPressure.isChecked();
        checkboxHumidityValue = checkHumidity.isChecked();

        if (TextUtils.isEmpty(cityField)) {
            makeToast();
            editText.requestFocus();
            return;
        }

        checkOrientation();
    }

    private void showFragment() {
        Bundle bundle = new Bundle();
        Fragment fragment = new WeatherFragment();
        bundle.putString(WeatherActivity.EXTRA_CITY_KEY, cityField );
        bundle.putBoolean(WeatherActivity.EXTRA_TEMP_KEY, checkboxTempValue);
        bundle.putBoolean(WeatherActivity.EXTRA_SPEED_KEY, checkboxSpeedValue);
        bundle.putBoolean(WeatherActivity.EXTRA_PRESSURE_KEY, checkboxPressureValue);
        bundle.putBoolean(WeatherActivity.EXTRA_HUMIDITY_KEY, checkboxHumidityValue);

        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout_activity_weather, fragment)
                .commit();
    }

    private void startWeatherActivity() {
        Intent intent = new Intent(this, WeatherActivity.class);

        intent.putExtra(WeatherActivity.EXTRA_CITY_KEY, cityField);
        intent.putExtra(WeatherActivity.EXTRA_TEMP_KEY, checkboxTempValue);
        intent.putExtra(WeatherActivity.EXTRA_SPEED_KEY, checkboxSpeedValue);
        intent.putExtra(WeatherActivity.EXTRA_PRESSURE_KEY, checkboxPressureValue);
        intent.putExtra(WeatherActivity.EXTRA_HUMIDITY_KEY, checkboxHumidityValue);
        startActivity(intent);
    }

    private void makeToast() {
        Toast toast = Toast.makeText(this, "Введите город", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String str = editText.getText().toString();
        boolean checkbox1 = checkTemp.isChecked();
        boolean checkbox2 = checkSpeed.isChecked();
        boolean checkbox3 = checkPressure.isChecked();
        boolean checkbox4 = checkHumidity.isChecked();
        outState.putString(KEY_EDIT_TEXT, str);
        outState.putBoolean(CHECKBOX_TEMP_KEY, checkbox1);
        outState.putBoolean(CHECKBOX_SPEED_KEY, checkbox2);
        outState.putBoolean(CHECKBOX_PRESSURE_KEY, checkbox3);
        outState.putBoolean(CHECKBOX_HUMIDITY_KEY, checkbox4);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String str = savedInstanceState.getString(KEY_EDIT_TEXT);
        boolean checkbox1 = savedInstanceState.getBoolean(CHECKBOX_TEMP_KEY);
        boolean checkbox2 = savedInstanceState.getBoolean(CHECKBOX_SPEED_KEY);
        boolean checkbox3 = savedInstanceState.getBoolean(CHECKBOX_PRESSURE_KEY);
        boolean checkbox4 = savedInstanceState.getBoolean(CHECKBOX_HUMIDITY_KEY);

        checkTemp.setChecked(checkbox1);
        checkSpeed.setChecked(checkbox2);
        checkPressure.setChecked(checkbox3);
        checkHumidity.setChecked(checkbox4);

        editText.setText(str);


    }

}
