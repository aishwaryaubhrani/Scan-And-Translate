package com.example.scanandtranslate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class Result_Class extends AppCompatActivity {
    String text = "", translated="";
    TextView textView;
    Button translate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__class);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        text = bundle.getString("result").toLowerCase();

        textView = findViewById(R.id.textView2);
        translate = findViewById(R.id.button2);
        textView.setText(text.toString());
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAPI translateAPI = new TranslateAPI(Language.AUTO_DETECT,   //Source Language
                        Language.HINDI,         //Target Language
                        text);

                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        translated = translatedText;
                        Log.d("tag", "onSuccess: "+translatedText);
                        Intent i = new Intent(getApplicationContext(), Translated_result.class);
                        i.putExtra("translated", translated);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(String ErrorText) {
                        Log.d("tag", "onFailure: "+ErrorText);
                    }
                });
            }
        });


    }
}
