package ru.intera.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private static final String TAG = "MainActivity";
    private static final String KEY_EDIT_TEXT = "KEY_EDIT_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.main_input_city);

        Button button = findViewById(R.id.main_btn_show);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, WeatherActivity.class);
        String str = editText.getText().toString();

        if (str.equals("")) {
            makeToast();
            editText.requestFocus();
            return;
        }

        intent.putExtra(WeatherActivity.EXTRA_CITY_KEY, str);
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
        Log.d(TAG, "onSaveInstanceState: " + str);
        outState.putString(KEY_EDIT_TEXT, str);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String str = savedInstanceState.get(KEY_EDIT_TEXT).toString();
        Log.d(TAG, "onRestoreInstanceState: " + str);
        editText.setText(str);
    }
}
