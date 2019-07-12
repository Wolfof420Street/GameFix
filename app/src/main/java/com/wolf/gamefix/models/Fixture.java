package com.wolf.gamefix.models;

public class Fixture {
    private int fixtureId;
    private int leagueId;
    private long fixtureTimestamp;
    private long firstHalfStart;
    private long secondHalfStart;
    private String round;
    private String status;
    private String referee;
    private String homeTeamId;
    private String awayTeamId;
    private String halfTime;
    private String fullTime;
    private String extraTime;
    private String penalty;
    private String awayTeamLogo;
    private String homeTeamLogo;
    private int goalsHomeTeam;
    private int goalsAwayTeam;
    private String mHomeName;
    private String mAwayName;
    private String mDate;
    private String mVenue;

    public Fixture(int fixtureId, int leagueId, long fixtureTimestamp,  long firstHalfStart, long secondHalfStart, String round,  String status, String referee,String homeTeamId, String awayTeamId, String homeTeamLogo, String awayTeamLogo, int goalsHomeTeam, int goalsAwayTeam, String halfTime, String fullTime, String extraTime, String penalty, String homeName, String awayName, String date, String venue) {
        this.mAwayName = awayName;
        this.mDate = date;
        this.mHomeName = homeName;
        this.mVenue = venue;
        this.fixtureId = fixtureId;
        this.leagueId = leagueId;
        this.firstHalfStart = firstHalfStart;
        this.secondHalfStart = secondHalfStart;
        this.round = round;
        this.status = status;
        this.referee = referee;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        this.halfTime = halfTime;
        this.fullTime = fullTime;
        this.extraTime = extraTime;
        this.penalty = penalty;
        this.fixtureTimestamp = fixtureTimestamp;
        this.awayTeamLogo = awayTeamLogo;
        this.homeTeamLogo = homeTeamLogo;
    }

    public String getHomeName (String homeName ) {
        return homeName;
    }
    public String getAwayName (String awayName ) {
        return awayName;
    }
    public String getVenue (String venue) {
        return venue;
    }

    public int getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }
    public int getLeagueId() {
        return leagueId;
    }
    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
    public String getFixtureDate() {
        return mDate;
    }

    public void setFixtureDate(String date) {
        this.mDate = date;
    }
    public long getFixtureTimestamp() {
        return fixtureTimestamp;
    }
    public void setFixtureTimestamp(long fixtureTimestamp) {
        this.fixtureTimestamp = fixtureTimestamp;
    }
    public long getFirstHalfStart() {
        return firstHalfStart;
    }
    public void setFirstHalfStart(long firstHalfStart) {
        this.firstHalfStart = firstHalfStart;
    }
    public long getSecondHalfStart() {
        return secondHalfStart;
    }

    public void setSecondHalfStart(long secondHalfStart) {
        this.secondHalfStart = secondHalfStart;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setVenue(String venue) {
        this.mVenue = venue;
    }
    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }
    public String getHomeTeamLogo() {
        return homeTeamLogo;
    }
    public String getAwayTeamLogo() {return awayTeamLogo;}

    public void setHomeTeamLogo(String homeTeamLogo) {
        this.homeTeamLogo = homeTeamLogo;
    }
    public String getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(int goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(int goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public String getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(String halfTime) {
        this.halfTime = halfTime;
    }

    public String getFullTime() {
        return fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }

    public String getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(String extraTime) {
        this.extraTime = extraTime;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }
}


