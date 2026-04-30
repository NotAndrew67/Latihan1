package com.example.latihan1;
import java.io.Serializable;

public class LaguModel implements Serializable {
    String judul, penyanyi, linkSpotify, linkWiki;
    int imageCover;

    public LaguModel(String judul, String penyanyi, int imageCover, String linkSpotify, String linkWiki) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.imageCover = imageCover;
        this.linkSpotify = linkSpotify;
        this.linkWiki = linkWiki;
    }

    public String getJudul() { return judul; }
    public String getPenyanyi() { return penyanyi; }
    public int getImageCover() { return imageCover; }
    public String getLinkSpotify() { return linkSpotify; }
    public String getLinkWiki() { return linkWiki; }
}