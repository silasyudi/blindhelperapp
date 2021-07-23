package com.example.blindhelperapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.blindhelperapp.action.Action;
import com.example.blindhelperapp.touchevent.TouchListener;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TouchListener touchListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lista);
        touchListener = new TouchListener();

        TextToSpeechService.initialize(this);
        ScanService.setActivity(this);
        ScanService.run();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String scanResult = ScanService.getResult(requestCode, resultCode, data);

        if (scanResult == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        try {
            QRCode information = new QRCode(scanResult);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    information.toList()
            );

            listView.setAdapter(arrayAdapter);
            listView.setOnTouchListener(touchListener);

            touchListener.setInformationQRCode(information);
            touchListener.runAction(listView, Action.RIGHT);
        } catch (Exception e) {
            TextToSpeechService.speak("QR Code no formato inválido. " + ScanService.PROMPT);
            ScanService.run();
        }
    }
}
