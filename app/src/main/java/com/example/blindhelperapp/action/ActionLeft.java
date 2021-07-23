package com.example.blindhelperapp.action;

import android.widget.ListView;

import com.example.blindhelperapp.QRCode;
import com.example.blindhelperapp.ScanService;
import com.example.blindhelperapp.TextToSpeechService;

public class ActionLeft extends ActionStrategy {

    @Override
    protected void runAction(ListView v, QRCode qrCode) {
        TextToSpeechService.speak(ScanService.PROMPT);
        ScanService.run();
    }
}
