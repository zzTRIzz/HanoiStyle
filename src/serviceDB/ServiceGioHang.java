/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import opp.GioHang;

/**
 *
 * @author Ngo Nhan
 */
public class ServiceGioHang {
    List<GioHang> list = new ArrayList<>();
    public List<GioHang> getGioHang(){
        list.clear();
        try{
            String sql = "select id,maHD,maSP,tenSP,giaBan,soLuong,thanhTien from GioHang";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Integer id = rs.getInt(1);
               String maHD = rs.getString(2);
               String maSP = rs.getString(3);
               String ten = rs.getString(4);
               Integer giaBan = rs.getInt(5);
               Integer soLuong = rs.getInt(6);
               Integer thanhTien = rs.getInt(7);
               list.add(new GioHang(id, giaBan, soLuong, thanhTien, maSP, maHD, ten));
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<GioHang> getGioHangMouseClick(String maHDT){
        String sql = "select id,maHD,maSP,tenSP,giaBan,soLuong,thanhTien from GioHang where maHD=?";
        list.clear();
        try{
            
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, maHDT);
            ResultSet rs = ps.executeQuery();
//            ps.executeUpdate();
            while(rs.next()){
              Integer id = rs.getInt(1);
               String maHD = rs.getString(2);
               String maSP = rs.getString(3);
               String ten = rs.getString(4);
               Integer giaBan = rs.getInt(5);
               Integer soLuong = rs.getInt(6);
               Integer thanhTien = rs.getInt(7);
               list.add(new GioHang(id, giaBan, soLuong, thanhTien, maSP, maHD, ten));
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<GioHang> getGioHangTonTai(String maHDT,String maSPT){
        String sql = "select id,maHD,maSP,tenSP,giaBan,soLuong,thanhTien from GioHang where maHD=? and maSP=?";
        list.clear();
        try{
            
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, maHDT);
            ps.setString(2, maSPT);
            ResultSet rs = ps.executeQuery();
//            ps.executeUpdate();
            while(rs.next()){
              Integer id = rs.getInt(1);
               String maHD = rs.getString(2);
               String maSP = rs.getString(3);
               String ten = rs.getString(4);
               Integer giaBan = rs.getInt(5);
               Integer soLuong = rs.getInt(6);
               Integer thanhTien = rs.getInt(7);
               list.add(new GioHang(id, giaBan, soLuong, thanhTien, maSP, maHD, ten));
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public GioHang getRow(int row) {
        return list.get(row);
    }
        public static void deleteGioHang(Integer id) {
        
        try {
            String sql = "delete from GioHang where id=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteGioHangTheoMaSP(String maSP) {

        try {
            String sql = "delete from GioHang where maSP=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteGioHangTheoMaHD(String maHD) {

        try {
            String sql = "delete from GioHang where maHD=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHD);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void insertDataToGH(String maSp,String maHD,String tenSP,Integer giaBan, Integer soLuongMua, Integer thanhTien)
    {
        try {
            Connection conn=DBConnect.getConnection();//mo ket noi csdl
            //lenh
            String sql="insert into GioHang(maSP,maHD,tenSP,giaBan,soLuong,thanhTien) values (?,?,?,?,?,?)";
            //chuuan bi lenh
            PreparedStatement ps=conn.prepareStatement(sql);
            //chuan bi tham so
            ps.setString(1, maSp);
            ps.setString(2, maHD);
            ps.setString(3, tenSP);
            ps.setInt(4, giaBan);
            ps.setInt(5, soLuongMua);
            ps.setInt(6,thanhTien );
            
            
            //thuc thi lenh
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int updateGioHang(Integer id,Integer soLuongMua,Integer thanhTien){
        int kq =-1;
        try {
            Connection conn = DBConnect.getConnection();
            String sql="update GioHang set soLuong=?,thanhTien=? where id=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongMua);
            ps.setInt(3, id);
            ps.setInt(2, thanhTien);
            kq=ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
    public static int updateGioHangByMa(String maSP,Integer soLuongMua,Integer thanhTien){
        int kq =-1;
        try {
            Connection conn = DBConnect.getConnection();
            String sql="update GioHang set soLuong=?,thanhTien=? where maSP=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongMua);
            ps.setString(3, maSP);
            ps.setInt(2, thanhTien);
            kq=ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
}
