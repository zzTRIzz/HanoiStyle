/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceDB;

import java.util.List;
import opp.HoaDonChiTiet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class ServiceHoaDonChiTiet {
    List<HoaDonChiTiet> listhoaDonChiTiet = new ArrayList<>();
    
    
    public List<HoaDonChiTiet> getHoaDonChiTiet() {
        listhoaDonChiTiet.clear();
        try {
            String sql = "SELECT hd.id, hd.ma, hd.ngay_tao, hd.ten_nguoi_tao, id_khach_hang, hd.tong_tien, hd.trang_thai, id_nhan_vien,  \n"
        + "STRING_AGG(gh.maSP,', ') as maSanPham  ,STRING_AGG(gh.tenSP, ', ') as tenSanPham,SUM(gh.soLuong) as Tongsoluong,\n"
        + "STRING_AGG(sp.mau_sac,', ') as Tongmausac\n"
        + "FROM HoaDon hd\n"
        + "INNER JOIN GioHang gh ON hd.ma = gh.maHD\n"
        + "INNER JOIN SanPham sp ON sp.ma_san_pham = gh.maSP\n"
        + "GROUP BY hd.id, hd.ma, hd.ngay_tao, hd.ten_nguoi_tao, id_khach_hang, hd.tong_tien, hd.trang_thai, id_nhan_vien";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDonChiTiet ct = new HoaDonChiTiet();

                ct.setCt_id(rs.getInt(1));
                ct.setCt_maHD(rs.getString(2));
                ct.setCt_ngayTao(rs.getString(3));
                ct.setCt_tenNV(rs.getString(4));
                ct.setCt_id_KH(rs.getInt(5));
                ct.setCt_TongTien(rs.getInt(6));
                ct.setCt_TrangThai(rs.getString(7));
                ct.setCt_id_NV(rs.getInt(8));
                ct.setCt_maSP(rs.getString(9));
                ct.setCt_tenSP(rs.getString(10));
                ct.setCt_TongSL(rs.getInt(11));
                ct.setCt_TongMauSac(rs.getString(12));
                listhoaDonChiTiet.add(ct);

            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listhoaDonChiTiet;
    }

    public List<HoaDonChiTiet> searchChiTiet(String keywordct) {
//    String sql = "SELECT ma, ngay_tao, ten_nguoi_tao, trang_thai FROM HoaDon WHERE ma = ? OR ten_nguoi_tao LIKE ?";
        String sql = "SELECT hd.id, hd.ma, hd.ngay_tao, hd.ten_nguoi_tao, id_khach_hang, hd.tong_tien, hd.trang_thai, id_nhan_vien,  \n"
        + "STRING_AGG(gh.maSP,', ') as maSanPham  ,STRING_AGG(gh.tenSP, ', ') as tenSanPham,SUM(gh.soLuong) as Tongsoluong,\n"
        + "STRING_AGG(sp.mau_sac,', ') as Tongmausac\n"
        + "FROM HoaDon hd\n"
        + "INNER JOIN GioHang gh ON hd.ma = gh.maHD\n"
        + "INNER JOIN SanPham sp ON sp.ma_san_pham = gh.maSP\n"
        + "WHERE hd.ma LIKE ? OR hd.ten_nguoi_tao LIKE ?\n"
        + "GROUP BY hd.id, hd.ma, hd.ngay_tao, hd.ten_nguoi_tao, id_khach_hang, hd.tong_tien, hd.trang_thai, id_nhan_vien";

        listhoaDonChiTiet.clear();

        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + keywordct + "%");
            stm.setString(2, "%" + keywordct + "%");
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                HoaDonChiTiet ct = new HoaDonChiTiet();
//                hoaDon.setIdHD(rs.getInt(1));
                ct.setCt_id(rs.getInt(1));
                ct.setCt_maHD(rs.getString(2));
                ct.setCt_ngayTao(rs.getString(3));
                ct.setCt_tenNV(rs.getString(4));
                ct.setCt_id_KH(rs.getInt(5));
                ct.setCt_TongTien(rs.getInt(6));
                ct.setCt_TrangThai(rs.getString(7));
                ct.setCt_id_NV(rs.getInt(8));
                ct.setCt_maSP(rs.getString(9));
                ct.setCt_tenSP(rs.getString(10));
                ct.setCt_TongSL(rs.getInt(11));
                ct.setCt_TongMauSac(rs.getString(12));
                listhoaDonChiTiet.add(ct);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listhoaDonChiTiet;
    }

    
    
    public List<HoaDonChiTiet> searchChiTietTheoKhoang(Date batDau, Date ketThuc){
        String sql = "SELECT hd.id, hd.ma, hd.ngay_tao, hd.ten_nguoi_tao, id_khach_hang, hd.tong_tien, hd.trang_thai, id_nhan_vien,  \n"
        + "STRING_AGG(gh.maSP,', ') as maSanPham  ,STRING_AGG(gh.tenSP, ', ') as tenSanPham,SUM(gh.soLuong) as Tongsoluong,\n"
        + "STRING_AGG(sp.mau_sac,', ') as Tongmausac\n"
        + "FROM HoaDon hd\n"
        + "INNER JOIN GioHang gh ON hd.ma = gh.maHD\n"
        + "INNER JOIN SanPham sp ON sp.ma_san_pham = gh.maSP\n"
        + "WHERE hd.ngay_tao BETWEEN ? AND ? \n"            
        + "GROUP BY hd.id, hd.ma, hd.ngay_tao, hd.ten_nguoi_tao, id_khach_hang, hd.tong_tien, hd.trang_thai, id_nhan_vien";
        listhoaDonChiTiet.clear();
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement pr = conn.prepareStatement(sql);
//            java.sql.Date sqlBatDau = new java.sql.Date(batDau.getTime());
//            java.sql.Date sqlKetThuc = new java.sql.Date(ketThuc.getTime());
            java.sql.Date sqlBatDau = new java.sql.Date(batDau.getTime());
            java.sql.Date sqlKetThuc = new java.sql.Date(ketThuc.getTime());
            pr.setDate(1, sqlBatDau);
            pr.setDate(2, sqlKetThuc);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {                
                HoaDonChiTiet ct = new HoaDonChiTiet();
//                hoaDon.setIdHD(rs.getInt(1));
                ct.setCt_id(rs.getInt(1));
                ct.setCt_maHD(rs.getString(2));
                ct.setCt_ngayTao(rs.getString(3));
                ct.setCt_tenNV(rs.getString(4));
                ct.setCt_id_KH(rs.getInt(5));
                ct.setCt_TongTien(rs.getInt(6));
                ct.setCt_TrangThai(rs.getString(7));
                ct.setCt_id_NV(rs.getInt(8));
                ct.setCt_maSP(rs.getString(9));
                ct.setCt_tenSP(rs.getString(10));
                ct.setCt_TongSL(rs.getInt(11));
                ct.setCt_TongMauSac(rs.getString(12));
                listhoaDonChiTiet.add(ct);
            }
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listhoaDonChiTiet;
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
    
    
//    public static void main(String[] args) {
//
//        ServiceHoaDon serviceHoaDon = new ServiceHoaDon();
//
//        for (HoaDonChiTiet hd : serviceHoaDon.searchChiTiet("HD001")) {
//            System.out.println("Mã Hóa Đơn: " + hd.getCt_maHD());
//            // In thêm các thông tin khác nếu cần
//        }
//
//    }

   


    
}
