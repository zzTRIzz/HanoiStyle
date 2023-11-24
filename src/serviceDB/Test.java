/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceDB;

import serviceDB.ServiceSanPham;
import opp.SanPham;

/**
 *
 * @author Dell
 */
public class Test {
    public static void main(String[] args) {
        ServiceSanPham sv = new ServiceSanPham();
        for (SanPham service : sv.getAll()) {
            
        }
    }
}
