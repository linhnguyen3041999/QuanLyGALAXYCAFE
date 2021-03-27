package com.galaxy.entity;

public class SanPham {

    private String maSP;
    private String tenSP;
    private String hinh;
    private Double donGia;
    private int soLuong;
    private String maNCC;
    private String maLH;

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, String hinh, Double donGia, int soLuong, String maNCC, String maLH) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hinh = hinh;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.maNCC = maNCC;
        this.maLH = maLH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

}
