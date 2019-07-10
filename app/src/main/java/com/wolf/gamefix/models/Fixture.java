package com.wolf.gamefix.models;

import java.util.Date;

public class Fixture {
    private String mHomeName;
    private String mAwayName;
    private Date mDate;
    private String mScore;
    private String mVenue;

    public Fixture(String homeName, String awayName, Date date, String score, String venue) {
        this.mAwayName = awayName;
        this.mDate = date;
        this.mScore = score;
        this.mHomeName = homeName;
        this.mVenue = venue;
    }

    public String getHomeName (String homeName ) {
        return homeName;
    }
    public String getAwayName (String awayName ) {
        return awayName;
    }
    public Date getDate (Date date) {
        return date;
    }
    public String getVenue (String venue) {
        return venue;
    }
    public String getScore (String score) {
        return score;
    }


}

