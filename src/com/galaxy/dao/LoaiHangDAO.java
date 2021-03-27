
package com.galaxy.dao;

import com.galaxy.entity.KhachHang;
import com.galaxy.entity.LoaiHang;
import com.galaxy.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoaiHangDAO extends GalaxyCafeDAO<LoaiHang, String>{

    @Override
    public void insert(LoaiHang model) {
         String sql="INSERT INTO LOAIHANG (MALH, TENLH, MANCC) VALUES (?, ?, ?)";
         XJdbc.update(sql, 
                model.getMaLH(), 
                model.getTenLH(), 
                model.getMaNCC());
               
    }

    @Override
    public void update(LoaiHang model) {
          String sql="UPDATE LAOIHANG SET TENLH=?, MANCC=?  WHERE MALH=?";
          XJdbc.update(sql, 
                 model.getMaLH(),
                 model.getTenLH(),
                 model.getMaNCC());  
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM LOAIHANG WHERE MALH=?";
        XJdbc.update(sql, id);
    }

    @Override
    public LoaiHang selectById(String malh) {
        String sql="SELECT * FROM LOAIHANG WHERE MALH=?";
        List<LoaiHang> list = selectBySql(sql,malh);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiHang> selectAll() {
    String sql="SELECT * FROM LOAIHANG";
    return selectBySql(sql);   
    }

    @Override
    protected List<LoaiHang> selectBySql(String sql, Object... args) {
             List<LoaiHang> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    LoaiHang entity=new LoaiHang();
                    entity.setMaLH(rs.getString("MALH"));
                    entity.setTenLH(rs.getString("TENLH"));
                    entity.setMaNCC(rs.getString("MANCC"));
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
       public List<LoaiHang> selectByKeyword(String keyword){
        String sql="SELECT * FROM LOAIHANG WHERE TENLH LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }    
}
