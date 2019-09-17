package com.example.shovan.texttospeech;


import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener  {

    TextToSpeech tts;
    private EditText write;
    private Button playBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tts = new TextToSpeech(this,this);

        write = (EditText)findViewById(R.id.edit);
        playBtn = (Button)findViewById(R.id.speak);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
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
        String sText2= null;

        String sText = write.getText().toString();
        /*Translate.setHttpReferrer("http://android-er.blogspot.com/");
        try {
            //sText2 = Translate.execute(sText, Language.ENGLISH, Language.JAPANESE);

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        tts.speak(sText,TextToSpeech.QUEUE_FLUSH,null);
    }

}
