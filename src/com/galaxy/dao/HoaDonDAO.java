package com.galaxy.dao;

import com.galaxy.utils.XJdbc;
import com.galaxy.entity.HoaDon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO extends GalaxyCafeDAO<HoaDon, String> {

    public void insert(HoaDon model) {
        String sql = "INSERT INTO HoaDon (MAHD, NGAYLAPHD, MAKH, MANV, MASP, DONGIA, SOLUONG, THANHTIEN) VALUES (?,?,?,?,?,?,?,?)";
        XJdbc.update(sql,
                model.getMaHD(),
                model.getNgayLapHD(),
                model.getMaKH(),
                model.getMaNV(),
                model.getMaSP(),
                model.getDonGia(),
                model.getSoLuong(),
                model.getThanhTien()
        );

    }

    public void update(HoaDon model) {
        String sql = "UPDATE HoaDon SET NGAYLAPHD=?, MAKH=?,  MANV=?, MASP=?, DONGIA=?, SOLUONG=?, THANHTIEN=? WHERE MAHD=?";
        XJdbc.update(sql,
                model.getMaHD(),
                model.getNgayLapHD(),
                model.getMaKH(),
                model.getMaNV(),
                model.getMaSP(),
                model.getDonGia(),
                model.getSoLuong(),
                model.getThanhTien()
        );
    }

    public void delete(String id) {
        String sql = "DELETE FROM HoaDon WHERE MAHD=?";
        XJdbc.update(sql, id);
    }

    public List<HoaDon> selectAll() {
        String sql = "SELECT * FROM HoaDon";
        return selectBySql(sql);
    }

    public HoaDon selectById(String mahd) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon> list = selectBySql(sql, mahd);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon entity = new HoaDon();
                    entity.setMaHD(rs.getString("MAHD"));
                    entity.setNgayLapHD(rs.getDate("NGAYLAPHD"));
                    entity.setMaKH(rs.getString("MAKH"));
                    entity.setMaNV(rs.getString("MANV"));
                    entity.setMaSP(rs.getString("MASP"));
                    entity.setDonGia(rs.getDouble("DONGIA"));
                    entity.setSoLuong(rs.getInt("SOLUONG"));
                    entity.setThanhTien(rs.getInt("THANHTIEN"));
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

//    public List<HoaDon> selectByID(String keyword){
//        String sql="SELECT * FROM HoaDon WHERE TENPTTT LIKE ?";
//        return this.selectBySql(sql, "%"+keyword+"%");
//    }
}
