package com.example.blindhelperapp;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanService {

    private static Activity activity;
    public static final String PROMPT = "Escaneie um QR Code";

    private ScanService() {
    }
    public static void setActivity(Activity activity) {
        ScanService.activity = activity;
    }

    public static void run() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(ScanService.activity);
        intentIntegrator.setPrompt(PROMPT);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.initiateScan();
    }

    public static String getResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        return intentResult != null ? intentResult.getContents() : null;
    }
}
