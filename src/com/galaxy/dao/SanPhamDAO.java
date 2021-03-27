/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.galaxy.dao;

import com.galaxy.entity.KhachHang;
import com.galaxy.entity.SanPham;
import com.galaxy.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class SanPhamDAO extends GalaxyCafeDAO<SanPham, String> {

    @Override
    public void insert(SanPham model) {
        String sql = "INSERT INTO SANPHAM (MASP, TENSP, HINH, DONGIA, SOLUONG, MANCC, MALH) VALUES (?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getHinh(),
                model.getDonGia(),
                model.getSoLuong(),
                model.getMaNCC(),
                model.getMaLH()
        );
    }

    @Override
    public void update(SanPham model) {
        String sql = "UPDATE SANPHAM SET TENSP=?, HINH=?,  DONGIA=?, SOLUONG=?, MANCC=?, MALH=? WHERE MASP=?";
        XJdbc.update(sql,
                model.getMaSP(),
                model.getTenSP(),
                model.getHinh(),
                model.getDonGia(),
                model.getSoLuong(),
                model.getMaNCC(),
                model.getMaLH()
        );
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM SANPHAM WHERE MASP=?";
        XJdbc.update(sql, id);
    }

    @Override
    public SanPham selectById(String masp) {
        String sql = "SELECT * FROM SANPHAM WHERE MASP=?";
        List<SanPham> list = selectBySql(sql, masp);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "SELECT * FROM SANPHAM";
        return selectBySql(sql);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    SanPham entity = new SanPham();
                    entity.setMaSP(rs.getString("MASP"));
                    entity.setTenSP(rs.getString("TENSP"));
                    entity.setHinh(rs.getString("HINH"));
                    entity.setDonGia(rs.getDouble("DONGIA"));
                    entity.setSoLuong(rs.getInt("SOLUONG"));
                    entity.setMaNCC(rs.getString("MANCC"));
                    entity.setMaLH(rs.getString("MALH"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<SanPham> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM SANPHAM WHERE TENSP LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
