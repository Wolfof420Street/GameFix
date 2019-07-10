package com.wolf.gamefix.services;

import com.wolf.gamefix.Constants;
import com.wolf.gamefix.models.Fixture;
import com.wolf.gamefix.models.League;

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

public class LeagueService {
    public static void findSeason(String Season, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.LEAGUE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SPORT_SEASON_QUERY_PARAMETER, Season);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header("X-RapidAPI-Key", Constants.SPORT_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public ArrayList<League> processResults(Response response) {
        ArrayList<League> leagues = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject leagueJSON = new JSONObject(jsonData);
            JSONArray resultsJSON = leagueJSON.getJSONArray("results");
            if (response.isSuccessful()) {
                for (int i = 0; i < leagueJSON.length(); i++) {
                    JSONObject leaguesJSON = resultsJSON.getJSONObject(i);
                    String name = leaguesJSON.getString("name");
                    String country = leaguesJSON.getString("country");
                    String season = leaguesJSON.getString("season");
                    String logo = leaguesJSON.getString("logo");
                    String flag = leaguesJSON.getString("flag");

                    League league = new League(name, country, season, logo, flag);
                    leagues.add(league);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return leagues;
    }
}

