/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceDB;



import opp.SanPham;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Dell
 */
public class ServiceSanPham {
    List<SanPham> list = new ArrayList<>();
    
    public List<SanPham> getAll(){
        list.clear();
        try{
            String sql = "select id, ma_san_pham, ten_san_pham, so_luong_ton, gia_ban, trang_thai, mau_sac, ngay_tao from SanPham";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Integer id = rs.getInt(1);
               String ma = rs.getString(2);
               String ten = rs.getString(3);
               Integer soLuong = rs.getInt(4);
               Integer gia = rs.getInt(5);
               String trangThai = rs.getString(6);
               String mauSac = rs.getString(7);
               String ngayTao = rs.getString(8);
               list.add(new SanPham(id, ma, ten, soLuong, gia, trangThai, mauSac, ngayTao));
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static int updateSanPham(String maSP,Integer soLuongTon){
        int kq =-1;
        try {
            Connection conn = DBConnect.getConnection();
            String sql="update SanPham set so_luong_ton=? where ma_san_pham=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongTon);
            ps.setString(2, maSP);           
            kq=ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
}
