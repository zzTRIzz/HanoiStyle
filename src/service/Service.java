/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import app_hanoistyle.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class Service {

    List<SanPham> list = new ArrayList<>();

    public List<SanPham> getAll() {
        list.clear();
        try {
            String sql = "SELECT * FROM SanPham";
            Connection conn = DbConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String thuongHieu = rs.getString(4);
                String loai = rs.getString(5);
                String size = rs.getString(6);
                String chatLieu = rs.getString(7);
                String mauSac = rs.getString(8);
                String trangThai = rs.getString(9);
                Integer soLuong = rs.getInt(10);
                Float gia = rs.getFloat(11);
                String ngayTao = rs.getString(12);
                list.add(new SanPham(id, ma, ten, thuongHieu, loai, size, chatLieu, mauSac, trangThai, soLuong, gia, ngayTao));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
}
