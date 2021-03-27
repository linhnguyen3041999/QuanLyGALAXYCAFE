/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.galaxy.dao;

import com.galaxy.entity.KhachHang;
import com.galaxy.entity.LoaiHang;
import com.galaxy.entity.NhaCungCap;
import com.galaxy.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class NhaCungCapDAO extends GalaxyCafeDAO<NhaCungCap, String>{

    @Override
    public void insert(NhaCungCap model) {
        String sql="INSERT INTO NHACUNGCAP (MANCC, TENNCC, DIACHI, SDT) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, 
                model.getMaNCC(), 
                model.getTenNCC(), 
                model.getDiaChi(), 
                model.getSdt()); 
 
    }

    @Override
    public void update(NhaCungCap model) {
        String sql="UPDATE NHACUNGCAP SET TENNCC=?, DIACHI=?,  SDT=? WHERE MANCC=?";
        XJdbc.update(sql, 
                model.getMaNCC(), 
                model.getTenNCC(), 
                model.getDiaChi(), 
                model.getSdt()); 
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM NHACUNGCAP WHERE MANCC=?";
        XJdbc.update(sql, id);
    }

    @Override
    public NhaCungCap selectById(String mancc) {
        String sql="SELECT * FROM NHACUNGCAP WHERE MANCC=?";
        List<NhaCungCap> list = selectBySql(sql, mancc);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhaCungCap> selectAll() {
        String sql="SELECT * FROM NHACUNGCAP";
        return selectBySql(sql);
    }

    @Override
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhaCungCap entity=new NhaCungCap();
                    entity.setMaNCC(rs.getString("MANCC"));
                    entity.setTenNCC(rs.getString("TENNCC"));
                    entity.setDiaChi(rs.getString("DIACHI"));
                    entity.setSdt(rs.getString("SDT"));
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
        public List<NhaCungCap> selectByKeyword(String keyword){
        String sql="SELECT * FROM NHACUNGCAP WHERE TENNCC LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }    
}
