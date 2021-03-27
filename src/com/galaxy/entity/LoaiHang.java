package com.galaxy.entity;

public class LoaiHang {

    private String maLH;
    private String tenLH;
    private String maNCC;

    public LoaiHang() {
    }

    public LoaiHang(String maLH, String tenLH, String maNCC) {
        this.maLH = maLH;
        this.tenLH = tenLH;
        this.maNCC = maNCC;
    }

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

}
