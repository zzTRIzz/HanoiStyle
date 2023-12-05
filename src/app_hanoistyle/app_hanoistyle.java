/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app_hanoistyle;

//import java.awt.Image;
//import javax.swing.ImageIcon;
import opp.SanPham;
import serviceDB.ServiceSanPham;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import opp.GioHang;
import opp.HoaDon;
import serviceDB.ServiceGioHang;
import serviceDB.ServiceHoaDon;
import java.util.ConcurrentModificationException;
import java.util.Date;
import opp.HoaDonChiTiet;
import serviceDB.ServiceHoaDonChiTiet;

/**
 *
 * @author ADMIN
 */
public class app_hanoistyle extends javax.swing.JFrame {

    /**
     * Creates new form app_hanoistyle
     */
    //ok
    DefaultTableModel model;
    ServiceSanPham svSP = new ServiceSanPham();
    ServiceHoaDon svHD = new ServiceHoaDon();
    ServiceGioHang svGH = new ServiceGioHang();
    ServiceHoaDonChiTiet svHDCT =  new ServiceHoaDonChiTiet();
    
    
    LocalDate thoiGian =  LocalDate.now();
    String date = thoiGian.toString();
    
    private boolean check = false;
    
    
    public app_hanoistyle() {
        initComponents();
        loadData();
        loadDataSanPham();
        loadDataHoaDon();
        loadDataGioHang();
        loadDataHoaDon1();
//        txtIDKH.setEditable(false);
        txtTenNT.setEditable(false);
//        txtIDNV.setEditable(false);
//        txtMaHoaDon.setEditable(false);
        txtNgayTao.setEditable(false);
        txtKhachDua.setEditable(false);
        txtThua.setEditable(false);
        txtTongTien.setEditable(false);
        btnThanhToan.setEnabled(false);
        LocalDate thoiGian = LocalDate.now();
        String date = thoiGian.toString();
        txtNgayTao.setText(date);

    }

    void loadData() {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPham service : svSP.getAll()) {
            model.addRow(new Object[]{
                service.getId(),
                service.getMaSanPham(),
                service.getTenSanPham(),
                service.getSoLuongTon(),
                service.getGiaBan(),
                service.getTrangThai(),
                service.getMauSac(),
                service.getNgayTao()
            });
        }
    }

    void loadDataSanPham() {
        model = (DefaultTableModel) tblSP.getModel();
        model.setRowCount(0);
        for (SanPham service : svSP.getAll()) {
            model.addRow(new Object[]{
                service.getId(),
                service.getMaSanPham(),
                service.getTenSanPham(),
                service.getSoLuongTon(),
                service.getGiaBan(),
                service.getMauSac(),});
        }
    }

    void loadDataHoaDon() {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (HoaDon service : svHD.getHoaDon()) {
            model.addRow(new Object[]{
                stt++,
                service.getMaHD(),
                service.getNgayTao(),
                service.getTenNguoiTao(),
                service.getTrangThai()

            });
        }
    }

    void loadDataGioHang() {
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);

        for (GioHang service : svGH.getGioHang()) {
            model.addRow(new Object[]{
                service.getId(),
                service.getMaHD(),
                service.getTenSP(),
                service.getGiaBan(),
                service.getSoLuong(),
                service.getThanhTien()

            });
        }
    }

    void loadDataGioHangbyMa(String maHD) {
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        for (GioHang service : svGH.getGioHangMouseClick(maHD)) {
            model.addRow(new Object[]{
                service.getId(),
                service.getMaHD(),
                service.getTenSP(),
                service.getGiaBan(),
                service.getSoLuong(),
                service.getThanhTien()

            });
        }
    }
    
    void loadDataHoaDon1(){
        model = (DefaultTableModel) tblHoaDon1.getModel();
        
        model.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTiet ct : svHDCT.getHoaDonChiTiet()) {
            model.addRow(new Object[]{
                stt++,
                ct.getCt_maHD(),
                ct.getCt_ngayTao(),
                ct.getCt_tenNV(),
                ct.getCt_TrangThai()
                
            });
        
    }

    }
    
    void loadDataChiTietHoaDon(){
        model = (DefaultTableModel) tblChiTietHoaDon.getModel();
        model.setRowCount(0);
        int sttChiTietHoaDon = 1;
        for (HoaDonChiTiet ct : svHDCT.getHoaDonChiTiet()) {
            model.addRow(new Object[]{
                sttChiTietHoaDon,
                ct.getCt_id(),
                ct.getCt_maHD(),
                ct.getCt_tenNV(),
                ct.getCt_ngayTao(),
                ct.getCt_id_KH(),
                ct.getCt_maSP(),
                ct.getCt_tenSP(),
                ct.getCt_TongSL(),
                ct.getCt_TongMauSac(),
                ct.getCt_TongTien()
                
            });
            sttChiTietHoaDon++;
        }
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        Panel_Main = new javax.swing.JPanel();
        sanPhamPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        banHangPanel = new javax.swing.JPanel();
        hoadonPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtIDKH = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtThua = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtKhachDua = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtIDNV = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTenNT = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btLamMoi = new javax.swing.JButton();
        btnTaoHD = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaGH = new javax.swing.JButton();
        btnDoi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        giohangPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        hoadonPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblHoaDon1 = new javax.swing.JTable();
        btTraHang = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        btSearchTheoNgay = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jRadioButton3 = new javax.swing.JRadioButton();
        nhanvienPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        menuSanPham = new javax.swing.JLabel();
        menuThongKe = new javax.swing.JLabel();
        menuHoaDon = new javax.swing.JLabel();
        menuNhanVien = new javax.swing.JLabel();
        menuGioHang = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ứng dụng quản lý HanoiStyle");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("HanoiStyle");

        Panel_Main.setPreferredSize(new java.awt.Dimension(1041, 616));

        sanPhamPanel.setBackground(new java.awt.Color(232, 232, 232));
        sanPhamPanel.setPreferredSize(new java.awt.Dimension(1034, 618));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel2.setText("Mã sản phẩm");

        jTextField1.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel3.setText("Tên sản phẩm");

        jTextField2.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel5.setText("Đơn bán");

        jTextField3.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel6.setText("Số lượng");

        jTextField4.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel7.setText("Chất liệu");

        jComboBox1.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Contton", "Chiffon", "Kaki", "Kate", "Polyester", "Len", "Voan", "Lụa", "Nỉ", "100% PE (Nylon)" }));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel8.setText("Thương hiệu");

        jTextField5.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setText("Màu sắc");

        jComboBox2.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Đen", "Trắng", "Đỏ", "Xanh dương", "Xanh lá cây", "Vàng", "Hồng", "Cam", "Tím", "Nâu", "Xám", "Da cam", "Hồng nhạt", "Xanh lam", "Xanh lá cây đậm", "Đỏ đậm", "Xanh nước biển", "Nâu nhạt", "Xám nhạt", "Vàng nhạt" }));

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel10.setText("Loại");

        jComboBox3.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Áo", "Quần" }));

        jComboBox4.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "XS", "S", "M", "L", "XL", "XXL" }));

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel11.setText("Size");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel12.setText("Ngày nhập");

        jTextField6.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel8)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField5)
                                .addComponent(jTextField2)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, 0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, 0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(12, 12, 12)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                    .addComponent(jTextField3)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9))
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))))
                .addGap(53, 53, 53))
        );

        tblSanPham.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Mã", "Tên", "số lượng", "giá bán", "trạng thái", "màu sắc", "ngày tạo"
            }
        ));
        jScrollPane1.setViewportView(tblSanPham);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(3, 1));

        jButton1.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        jButton1.setText("New   ");
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-22.png"))); // NOI18N
        jButton2.setText("   Lưu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton4.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find-22.png"))); // NOI18N
        jButton4.setText("  Tìm ");
        jPanel3.add(jButton4);

        jLabel13.setBackground(new java.awt.Color(255, 153, 153));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 72)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Ảnh");

        javax.swing.GroupLayout sanPhamPanelLayout = new javax.swing.GroupLayout(sanPhamPanel);
        sanPhamPanel.setLayout(sanPhamPanelLayout);
        sanPhamPanelLayout.setHorizontalGroup(
            sanPhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanPhamPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(sanPhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanPhamPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(23, 23, 23))
        );
        sanPhamPanelLayout.setVerticalGroup(
            sanPhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sanPhamPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(sanPhamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        banHangPanel.setBackground(new java.awt.Color(229, 229, 229));
        banHangPanel.setPreferredSize(new java.awt.Dimension(1034, 618));

        hoadonPanel1.setBackground(new java.awt.Color(232, 232, 232));
        hoadonPanel1.setPreferredSize(new java.awt.Dimension(1041, 616));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tạo hóa đơn cho khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel14.setText("Mã hóa đơn");

        txtMaHoaDon.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel15.setText("Ngày tạo ");

        txtNgayTao.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel19.setText("ID khách hàng");

        txtIDKH.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel25.setText("Tiền thừa");

        txtThua.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel26.setText("Tổng tiền");

        txtTongTien.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel27.setText("Tiền khách đưa");

        txtKhachDua.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        txtKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachDuaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel20.setText("ID nhân viên");

        txtIDNV.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        txtIDNV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDNVFocusLost(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel21.setText("Tên người tạo");

        txtTenNT.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIDKH, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtIDNV, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel26))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtTenNT, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThua, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtIDNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTenNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addComponent(txtIDKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Noto Sans", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(3, 1));

        btLamMoi.setFont(new java.awt.Font("Dosis", 1, 12)); // NOI18N
        btLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btLamMoi.setText("LÀM MỚI");
        btLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLamMoiActionPerformed(evt);
            }
        });
        jPanel5.add(btLamMoi);

        btnTaoHD.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btnTaoHD.setForeground(new java.awt.Color(153, 0, 0));
        btnTaoHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        btnTaoHD.setText("Tạo hóa đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });
        jPanel5.add(btnTaoHD);

        btnThanhToan.setFont(new java.awt.Font("Dosis", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(153, 0, 0));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save-22.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel5.add(btnThanhToan);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Giỏ Hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(204, 0, 51))); // NOI18N

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã HD", "Tên SP", "Giá Bán", "SL Mua", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblGioHangFocusLost(evt);
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnXoaGH.setText("Xoa");
        btnXoaGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGHActionPerformed(evt);
            }
        });

        btnDoi.setText("Đổi số lượng");
        btnDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiMouseClicked(evt);
            }
        });
        btnDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnXoaGH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaGH)
                    .addComponent(btnDoi)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sản Phẩm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(204, 0, 51))); // NOI18N

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng Tồn", "Giá Bán", "Màu Sắc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSP);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Hóa Đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(204, 0, 51))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Ngày Tạo", "Tên NV", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout hoadonPanel1Layout = new javax.swing.GroupLayout(hoadonPanel1);
        hoadonPanel1.setLayout(hoadonPanel1Layout);
        hoadonPanel1Layout.setHorizontalGroup(
            hoadonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoadonPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(hoadonPanel1Layout.createSequentialGroup()
                .addGroup(hoadonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hoadonPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hoadonPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        hoadonPanel1Layout.setVerticalGroup(
            hoadonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hoadonPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(hoadonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(hoadonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hoadonPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hoadonPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout banHangPanelLayout = new javax.swing.GroupLayout(banHangPanel);
        banHangPanel.setLayout(banHangPanelLayout);
        banHangPanelLayout.setHorizontalGroup(
            banHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, banHangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hoadonPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE))
        );
        banHangPanelLayout.setVerticalGroup(
            banHangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, banHangPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hoadonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        giohangPanel.setPreferredSize(new java.awt.Dimension(1034, 618));

        jTable5.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Thương hiệu", "Loại", "Size", "Chất liệu", "Màu sắc", "Đơn bán", "Số lượng", "Ngày nhập"
            }
        ));
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(8).setHeaderValue("Đơn bán");
            jTable5.getColumnModel().getColumn(9).setHeaderValue("Số lượng");
            jTable5.getColumnModel().getColumn(10).setHeaderValue("Ngày nhập");
        }

        javax.swing.GroupLayout giohangPanelLayout = new javax.swing.GroupLayout(giohangPanel);
        giohangPanel.setLayout(giohangPanelLayout);
        giohangPanelLayout.setHorizontalGroup(
            giohangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(giohangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        giohangPanelLayout.setVerticalGroup(
            giohangPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, giohangPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );

        hoadonPanel.setPreferredSize(new java.awt.Dimension(1034, 618));

        jPanel9.setBackground(new java.awt.Color(229, 229, 229));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        tblHoaDon1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Ngày Tạo", "Tên NV", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblHoaDon1);

        btTraHang.setText("Trả hàng");
        btTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTraHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btTraHang)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTraHang)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));

        tblChiTietHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã hóa đơn", "Tên NV", "Ngày tạo", "ID KH", "Mã SP", "Tên SP", "Tổng SL Mua", "Màu sắc", "Tổng tiền"
            }
        ));
        jScrollPane8.setViewportView(tblChiTietHoaDon);

        jButton3.setText("Hiển thị toàn bộ danh sách ");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel22.setText("Tìm kiếm theo tên Nhân viên , theo sản phẩm,ngày tạo : ");

        txtNgayKetThuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNgayKetThucKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNgayKetThucKeyReleased(evt);
            }
        });

        btSearchTheoNgay.setBackground(new java.awt.Color(255, 204, 204));
        btSearchTheoNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSearchTheoNgay.setForeground(new java.awt.Color(255, 102, 102));
        btSearchTheoNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find-22.png"))); // NOI18N
        btSearchTheoNgay.setText("Tìm kiếm");
        btSearchTheoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchTheoNgayActionPerformed(evt);
            }
        });

        jLabel24.setText("Bắt đầu");

        jLabel28.setText("Kết thúc");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btSearchTheoNgay))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btSearchTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Quản lý hóa đơn", jPanel9);

        jRadioButton1.setText("Đã thanh toán");

        jRadioButton2.setText("Chưa thanh toán");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Tên nhân viên", "Trạng thái", "Tổng tiền"
            }
        ));
        jScrollPane10.setViewportView(jTable6);

        jRadioButton3.setText("Trả hàng");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Lịch sử hóa đơn", jPanel12);

        javax.swing.GroupLayout hoadonPanelLayout = new javax.swing.GroupLayout(hoadonPanel);
        hoadonPanel.setLayout(hoadonPanelLayout);
        hoadonPanelLayout.setHorizontalGroup(
            hoadonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        hoadonPanelLayout.setVerticalGroup(
            hoadonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        nhanvienPanel.setPreferredSize(new java.awt.Dimension(1034, 618));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Email", "Vị trí công việc", "Ngày gia nhập", "Số đơn hàng đã xử lý", "Doanh số bán hàng cá nhân"
            }
        ));
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(5).setHeaderValue("Số đơn hàng đã xử lý");
            jTable3.getColumnModel().getColumn(6).setHeaderValue("Doanh số bán hàng cá nhân");
        }

        javax.swing.GroupLayout nhanvienPanelLayout = new javax.swing.GroupLayout(nhanvienPanel);
        nhanvienPanel.setLayout(nhanvienPanelLayout);
        nhanvienPanelLayout.setHorizontalGroup(
            nhanvienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanvienPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        nhanvienPanelLayout.setVerticalGroup(
            nhanvienPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhanvienPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Panel_MainLayout = new javax.swing.GroupLayout(Panel_Main);
        Panel_Main.setLayout(Panel_MainLayout);
        Panel_MainLayout.setHorizontalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MainLayout.createSequentialGroup()
                    .addComponent(sanPhamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MainLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(banHangPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(nhanvienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MainLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(giohangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(hoadonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
        );
        Panel_MainLayout.setVerticalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sanPhamPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addComponent(banHangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(nhanvienPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_MainLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(giohangPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_MainLayout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(hoadonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        menuSanPham.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuSanPham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-shirt-23.png"))); // NOI18N
        menuSanPham.setText("   Sản phẩm");
        menuSanPham.setToolTipText("");
        menuSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSanPhamMouseClicked(evt);
            }
        });

        menuThongKe.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analytics.png"))); // NOI18N
        menuThongKe.setText("   Hóa đơn");
        menuThongKe.setToolTipText("");
        menuThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThongKeMouseClicked(evt);
            }
        });

        menuHoaDon.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill.png"))); // NOI18N
        menuHoaDon.setText("   Bán Hàng");
        menuHoaDon.setToolTipText("");
        menuHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHoaDonMouseClicked(evt);
            }
        });

        menuNhanVien.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user2.png"))); // NOI18N
        menuNhanVien.setText("   Nhân viên");
        menuNhanVien.setToolTipText("");
        menuNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNhanVienMouseClicked(evt);
            }
        });

        menuGioHang.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuGioHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill.png"))); // NOI18N
        menuGioHang.setText("   Khách hàng");
        menuGioHang.setToolTipText("");
        menuGioHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuGioHangMouseClicked(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(menuHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(menuSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(menuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(menuGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)))
                .addContainerGap(1054, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addComponent(Panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(menuSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachDuaActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblGioHang.getModel();

        // Xóa tất cả các dòng từ mô hình
        model.setRowCount(0);

        // Xóa tất cả các cột từ mô hình


        
        String maHD = txtMaHoaDon.getText();
        String trangThai = "Da thanh toan";
        Integer tongTien = Integer.valueOf(txtTongTien.getText());
        ServiceHoaDon.updateHoaDon(maHD, tongTien, trangThai);

        Integer bill = Integer.valueOf(txtTongTien.getText());
        Integer khachTra = Integer.valueOf(txtKhachDua.getText());
//            Integer khachTra =Integer.parseInt(txtKhachDua.getText()) ;
        Integer tienThua = khachTra - bill;
        txtThua.setText(tienThua.toString());
        //Thanh toan xong xoa du lieu
        
//        
//        model = (DefaultTableModel) tblHoaDon.getModel();
//        model.setRowCount(0);
//        int stt = 1;
//        for (HoaDon service : svHD.getHoaDonChuaThanhToan(maHD)) {
//            model.addRow(new Object[]{
//                stt++,
//                service.getMaHD(),
//                service.getNgayTao(),
//                service.getTenNguoiTao(),
//                service.getTrangThai()
//
//            });
//        }
//        ServiceGioHang.deleteGioHangTheoMaHD(maHD);
//        ServiceHoaDon.deleteHoaDonTheoMaHD(maHD);

        loadDataHoaDon();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here: 
        model = (DefaultTableModel) tblGioHang.getModel();
        model.setRowCount(0);
        txtKhachDua.setEditable(true);

        //tong tien sửa sau
//        txtTongTien.setEditable(true);
        String ma = txtMaHoaDon.getText();
        String ngayTao = txtNgayTao.getText();
        String tenNT = txtTenNT.getText();
        String trangThai = "Chua thanh toan";
        Integer idKhachHang = Integer.valueOf(txtIDKH.getText());
        Integer idNhanVien = Integer.valueOf(txtIDNV.getText());
//        Double tongTien =Double.valueOf(txtTongTien.getText()) ;

        Integer tongTien = 0;
        txtTongTien.setText(tongTien.toString());
        ServiceHoaDon.insertDataToHD(ma, ngayTao, tenNT, idKhachHang, tongTien, trangThai, idNhanVien);
        loadDataHoaDon();
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
        txtKhachDua.setEditable(true);
        btnThanhToan.setEnabled(true);
        int soLuong=0;
        try {
           soLuong = Integer.parseInt(JOptionPane.showInputDialog(this, "So luong ban mua la:")); 
        } catch (NumberFormatException e) {
            
        }
        

        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Nhap lai so luong");
        } else {
            int i = tblSP.getSelectedRow();
            if (i >= 0) {
                String maSP = (String) tblSP.getValueAt(i, 1);
                String ten = (String) tblSP.getValueAt(i, 2);
                Integer gia = (Integer) tblSP.getValueAt(i, 4);
                Integer soLuongTon = (Integer) tblSP.getValueAt(i, 3);
                Integer thanhTien = soLuong * gia;

                Integer soLuongCon = soLuongTon - soLuong;

                String maHD = txtMaHoaDon.getText();

//                ServiceGioHang.insertDataToGH(maSP, maHD, ten, gia, soLuong, thanhTien);
//                loadDataGioHangbyMa(maHD);
                Integer tongtien = 0;
                Integer tongSoLuong = 0;
                // Gộp sản phẩm có mã trùng nhau

                int count = svGH.getGioHangTonTai(maHD, maSP).size();

                if (count == 1) {
                    GioHang gh = svGH.getGioHangTonTai(maHD, maSP).get(0);
                    tongSoLuong = gh.getSoLuong() + soLuong;
                    Integer thanhTien2 = tongSoLuong * gia;
                    ServiceGioHang.updateGioHangByMa(maSP, tongSoLuong, thanhTien2);
                    loadDataGioHangbyMa(maHD);
                } else {
                    ServiceGioHang.insertDataToGH(maSP, maHD, ten, gia, soLuong, thanhTien);
                    loadDataGioHangbyMa(maHD);
                }

                for (GioHang gh : svGH.getGioHang()) {
                    if (gh.getMaHD().equals(maHD)) {
                        tongtien += gh.getThanhTien();

                    }
                }

                txtTongTien.setText(tongtien.toString());

                ServiceSanPham.updateSanPham(maSP, soLuongCon);

                loadDataSanPham();

            }
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void txtIDNVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDNVFocusLost
        // TODO add your handling code here:
        String ma = txtIDNV.getText();
        if (ma.equals("1")) {
            txtTenNT.setText("Nguyen Van A");
        } else if (ma.equals("2")) {
            txtTenNT.setText("Tran Thi B");
        } else if (ma.equals("3")) {
            txtTenNT.setText("Le Van C");
        } else if (ma.equals("4")) {
            txtTenNT.setText("Pham Van K");
        } else {
            JOptionPane.showMessageDialog(this, "Nhân viên với " + ma + " không tồn tại");
            txtTenNT.setText("");

        }

    }//GEN-LAST:event_txtIDNVFocusLost

    private void btnXoaGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGHActionPerformed
        // TODO add your handling code here:

        int i = tblGioHang.getSelectedRow();

        if (i >= 0) {
            Integer id = svGH.getRow(i).getId();
            String maSP = svGH.getRow(i).getMaSP();
            String maHD = svGH.getRow(i).getMaHD();
            Integer soLuongMua = svGH.getRow(i).getSoLuong();
            ServiceGioHang.deleteGioHang(id);
            loadDataGioHangbyMa(maHD);
            for (SanPham sp : svSP.getAll()) {
                if (sp.getMaSanPham().equals(maSP)) {
                    Integer soLuongTon = sp.getSoLuongTon();
                    Integer soLuongTonMoi = soLuongMua + soLuongTon;
                    ServiceSanPham.updateSanPham(maSP, soLuongTonMoi);
                }
            }
            loadDataSanPham();

        }

    }//GEN-LAST:event_btnXoaGHActionPerformed

    private void btnDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiActionPerformed
        // TODO add your handling code here:
        int soLuong = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhap so luong thay doi:"));
        int i = tblGioHang.getSelectedRow();
        Integer soLuongBang = svGH.getRow(i).getSoLuong();
        System.out.println(soLuongBang);
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Nhap lai so luong");

        } else if (soLuong < soLuongBang) {
            if (i >= 0) {
                Integer id = svGH.getRow(i).getId();
                String maSP = svGH.getRow(i).getMaSP();
                Integer thanhTien = soLuong * svGH.getRow(i).getGiaBan();
                String maHD = svGH.getRow(i).getMaHD();
                // Update Gio hang theo id
                ServiceGioHang.updateGioHang(id, soLuong, thanhTien);
                loadDataGioHangbyMa(maHD);
                for (SanPham sp : svSP.getAll()) {
                    if (sp.getMaSanPham().equals(maSP)) {
                        Integer soLuongTon = sp.getSoLuongTon();
                        Integer soLuongTonMoi = soLuongBang - soLuong + soLuongTon;
                        ServiceSanPham.updateSanPham(maSP, soLuongTonMoi);
                        loadDataSanPham();
                    }
                }
//                    loadDataSanPham();
            }

        } else if (soLuong > soLuongBang) {
            if (i >= 0) {
                Integer id = svGH.getRow(i).getId();
                String maSP = svGH.getRow(i).getMaSP();
                Integer thanhTien = soLuong * svGH.getRow(i).getGiaBan();
                String maHD = svGH.getRow(i).getMaHD();
                ServiceGioHang.updateGioHang(id, soLuong, thanhTien);
                loadDataGioHangbyMa(maHD);
                for (SanPham sp : svSP.getAll()) {
                    if (sp.getMaSanPham().endsWith(maSP)) {
                        Integer soLuongTon = sp.getSoLuongTon();
                        Integer soLuongTonMoi = soLuongTon + soLuongBang - soLuong;
                        ServiceSanPham.updateSanPham(maSP, soLuongTonMoi);
                        loadDataSanPham();
                    }
                }
//                    loadDataSanPham();
            }
        } else {
            return;
        }

        //Thay đổi tổng tiền
        String maHD = svGH.getRow(i).getMaHD();
        Integer tongtien = 0;
        for (GioHang gh : svGH.getGioHang()) {
            if (gh.getMaHD().equals(maHD)) {
                tongtien += gh.getThanhTien();

            }
        }

        txtTongTien.setText(tongtien.toString());

    }//GEN-LAST:event_btnDoiActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        if (i >= 0) {
            txtIDNV.setText(svHD.getRow(i).getIdNhanVien().toString());
            txtTenNT.setText(svHD.getRow(i).getTenNguoiTao());
            txtIDKH.setText(svHD.getRow(i).getIdKhachHang().toString());
            txtMaHoaDon.setText(svHD.getRow(i).getMaHD());
            txtNgayTao.setText(svHD.getRow(i).getNgayTao());
//            txtTongTien.setText(svHD.getRow(i).getTongTien().toString());
            txtKhachDua.setText("");
            txtThua.setText("");
            Integer tongtien = 0;
            String maHD = svHD.getRow(i).getMaHD();
            for (GioHang gh : svGH.getGioHang()) {
                if (gh.getMaHD().equals(maHD)) {
                    tongtien += gh.getThanhTien();

                }
            }

            txtTongTien.setText(tongtien.toString());
            loadDataGioHangbyMa(maHD);

        }


    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblGioHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblGioHangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangFocusLost

    private void btnDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiMouseClicked

    }//GEN-LAST:event_btnDoiMouseClicked

    private void menuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSanPhamMouseClicked
        // TODO add your handling code here:
        banHangPanel.setVisible(false);
        giohangPanel.setVisible(false);
        sanPhamPanel.setVisible(true);
        hoadonPanel.setVisible(false);
        nhanvienPanel.setVisible(false);
        menuSanPham.setFont(new java.awt.Font("Noto Sans", 1, 13)); // NOI18N
        menuHoaDon.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuGioHang.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuThongKe.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuNhanVien.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
    }//GEN-LAST:event_menuSanPhamMouseClicked

    private void menuThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMouseClicked
        // TODO add your handling code here:
        banHangPanel.setVisible(false);
        sanPhamPanel.setVisible(false);
        giohangPanel.setVisible(false);
        hoadonPanel.setVisible(true);
        nhanvienPanel.setVisible(false);
        menuSanPham.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuHoaDon.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuGioHang.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuThongKe.setFont(new java.awt.Font("Noto Sans", 1, 13)); // NOI18N
        menuNhanVien.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
    }//GEN-LAST:event_menuThongKeMouseClicked

    private void menuHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHoaDonMouseClicked
        // TODO add your handling code here:
        sanPhamPanel.setVisible(false);
        giohangPanel.setVisible(false);
        banHangPanel.setVisible(true);
        hoadonPanel.setVisible(false);
        nhanvienPanel.setVisible(false);
        menuSanPham.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuThongKe.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuHoaDon.setFont(new java.awt.Font("Noto Sans", 1, 13)); // NOI18N
        menuNhanVien.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuGioHang.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
    }//GEN-LAST:event_menuHoaDonMouseClicked

    private void menuNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNhanVienMouseClicked
        // TODO add your handling code here:
        banHangPanel.setVisible(false);
        sanPhamPanel.setVisible(false);
        giohangPanel.setVisible(false);
        hoadonPanel.setVisible(false);
        nhanvienPanel.setVisible(true);
        menuSanPham.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuHoaDon.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuGioHang.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuThongKe.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuNhanVien.setFont(new java.awt.Font("Noto Sans", 1, 13)); // NOI18N
    }//GEN-LAST:event_menuNhanVienMouseClicked

    private void menuGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuGioHangMouseClicked
        // TODO add your handling code here:
        banHangPanel.setVisible(false);
        sanPhamPanel.setVisible(false);
        giohangPanel.setVisible(true);
        hoadonPanel.setVisible(false);
        nhanvienPanel.setVisible(false);
        menuSanPham.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuHoaDon.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuGioHang.setFont(new java.awt.Font("Noto Sans", 1, 13)); // NOI18N
        menuThongKe.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
        menuNhanVien.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
    }//GEN-LAST:event_menuGioHangMouseClicked

    private void tblHoaDon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon1MouseClicked
        // TODO add your handling code here:
        int i =tblHoaDon1.getSelectedRow();
        String ma = (String) tblHoaDon1.getValueAt(i, 1);
        DefaultTableModel modelChiTietHoaDon = (DefaultTableModel) tblChiTietHoaDon.getModel();
        modelChiTietHoaDon.setRowCount(0);
        int sttChiTietHoaDon = 1;
        for (HoaDonChiTiet ct : svHDCT.searchChiTiet(ma)) {
            Object[] row = {
                sttChiTietHoaDon,
                ct.getCt_id(),
                ct.getCt_maHD(),
                ct.getCt_tenNV(),
                ct.getCt_ngayTao(),
                ct.getCt_id_KH(),
                ct.getCt_maSP(),
                ct.getCt_tenSP(),
                ct.getCt_TongSL(),
                ct.getCt_TongMauSac(),
                ct.getCt_TongTien()
            };
            modelChiTietHoaDon.addRow(row);
            sttChiTietHoaDon++;
        }

    }//GEN-LAST:event_tblHoaDon1MouseClicked

    private void btTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTraHangActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHoaDon1.getSelectedRow();
        if (selectedRow != -1) {
            String maHD = tblHoaDon1.getValueAt(selectedRow, 1).toString(); // Assuming the second column contains the invoice code

            // Ask for confirmation
            int confirmation = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn 'Trả hàng'?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                int result = svHD.updateTrangThaiToTraHang(maHD);
                if (result > 0) {

                    loadDataHoaDon1();
                } else {
                    // Update failed, handle accordingly
                    System.out.println("Cập nhật thất bại!");
                }
            }
        }
    }//GEN-LAST:event_btTraHangActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        loadDataChiTietHoaDon();
    }//GEN-LAST:event_jButton3MouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String keyword = txtTimKiem.getText();

        // Tìm kiếm và cập nhật dữ liệu trong bảng tblHoaDon1
        DefaultTableModel modelHoaDon1 = (DefaultTableModel) tblHoaDon1.getModel();
        modelHoaDon1.setRowCount(0);
        int sttHoaDon1 = 1;
        for (HoaDonChiTiet ct : svHDCT.searchChiTiet(keyword)) {
            Object[] row = {
                sttHoaDon1,
                ct.getCt_maHD(),
                ct.getCt_ngayTao(),
                ct.getCt_tenNV(),
                ct.getCt_TrangThai()
            };
            modelHoaDon1.addRow(row);
            sttHoaDon1++;
        }

        // Tìm kiếm và cập nhật dữ liệu trong bảng tblChiTietHoaDon
        //        DefaultTableModel modelChiTietHoaDon = (DefaultTableModel) tblChiTietHoaDon.getModel();
        //        modelChiTietHoaDon.setRowCount(0);
        //        int sttChiTietHoaDon = 1;
        //        for (HoaDonChiTiet ct : svHDCT.searchChiTiet(keyword)) {
            //            Object[] row = {
                //                sttChiTietHoaDon,
                //                ct.getCt_id(),
                //                ct.getCt_maHD(),
                //                ct.getCt_tenNV(),
                //                ct.getCt_ngayTao(),
                //                ct.getCt_id_KH(),
                //                ct.getCt_maSP(),
                //                ct.getCt_tenSP(),
                //                ct.getCt_TongSL(),
                //                ct.getCt_TongMauSac(),
                //                ct.getCt_TongTien()
                //            };
            //            modelChiTietHoaDon.addRow(row);
            //            sttChiTietHoaDon++;
            //        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtNgayKetThucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgayKetThucKeyPressed
        // TODO add your handling code here
    }//GEN-LAST:event_txtNgayKetThucKeyPressed

    private void txtNgayKetThucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgayKetThucKeyReleased

    }//GEN-LAST:event_txtNgayKetThucKeyReleased

    private void btSearchTheoNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchTheoNgayActionPerformed
        // TODO add your handling code here:
        Date batDau = txtNgayBatDau.getDate();
        Date ketThuc = txtNgayKetThuc.getDate();

        // Kiểm tra nếu ngày bắt đầu hoặc ngày kết thúc không được chọn
        if (batDau == null || ketThuc == null) {
            // Hiển thị thông báo và ngăn chặn việc thực hiện tiếp theo
            JOptionPane.showMessageDialog(null, "Vui lòng chọn cả ngày bắt đầu và ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Kết thúc phương thức
        }

        // Kiểm tra nếu ngày kết thúc trước ngày bắt đầu
        if (ketThuc.before(batDau)) {
            // Hiển thị thông báo và ngăn chặn việc thực hiện tiếp theo
            JOptionPane.showMessageDialog(null, "Ngày kết thúc không thể trước ngày bắt đầu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Kết thúc phương thức
        }

        // Tiếp tục thực hiện công việc nếu không có lỗi về ngày tháng
        DefaultTableModel modelHoaDon1 = (DefaultTableModel) tblHoaDon1.getModel();
        modelHoaDon1.setRowCount(0);
        int sttHoaDon1 = 1;
        for (HoaDonChiTiet ct : svHDCT.searchChiTietTheoKhoang(batDau, ketThuc)) {
            Object[] row = {
                sttHoaDon1,
                ct.getCt_maHD(),
                ct.getCt_ngayTao(),
                ct.getCt_tenNV(),
                ct.getCt_TrangThai()
            };
            modelHoaDon1.addRow(row);
            sttHoaDon1++;
        }

        //        DefaultTableModel modelChitiet = (DefaultTableModel) tblChiTietHoaDon.getModel();
        //        modelChitiet.setRowCount(0);
        //        int sttChiTietHoaDon = 1;
        //        for (HoaDonChiTiet ct : svHDCT.searchChiTietTheoKhoang(batDau, ketThuc)) {
            //            Object[] row1 = {
                //                sttChiTietHoaDon,
                //                ct.getCt_id(),
                //                ct.getCt_maHD(),
                //                ct.getCt_tenNV(),
                //                ct.getCt_ngayTao(),
                //                ct.getCt_id_KH(),
                //                ct.getCt_maSP(),
                //                ct.getCt_tenSP(),
                //                ct.getCt_TongSL(),
                //                ct.getCt_TongMauSac(),
                //                ct.getCt_TongTien()
                //            };
            //            modelChitiet.addRow(row1);
            //            sttChiTietHoaDon++;
            //        }
    }//GEN-LAST:event_btSearchTheoNgayActionPerformed

    private void btLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLamMoiActionPerformed
        // TODO add your handling code here:
        txtIDNV.setText("");
        txtTenNT.setText("");
        txtIDKH.setText("");
        txtMaHoaDon.setText("");
        txtNgayTao.setText(date);

    }//GEN-LAST:event_btLamMoiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(app_hanoistyle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(app_hatxtTenNVss.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(app_hanoistyle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(app_hanoistyle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new app_hanoistyle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JPanel banHangPanel;
    private javax.swing.JButton btLamMoi;
    private javax.swing.JButton btSearchTheoNgay;
    private javax.swing.JButton btTraHang;
    private javax.swing.JButton btnDoi;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaGH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel giohangPanel;
    private javax.swing.JPanel hoadonPanel;
    private javax.swing.JPanel hoadonPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel menuGioHang;
    private javax.swing.JLabel menuHoaDon;
    private javax.swing.JLabel menuNhanVien;
    private javax.swing.JLabel menuSanPham;
    private javax.swing.JLabel menuThongKe;
    private javax.swing.JPanel nhanvienPanel;
    private javax.swing.JPanel sanPhamPanel;
    private javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDon1;
    private javax.swing.JTable tblSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtIDKH;
    private javax.swing.JTextField txtIDNV;
    private javax.swing.JTextField txtKhachDua;
    private javax.swing.JTextField txtMaHoaDon;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenNT;
    private javax.swing.JTextField txtThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
