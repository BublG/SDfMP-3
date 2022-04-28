package com.example.relaxapp.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.relaxapp.R;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HoroscopeActivity extends AppCompatActivity {
    private TextView horoscopeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);
        horoscopeTextView = findViewById(R.id.horoscope_description);
        setHoroscopeDescription();
    }

    private void setHoroscopeDescription() {
        OkHttpClient client = new OkHttpClient();
        Request request = createHoroscopeRequest();
        new Thread(() -> {
            try {
                Response response = client.newCall(request).execute();
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(response.body().string());
                runOnUiThread(() -> horoscopeTextView.setText(jsonObject.get("description").toString()));
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private Request createHoroscopeRequest() {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody postBody = RequestBody.create(JSON, new JSONObject().toString());
        return new Request.Builder()
                .url("https://sameer-kumar-aztro-v1.p.rapidapi.com/?sign=aquarius&day=today")
                .post(postBody)
                .addHeader("X-RapidAPI-Host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "bc80f622d1msh994f5264b797acdp17ebf0jsnf7f8ae024619")
                .build();
    }
}