package com.example.alonavigationdrawer;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Filme implements Serializable {
    @SerializedName("_id")
    private String id;
    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;
    private String href;
    private String extract;
    private String thumbnail;
    private int thumbnailWidth;
    private int thumbnailHeight;

    // Constructor
    public Filme(String id, String title, int year, List<String> cast, List<String> genres, String href, String extract, String thumbnail, int thumbnailWidth, int thumbnailHeight) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.cast = cast;
        this.genres = genres;
        this.href = href;
        this.extract = extract;
        this.thumbnail = thumbnail;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getExtract() {
        return extract;
    }

    public void setExtract(String extract) {
        this.extract = extract;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", cast=" + cast +
                ", genres=" + genres +
                ", href='" + href + '\'' +
                ", extract='" + extract + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", thumbnailWidth=" + thumbnailWidth +
                ", thumbnailHeight=" + thumbnailHeight +
                '}';
    }
}