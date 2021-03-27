package com.galaxy.dao;

import com.galaxy.utils.XJdbc;
import com.galaxy.entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO extends GalaxyCafeDAO<KhachHang, String>{

    public void insert(KhachHang model){
        String sql="INSERT INTO KhachHang (MAKH, TENKH, GIOITINH, NGAYSINH, SDT, EMAIL, DIACHI, MATKHAU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaKH(), 
                model.getTenKH(), 
                model.getGioiTinh(), 
                model.getNgaySinh(),
                model.getSdt(),
                model.getEmail(),
                model.getDiaChi(),
                model.getMatKhau());              
    }
    
    public void update(KhachHang model){
        String sql="UPDATE KhachHang SET TENKH=?, GIOITINH=?,  NGAYSINH=?, SDT=?, EMAIL=?, DIACHI=?, MATKHAU=? WHERE MAKH=?";
        XJdbc.update(sql, 
                model.getMaKH(), 
                model.getTenKH(), 
                model.getGioiTinh(), 
                model.getNgaySinh(),
                model.getSdt(),
                model.getEmail(),
                model.getMatKhau()); 
    }
    
    public void delete(String id){
        String sql="DELETE FROM KhachHang WHERE MAKH=?";
        XJdbc.update(sql, id);
    }
    
    public List<KhachHang> selectAll(){
        String sql="SELECT * FROM KhachHang";
        return selectBySql(sql);
    }
    
    public KhachHang selectById(String makh){
        String sql="SELECT * FROM KhachHang WHERE MAKH=?";
        List<KhachHang> list = selectBySql(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<KhachHang> selectBySql(String sql, Object...args){
        List<KhachHang> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    KhachHang entity=new KhachHang();
                    entity.setMaKH(rs.getString("MAKH"));
                    entity.setTenKH(rs.getString("TENKH"));
                    entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                    entity.setNgaySinh(rs.getDate("NGAYSINH"));
                    entity.setSdt(rs.getString("SDT"));
                    entity.setEmail(rs.getString("EMAIL"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setMatKhau(rs.getString("MATKHAU"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
    public List<KhachHang> selectByKeyword(String keyword){
        String sql="SELECT * FROM KhachHang WHERE MAKH LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
}
