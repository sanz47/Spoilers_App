package com.example.vallagtesena.placeholder;
public class Movie {

    private String title , poster , overview, ID;
    private Double rating;
    private String srs;

    public Movie(String title , String poster , String overview , Double rating, String ID, String srs){
        this.title = title;
        this.poster = poster;
        this.overview = overview;
        this.rating = rating;
        this.ID=ID;
        this.srs=srs;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getOverview() {
        return overview;
    }

    public Double getRating() {
        return rating;
    }

    public String getID() {
        return ID;
    }

    public String getSrs() {
        return srs;
    }
}