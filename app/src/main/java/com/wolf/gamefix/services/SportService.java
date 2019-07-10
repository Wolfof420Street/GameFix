package com.wolf.gamefix.services;

import com.wolf.gamefix.Constants;
import com.wolf.gamefix.models.Fixture;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SportService {


    public void findFixtures(String date, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.SPORT_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SPORT_DATE_QUERY_PARAMETER, date);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("X-RapidAPI-Key", Constants.SPORT_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Fixture> processResults(Response response) {
        ArrayList<Fixture> fixtures = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject sportJSON = new JSONObject(jsonData);
            JSONArray resultsJSON = sportJSON.getJSONArray("results");
            if (response.isSuccessful()) {
                for (int i = 0; i < sportJSON.length(); i++) {
                    JSONObject fixturesJSON = resultsJSON.getJSONObject(i);
                    String homeName = fixturesJSON.getString("homeName");
                    String awayName = fixturesJSON.getString("awayName");
                    String venue = fixturesJSON.getString("venue");
                    String score = fixturesJSON.getString("score");
                    /*  Date date = fixturesJSON.getJSONObject("date");*/
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return fixtures;
    }
}



