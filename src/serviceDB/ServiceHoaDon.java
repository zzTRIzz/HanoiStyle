/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceDB;

/**
 *
 * @author Ngo Nhan
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import opp.HoaDon;
public class ServiceHoaDon {

    
    List<HoaDon> listHoaDon = new ArrayList<>();
    
    public List<HoaDon> getHoaDon(){
        listHoaDon.clear();
        try {
            String sql ="select id, ma,ngay_tao,ten_nguoi_tao,id_khach_hang,tong_tien,trang_thai,id_nhan_vien from HoaDon";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                Integer id =rs.getInt(1);
                String ma =rs.getString(2);
                String ngayTao =rs.getString(3);
                String ten =rs.getString(4);
                Integer idKH =rs.getInt(5);
                Integer tongTien =rs.getInt(6);
                String trangThai =rs.getString(7);
                Integer idNB =rs.getInt(8);
                
                listHoaDon.add(new HoaDon(id, idKH, idNB, ma, ngayTao, ten, trangThai, tongTien));

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    public static void insertDataToHD(String ma,String ngayTao,String tenNguoiTao, Integer idKhachHang, Integer tongTien,String trangThai, Integer idNhanVien )
    {
        try {
            Connection conn=DBConnect.getConnection();//mo ket noi csdl
            //lenh
            String sql="insert into HoaDon(ma,ngay_tao,ten_nguoi_tao,id_khach_hang,tong_tien,trang_thai,id_nhan_vien) values (?,?,?,?,?,?,?)";
            //chuuan bi lenh
            PreparedStatement ps=conn.prepareStatement(sql);
            //chuan bi tham so
            ps.setString(1, ma);
            ps.setString(2, ngayTao);
            ps.setString(3, tenNguoiTao);
            ps.setInt(4, idKhachHang);
            ps.setInt(5,tongTien );
            ps.setString(6, trangThai);
            ps.setInt(7, idNhanVien);
            
            //thuc thi lenh
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int updateHoaDon(String maHD,Integer tongTien,String trangThai ){
        int kq =-1;
        try {
            Connection conn = DBConnect.getConnection();
            String sql="update HoaDon set tong_tien=?,trang_thai=? where ma=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tongTien);
            ps.setString(2, trangThai);
            ps.setString(3, maHD);
            
            kq=ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
}
