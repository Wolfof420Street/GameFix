package com.wolf.gamefix.models;

import java.util.Date;

public class League {
    private String mName;
    private String mCountry;
    private String mSeason;
    private String mLogo;
    private String mFlag;

    public League(String name, String country, String season, String logo, String flag) {
        this.mName = name;
        this.mCountry = country;
        this.mSeason = season;
        this.mLogo = logo;
        this.mFlag = flag;
    }

    public String getName (String name ) {
        return name;
    }
    public String getCountry (String country ) {
        return country;
    }
    public String getSeason (String season) {
        return season;
    }
    public String getLogo (String logo) {
        return logo;
    }
    public String getFlag (String flag) {
        return flag;
    }


}
