/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<<< HEAD:src/test/Test.java
package test;

import app_hanoistyle.SanPham;
========
package serviceDB;

import serviceDB.ServiceSanPham;
import opp.SanPham;
>>>>>>>> 85f096d4931f021a58f8fa613b53f00d002c6cfd:src/serviceDB/Test.java

/**
 *
 * @author Dell
 */
public class Test {
<<<<<<<< HEAD:src/test/Test.java
//    public static void main(String[] args) {
//        Service sv = new Service();
//        for (SanPham service : sv.getAll()) {
//            
//        }
//    }
========
    public static void main(String[] args) {
        ServiceSanPham sv = new ServiceSanPham();
        for (SanPham service : sv.getAll()) {
            
        }
    }
>>>>>>>> 85f096d4931f021a58f8fa613b53f00d002c6cfd:src/serviceDB/Test.java
}
