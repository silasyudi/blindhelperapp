package com.example.blindhelperapp;

import android.app.Activity;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class TextToSpeechService {

    private static TextToSpeech textToSpeech;

    public static void initialize(Activity activity) {
        textToSpeech = new TextToSpeech(activity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.forLanguageTag("pt_BR"));
                }
            }
        });
    }

    public static void speak(String text) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }
}
