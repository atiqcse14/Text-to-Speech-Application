package com.example.shovan.texttospeech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    private RadioGroup radioGrp1;
    private RadioButton radioBtn1;

    private Button nextBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        radioGrp1 =(RadioGroup)findViewById(R.id.radiogrp);
        nextBtn1 = (Button)findViewById(R.id.nextBtn);

        nextBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGrp1.getCheckedRadioButtonId();

                radioBtn1 = (RadioButton)findViewById(id);

                String text = (String) radioBtn1.getText();


                if(text.equals(" English"))
                    startActivity(new Intent(StartActivity.this,EnglishActivity.class));

                else if(text.equals(" Chinese"))
                    startActivity(new Intent(StartActivity.this,ChineseActivity.class));

                else if(text.equals(" Canada"))
                    startActivity(new Intent(StartActivity.this,CanadaActivity.class));

                else if(text.equals(" French"))
                    startActivity(new Intent(StartActivity.this,FrenchActivity.class));

                else if(text.equals(" German"))
                    startActivity(new Intent(StartActivity.this,GermanActivity.class));

                else if(text.equals(" Japanese"))
                    startActivity(new Intent(StartActivity.this,ChineseActivity.class));

                else if(text.equals(" Korean"))
                    startActivity(new Intent(StartActivity.this,ChineseActivity.class));

                else if(text.equals(" Italy"))
                    startActivity(new Intent(StartActivity.this,ChineseActivity.class));
            }
        });

    }
}
