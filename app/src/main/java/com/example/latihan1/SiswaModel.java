package com.example.latihan1;

import java.io.Serializable;

public class SiswaModel implements Serializable {
    String nama;
    String absen;
    String alamat;
    int imageuser;
    String detailInfo;

    public SiswaModel(String nama, String alamat, String absen, int imageuser, String detailInfo) {
        this.nama = nama;
        this.alamat = alamat;
        this.absen = absen;
        this.imageuser = imageuser;
        this.detailInfo = detailInfo;
    }

    // Getter tetap sama
    public int getImageuser() {
        return imageuser;
    }

    public String getNama() {
        return nama;
    }

    public String getAbsen() {
        return absen;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getDetailInfo() {
        return detailInfo;
    }
}