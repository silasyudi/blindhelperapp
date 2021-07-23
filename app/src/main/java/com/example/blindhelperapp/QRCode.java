package com.example.blindhelperapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QRCode {

    private Map<String, String> info;

    public QRCode(String raw) throws JSONException {
        info = new LinkedHashMap<>();
        process(raw);
    }

    private void process(String raw) throws JSONException {
        JSONObject json = new JSONObject(raw);

        for (Iterator<String> it = json.keys(); it.hasNext(); ) {
            String key = it.next();
            info.put(key, json.get(key).toString());
        }
    }

    public List<String> toList() {
        return new ArrayList<>(info.keySet());
    }

    public String getInfo(String key) {
        return info.get(key);
    }
}
