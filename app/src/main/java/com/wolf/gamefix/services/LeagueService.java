package com.wolf.gamefix.services;

import com.wolf.gamefix.util.Constants;
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
    private static final String TAG = "LeagueService";

    //get All leagues
    public static void getLeagues(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api-football-v1.p.rapidapi.com/v2/leagues/season/2019").newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", Constants.SPORT_TOKEN)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<League> processGetAllLeaguesResults(Response response) {
        ArrayList<League> allLeagues = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject leaguesJson = new JSONObject(jsonData).getJSONObject("api");
            JSONArray leaguesJsonArray = leaguesJson.getJSONArray("leagues");
            if (response.isSuccessful()) {
                for (int i = 0; i < leaguesJsonArray.length(); i++) {
                    JSONObject leagueJSON = leaguesJsonArray.getJSONObject(i);

                    int leagueId = leagueJSON.getInt("league_id");
                    String name = leagueJSON.getString("name");

                    String country = leagueJSON.getString("country_code");
                    String countryCode = leagueJSON.getString("country_code");
                    int season = leagueJSON.getInt("season");
                    String seasonStart = leagueJSON.getString("season_start");
                    String seasonEnd = leagueJSON.getString("season_end");
                    String logo = leagueJSON.getString("logo");
                    String flag = leagueJSON.getString("flag");
                    int standings = leagueJSON.getInt("standings");
                    int isCurrent = leagueJSON.getInt("is_current");

                    League league = new League(leagueId, countryCode, season, seasonStart, seasonEnd, name, country, logo, flag,standings, isCurrent);
                    allLeagues.add(league);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return allLeagues;
    }


    //get Fixtures
    public static void getFixtures(Callback callback,String leagueId) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api-football-v1.p.rapidapi.com/v2/fixtures/league/"+leagueId).newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", Constants.SPORT_TOKEN)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public ArrayList<Fixture> processGetFixturesResults(Response response) {
        ArrayList<Fixture> allFixture = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject fixturesJson = new JSONObject(jsonData).getJSONObject("api");;
            JSONArray fixturesJsonArray = fixturesJson.getJSONArray("fixtures");
            if (response.isSuccessful()) {
                for (int i = 0; i < fixturesJsonArray.length(); i++) {
                    JSONObject fixtureJSON = fixturesJsonArray.getJSONObject(i);

                    int fixtureId = fixtureJSON.getInt("fixture_id");
                    int leagueId = fixtureJSON.getInt("league_id");
                    String date = fixtureJSON.getString("event_date");
                    long fixtureTimestamp = fixtureJSON.getLong("event_timestamp");
                    long firstHalfStart = fixtureJSON.getLong("firstHalfStart");
                    long secondHalfStart = fixtureJSON.getLong("secondHalfStart");
                    String round = fixtureJSON.getString("round");
                    String status = fixtureJSON.getString("status");
                    String venue = fixtureJSON.getString("venue");
                    String referee = fixtureJSON.getString("referee");

                    String homeTeamId = fixtureJSON.getJSONObject("homeTeam").getString("team_id");
                    String homeName= fixtureJSON.getJSONObject("homeTeam").getString("team_name");
                    String homeTeamLogo = fixtureJSON.getJSONObject("homeTeam").getString("logo");

                    String awayTeamId = fixtureJSON.getJSONObject("awayTeam").getString("team_id");
                    String awayName = fixtureJSON.getJSONObject("awayTeam").getString("team_name");
                    String awayTeamLogo = fixtureJSON.getJSONObject("awayTeam").getString("logo");

                    int goalsHomeTeam = fixtureJSON.getInt("goalsHomeTeam");
                    int goalsAwayTeam = fixtureJSON.getInt("goalsAwayTeam");

                    String halfTime = fixtureJSON.getJSONObject("score").getString("halftime");
                    String fullTime = fixtureJSON.getJSONObject("score").getString("fulltime");
                    String extraTime = fixtureJSON.getJSONObject("score").getString("extratime");
                    String penalty = fixtureJSON.getJSONObject("score").getString("penalty");

                    Fixture fixture = new Fixture( fixtureId, leagueId, fixtureTimestamp,  firstHalfStart, secondHalfStart, round, status, referee,homeTeamId, awayTeamId,  homeTeamLogo, awayTeamLogo, goalsHomeTeam,goalsAwayTeam,halfTime,fullTime, extraTime,  penalty, homeName,  awayName, date, venue);
                    allFixture.add(fixture);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return allFixture;

    }


}