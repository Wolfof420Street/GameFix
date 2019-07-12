package com.wolf.gamefix.models;

import java.util.Date;

public class League {
    private int leagueId;
    private String countryCode;
    private int season;
    private String seasonStart;
    private String seasonEnd;
    private int standings;
    private int isCurrent;
    private String mName;
    private String mCountry;
    private int mSeason;
    private String mLogo;
    private String mFlag;

    public League(int leagueId, String countryCode, int season, String seasonStart, String seasonEnd, String name, String country, String logo, String flag, int standings, int isCurrent) {
        this.mName = name;
        this.mCountry = country;
        this.mSeason = season;
        this.mLogo = logo;
        this.mFlag = flag;
        this.leagueId = leagueId;
        this.standings = standings;
        this.isCurrent = isCurrent;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.countryCode = countryCode;
    }

    public String getName (String name ) {
        return name;
    }
    public String getCountry (String country ) {
        return country;
    }
    public int getSeason (int season) {
        return season;
    }
    public String getLogo (String logo) {
        return logo;
    }
    public String getFlag (String flag) {
        return flag;
    }
    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }
    public void setCountry(String country) {
        this.mCountry = country;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public void setSeason(int season) {
        this.season = season;
    }
    public String getSeasonStart() {
        return seasonStart;
    }

    public void setSeasonStart(String seasonStart) {
        this.seasonStart = seasonStart;
    }

    public String getSeasonEnd() {
        return seasonEnd;
    }

    public void setSeasonEnd(String seasonEnd) {
        this.seasonEnd = seasonEnd;
    }
    public void setFlag(String flag) {
        this.mFlag = flag;
    }
    public int getStandings() {
        return standings;
    }

    public void setStandings(int standings) {
        this.standings = standings;
    }

    public int getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(int isCurrent) {
        this.isCurrent = isCurrent;
    }
}
