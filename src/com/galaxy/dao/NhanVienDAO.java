package com.galaxy.dao;

import com.galaxy.utils.XJdbc;
import com.galaxy.entity.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends GalaxyCafeDAO<NhanVien, String>{

    public void insert(NhanVien model){
        String sql="INSERT INTO Nhanvien (MANV, TENNV, GIOITINH, NGAYSINH, SDT, EMAIL, DIACHI, MATKHAU, VAITRO) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        XJdbc.update(sql, 
                model.getMaNV(), 
                model.getTenNV(), 
                model.getGioiTinh(), 
                model.getNgaySinh(),
                model.getSdt(),
                model.getEmail(),
                model.getMatKhau(),
                model.getVaiTro());                
    }
    
    public void update(NhanVien model){
        String sql="UPDATE NHANVIEN SET TENNV=?, GIOITINH=?,  NGAYSINH=?, SDT=?, EMAIL=?, DIACHI=?, MATKHAU=? WHERE MaNV=?";
        XJdbc.update(sql, 
                model.getMaNV(), 
                model.getTenNV(), 
                model.getGioiTinh(), 
                model.getNgaySinh(),
                model.getSdt(),
                model.getEmail(),
                model.getMatKhau(),
                model.getVaiTro()); 
    }
    
    public void delete(String id){
        String sql="DELETE FROM NHANVIEN WHERE MaNV=?";
        XJdbc.update(sql, id);
    }
    
    public List<NhanVien> selectAll(){
        String sql="SELECT * FROM NHANVIEN";
        return selectBySql(sql);
    }
    
    public NhanVien selectById(String manv){
        String sql="SELECT * FROM NHANVIEN WHERE MaNV=?";
        List<NhanVien> list = selectBySql(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    protected List<NhanVien> selectBySql(String sql, Object...args){
        List<NhanVien> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien entity=new NhanVien();
                    entity.setMaNV(rs.getString("MANV"));
                    entity.setTenNV(rs.getString("TENNV"));
                    entity.setGioiTinh(rs.getBoolean("GIOITINH"));
                    entity.setNgaySinh(rs.getDate("NGAYSINH"));
                    entity.setSdt(rs.getString("SDT"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setMatKhau(rs.getString("MATKHAU"));
                    entity.setVaiTro(rs.getBoolean("VAITRO"));
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
    
    public List<NhanVien> selectByKeyword(String keyword){
        String sql="SELECT * FROM NHANVIEN WHERE TENNV LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }

}
