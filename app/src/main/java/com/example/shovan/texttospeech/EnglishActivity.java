package com.example.shovan.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class EnglishActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextToSpeech tts;
    private EditText write;
    private Button playBtn;
    private Button clearBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);


        tts = new TextToSpeech(this,this);

        write = (EditText)findViewById(R.id.Eedit);
        playBtn = (Button)findViewById(R.id.Espeak);
        clearBtn = (Button)findViewById(R.id.Eclear);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write.setText("");
            }
        });
    }
    @Override
    public void onPause(){

        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();

    }
    @Override
    public void onInit(int status) {
        if(status != TextToSpeech.ERROR)
        {
            int result=tts.setLanguage(Locale.ENGLISH);
            if(result== TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)
            {
                Log.e("TTS","This Language is not supported");
            }
            else{
                playBtn.setEnabled(true);
                speakOut();
            }
        }
        else {
            Log.e("TTS","Initialization Failed!!");
        }
    }
    public void speakOut(){
        String sText = write.getText().toString();
        tts.speak(sText,TextToSpeech.QUEUE_FLUSH,null);
    }

}

