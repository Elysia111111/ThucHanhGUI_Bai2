package com.example.mytemperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_f, et_c;
    Button btn_celsius, btn_fahrenheit, btn_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et_f = (EditText) findViewById(R.id.et_f);
        et_c = (EditText) findViewById(R.id.et_c);
        btn_celsius = findViewById(R.id.btn_celsius);
        btn_fahrenheit = findViewById(R.id.btn_fahrenheit);
        btn_clear = findViewById(R.id.btn_clear);

        btn_celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float f = Float.parseFloat(et_f.getText().toString());
                float result = (f - 32) * 5/9;
                et_c.setText(String.valueOf(result));
            }
        });

        btn_fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c = Float.parseFloat(et_c.getText().toString());
                Float result = (c * 9 / 5) + 32;
                et_f.setText(String.valueOf(result));
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_f.setText("");
                et_c.setText("");
            }
        });
    }
}