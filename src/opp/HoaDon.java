/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opp;

/**
 *
 * @author Ngo Nhan
 */
public class HoaDon {
    private Integer idHD,idKhachHang,idNhanVien;
    private String maHD,ngayTao,tenNguoiTao,trangThai;
    private Integer tongTien;

    public HoaDon() {
    }

    public HoaDon(Integer idHD, Integer idKhachHang, Integer idNhanVien, String maHD, String ngayTao, String tenNguoiTao, String trangThai, Integer tongTien) {
        this.idHD = idHD;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNguoiTao = tenNguoiTao;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    public Integer getIdHD() {
        return idHD;
    }

    public void setIdHD(Integer idHD) {
        this.idHD = idHD;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNguoiTao() {
        return tenNguoiTao;
    }

    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getTongTien() {
        return tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    

    
    
}
