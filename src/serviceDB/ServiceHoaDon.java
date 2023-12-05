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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public HoaDon getRow(int row) {
        return listHoaDon.get(row);
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
    public static void deleteHoaDonTheoMaHD(String maHD) {
        
        try {
            String sql = "delete from HoaDon where ma=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHD);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public List<HoaDon> search(String keyword) {
    String sql = "SELECT * FROM HoaDon WHERE ma = ? OR ten_nguoi_tao LIKE ?";
    listHoaDon.clear();

    try {
        Connection conn = DBConnect.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "%" + keyword + "%"); // Thêm dấu `%` vào cuối chuỗi
        stm.setString(2, "%" + keyword + "%");
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setIdHD(rs.getInt(1));
            hoaDon.setMaHD(rs.getString(2));
            hoaDon.setNgayTao(rs.getString(3));
            hoaDon.setTenNguoiTao(rs.getString(4));
            hoaDon.setTongTien(rs.getInt(5));
            hoaDon.setIdKhachHang(rs.getInt(6));
            hoaDon.setTrangThai(rs.getString(7));
            hoaDon.setIdNhanVien(rs.getInt(8));
            listHoaDon.add(hoaDon);
        }

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return listHoaDon;
}
    
    public int updateTrangThaiToTraHang(String maHD) {
        int kq = -1;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "update HoaDon set trang_thai=? where ma=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Tra hang");
            ps.setString(2, maHD);

            kq = ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
    
    //Tìm kiếm theo 
    public List<HoaDon> searchTheoKhoangTho(java.util.Date batDau, java.util.Date ketThuc) {
        String sql = "SELECT * FROM HoaDon WHERE ngay_tao BETWEEN ? AND ?";
        listHoaDon.clear();

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date sqlBatDau = new java.sql.Date(batDau.getTime());
            java.sql.Date sqlKetThuc = new java.sql.Date(ketThuc.getTime());

            preparedStatement.setDate(1, sqlBatDau);
            preparedStatement.setDate(2, sqlKetThuc);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdHD(rs.getInt(1));
                hoaDon.setMaHD(rs.getString(2));
                hoaDon.setNgayTao(rs.getString(3));
                hoaDon.setTenNguoiTao(rs.getString(4));
                hoaDon.setIdKhachHang(rs.getInt(5));
                hoaDon.setTongTien(rs.getInt(6));
                hoaDon.setTrangThai(rs.getString(7));
                hoaDon.setIdNhanVien(rs.getInt(8));
                listHoaDon.add(hoaDon);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listHoaDon;
    }

    private static java.util.Date chuyenChuoiSangDate(String ngayNhap) {
        // Chuyển đổi chuỗi thành đối tượng Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return (java.util.Date) sdf.parse(ngayNhap.replace("thg", ""));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
