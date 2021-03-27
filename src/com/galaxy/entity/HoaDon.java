package com.galaxy.entity;

import java.util.Date;

public class HoaDon {
    private String maHD;
    private Date ngayLapHD;
    private String maKH;
    private String maNV;
    private String maSP;
    private double donGia;
    private int soLuong;
    private double thanhTien;
    

    public HoaDon() {
    }

    public HoaDon(String maHD, Date ngayLapHD, String maKH, String maNV, String maSP, double donGia, int soLuong, double thanhTien) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maSP = maSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    
    

}