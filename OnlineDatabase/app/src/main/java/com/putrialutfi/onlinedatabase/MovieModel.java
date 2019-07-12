package com.putrialutfi.onlinedatabase;

import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("title")
    private String judulFilm;

    @SerializedName("poster_path")
    private String posterFilm;

    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public String getPosterFilm() {
        return posterFilm;
    }

    public void setPosterFilm(String posterFilm) {
        this.posterFilm = posterFilm;
    }
}
