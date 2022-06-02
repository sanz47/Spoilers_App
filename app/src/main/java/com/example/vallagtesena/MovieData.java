
package com.example.vallagtesena;

public class MovieData {
    private String movieID;
    private String posterID;
    private String title;
    private String genreID;
    private String overview;
    private String rating;

    public MovieData(String movieID, String posterID, String title, String overview, String rating) {
        this.movieID = movieID;
        this.posterID = posterID;
        this.title = title;
        this.overview = overview;
        this.rating = rating;
    }
    public MovieData(){

    }

    public String getMovieID() {
        return movieID;
    }

    public String getPosterID() {
        return posterID;
    }

    public String getTitle() {
        return title;
    }

    public String getGenreID() {
        return genreID;
    }

    public String getOverview() {
        return overview;
    }

    public String getRating() {
        return rating;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public void setPosterID(String posterID) {
        this.posterID = posterID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenreID(String genreID) {
        this.genreID = genreID;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
