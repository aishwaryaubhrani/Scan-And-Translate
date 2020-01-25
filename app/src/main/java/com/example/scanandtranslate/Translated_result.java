package com.example.scanandtranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.vision.text.TextBlock;

public class Translated_result extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translated_result);
        textView = findViewById(R.id.textView3);
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        textView.setText(b.getString("translated"));
    }
}
