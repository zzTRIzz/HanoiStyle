/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package opp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import serviceDB.DBConnect;

/**
 *
 * @author Ngo Nhan
 */
public class GioHang {
    private Integer id,giaBan,soLuong,thanhTien;
    private String maSP,maHD,tenSP;

    public GioHang() {
    }

    public GioHang(Integer id, Integer giaBan, Integer soLuong, Integer thanhTien, String maSP, String maHD, String tenSP) {
        this.id = id;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.maSP = maSP;
        this.maHD = maHD;
        this.tenSP = tenSP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Integer thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    @Override
    public String toString() {
        return "GioHang{" + "id=" + id + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + ", maSP=" + maSP + ", maHD=" + maHD + ", tenSP=" + tenSP + '}';
    }
    
    
}
