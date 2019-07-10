package com.wolf.gamefix.services;

import com.wolf.gamefix.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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

}
