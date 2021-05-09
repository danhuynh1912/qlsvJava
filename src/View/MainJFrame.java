package View;


import DAO.AddData;
import DAO.ConnectDB;
import Model.CanBoGiaoVien;
import Model.GiaDinh;
import Model.KhenThuong;
import Model.KyLuat;
import Model.Lop;
import Model.SinhVien;
import Utility.CustomTableGiaDinh;
import Utility.CustomTableSinhVien;
import Utility.CustonTableLop;
import Utility.KhenThuongCustomTable;
import Utility.KyLuatCustomTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MainJFrame extends javax.swing.JFrame {
    private String gt;
    int dong = -1;
    ConnectDB conn = null;
    AddData duLieu = new AddData();
    ArrayList<Lop> arr_Lop = new ArrayList<>();
    ArrayList<CanBoGiaoVien> arr_CBGV = new ArrayList<>();
    ArrayList<SinhVien> arr_hocsinh = new ArrayList<>();
    ArrayList<GiaDinh> arr_giadinh = new ArrayList<>();
    ArrayList<KhenThuong> arr_khenthuong = new ArrayList<>();
    ArrayList<KyLuat> arr_kyluat = new ArrayList<>();
    public MainJFrame() {
        
        
        setTitle("QUẢN LÝ SINH VIÊN");
        initComponents();
        conn = new ConnectDB();
        
        CenteredFrame(this);
        DaTa();
        loadComboGVCN();
        loadBangLop();
        loadComboMaLop1();
        loadTableSinhVien();
        loadTableGiaDinh();
        loadTableKhenThuong();
        loadTableKyLuat();

        loadComboTenLop();

        
        
        //ChuyenManHinhConTroller controller = new ChuyenManHinhConTroller(jpnView);
        //controller.setView(jpnTrangChinh, jlbTrangChinh);
        
        
        // Menu
//        List<DanhMucBean> listItem = new ArrayList<>();
//        listItem.add(new DanhMucBean("TrangChinh", jpnTrangChinh, jlbTrangChinh));
//        listItem.add(new DanhMucBean("SinhVien", jpnSinhVien, jlbSinhVien));
//        listItem.add(new DanhMucBean("KyLuat", jpnKyLuat, jlbKyLuat));
//        listItem.add(new DanhMucBean("KhenThuong", jpnKhenThuong, jlbKhenThuong));
//        listItem.add(new DanhMucBean("Lop", jpnLop, jlbLop));
//        listItem.add(new DanhMucBean("DoiMatKhau", jpnDoiMatKhau, jlbDoiMatKhau));
//        controller.setEvent(listItem);
    }
    public void CenteredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }
    public void DaTa() {
        // add dữ liệu lớp học
        try{
        duLieu.add_Class();
        String sql = "Select * from Lop";
        if (conn.getData_Lop(sql) != null) {
            arr_Lop = conn.getData_Lop(sql);
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }

        // add dữ liệu của cán bộ
        try{
        duLieu.add_GiaoVien();
        String sql_cbgv = "select * from GIAOVIEN";
        if (conn.getData_CBGV(sql_cbgv) != null) {
            arr_CBGV = conn.getData_CBGV(sql_cbgv);
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }

      
            // add dữ liệu của hs
        try{
            duLieu.add_SinhVien();
            String sql_hs = "select * from SinhVien";
            if (conn.getData_SinhVien(sql_hs) != null) {
                arr_hocsinh = conn.getData_SinhVien(sql_hs);
            }
        }
            catch (Exception e) {
            System.out.println(e.getMessage());

        }
       
try{
            duLieu.add_KhenThuong();
            String sql_kt = "select * from KhenThuong";
            if (conn.getData_KhenThuong(sql_kt) != null) {
                arr_khenthuong = conn.getData_KhenThuong(sql_kt);
            }
    }
            catch (Exception e) {
            System.out.println(e.getMessage());

        }



            try{
            duLieu.add_KyLuat();
            String sql_kl = "select * from KyLuat";
            if (conn.getData_KyLuat(sql_kl) != null) {
                arr_kyluat = conn.getData_KyLuat(sql_kl);
            }
            }
            catch (Exception e) {
            System.out.println(e.getMessage());

        }
      

            try{
            duLieu.add_GiaDinh();
            String sql_gd = "select * from GiaDinh";
            if (conn.getData_GiaDinh(sql_gd) != null) {
                arr_giadinh = conn.getData_GiaDinh(sql_gd);
            }
            }
            catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void loadBangLop() {
        tablelop.setModel(new CustonTableLop(arr_Lop));
    }
    public void loadTableSinhVien() {
        tablesv.setModel(new CustomTableSinhVien(arr_hocsinh));
    }
     public void loadComboGVCN() {
        for (int i = 0; i < arr_CBGV.size(); i++) {
            cbgvcn.addItem(arr_CBGV.get(i).getHoTen());
        }
    }
      public void loadComboMaLop1() {
        for (int i = 0; i < arr_Lop.size(); i++) {
            cbmlsv.addItem(arr_Lop.get(i).getMalop());
        }
      }
      public void loadComboTenLop() {
        for (int i = 0; i < arr_Lop.size(); i++) {
            cblopsv.addItem(arr_Lop.get(i).getTenlop());
        }
    }
     
     public void loadTableGiaDinh() {
        tablegd.setModel(new CustomTableGiaDinh(arr_giadinh));
    }
     public void loadTableKyLuat() {
        tablekl.setModel(new KyLuatCustomTable(arr_kyluat));
    }
      public void loadTableKhenThuong() {
        tablekt.setModel(new KhenThuongCustomTable(arr_khenthuong));
    }
      private void Xoatrang1(){
          txtmsv.setText("");
          txttsv.setText("");
          txtstd.setText("");
          txtns.setText("");
          txtdt.setText("");
          txtdc.setText("");
          txtcmnd.setText("");
          txtemail.setText("");  
      }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jpnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnTrangChinh = new javax.swing.JPanel();
        jlbTrangChinh = new javax.swing.JLabel();
        jpnSinhVien = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jpnKyLuat = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jpnKhenThuong = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jpnLop = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jpnDoiMatKhau = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jpnView = new javax.swing.JPanel();
        trangChinhJPanel1 = new View.TrangChinhJPanel();
        jpnSv = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtmsv = new javax.swing.JTextField();
        txttsv = new javax.swing.JTextField();
        txtns = new javax.swing.JTextField();
        txtdc = new javax.swing.JTextField();
        txtdt = new javax.swing.JTextField();
        txtstd = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtcmnd = new javax.swing.JTextField();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        cbmlsv = new javax.swing.JComboBox();
        cblopsv = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsapxep = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btntailai = new javax.swing.JButton();
        btnxoatrang = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablesv = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rdtkmsv = new javax.swing.JRadioButton();
        rdtkml = new javax.swing.JRadioButton();
        jButton7 = new javax.swing.JButton();
        jpnKt = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtmsvkt = new javax.swing.JTextField();
        txtmkt = new javax.swing.JTextField();
        txttkt = new javax.swing.JTextField();
        txthtkt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnthemkt = new javax.swing.JButton();
        btnsuakt = new javax.swing.JButton();
        btnxoakt = new javax.swing.JButton();
        btnxoatrangkt = new javax.swing.JButton();
        btnsapxepkt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablekt = new javax.swing.JTable();
        jpnGd = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnthemgd = new javax.swing.JButton();
        btnsuagd = new javax.swing.JButton();
        btnxoagd = new javax.swing.JButton();
        btnxoatranggd = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txttenbo = new javax.swing.JTextField();
        txttuoibo = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtdantocbo = new javax.swing.JTextField();
        txtsdtbo = new javax.swing.JTextField();
        txtnghenghiepbo = new javax.swing.JTextField();
        txttenme = new javax.swing.JTextField();
        txttuoime = new javax.swing.JTextField();
        txtdiachime = new javax.swing.JTextField();
        txtdantocme = new javax.swing.JTextField();
        txtsdtme = new javax.swing.JTextField();
        txtnghenghiepme = new javax.swing.JTextField();
        txtdiachiace = new javax.swing.JTextField();
        txttuoiace = new javax.swing.JTextField();
        txttenace = new javax.swing.JTextField();
        txtdantocace = new javax.swing.JTextField();
        txtsdtace = new javax.swing.JTextField();
        txtnghenghiepace = new javax.swing.JTextField();
        txtmsvgd = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablegd = new javax.swing.JTable();
        jpnKl = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtmsvkl = new javax.swing.JTextField();
        txtmkl = new javax.swing.JTextField();
        txttkl = new javax.swing.JTextField();
        txthtkl = new javax.swing.JTextField();
        txtmdkl = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnthemkl = new javax.swing.JButton();
        btnsuakl = new javax.swing.JButton();
        btnxoakl = new javax.swing.JButton();
        btnsapxepkl = new javax.swing.JButton();
        btnxoatrangkl = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablekl = new javax.swing.JTable();
        jpnL = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtss = new javax.swing.JTextField();
        txtnganh = new javax.swing.JTextField();
        cbgvcn = new javax.swing.JComboBox();
        txtmll = new javax.swing.JTextField();
        txttll = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btntheml = new javax.swing.JButton();
        btnsual = new javax.swing.JButton();
        btnxoal = new javax.swing.JButton();
        btnxoatrangl = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        rdtkmll = new javax.swing.JRadioButton();
        rdtkgvcn = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablelop = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMenu.setBackground(new java.awt.Color(0, 102, 0));

        jPanel4.setBackground(new java.awt.Color(0, 255, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_people_black_24dp.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jpnTrangChinh.setBackground(new java.awt.Color(0, 204, 0));

        jlbTrangChinh.setBackground(new java.awt.Color(0, 0, 51));
        jlbTrangChinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlbTrangChinh.setForeground(new java.awt.Color(0, 0, 51));
        jlbTrangChinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_home_black_24dp.png"))); // NOI18N
        jlbTrangChinh.setText("Màn hình chính");

        javax.swing.GroupLayout jpnTrangChinhLayout = new javax.swing.GroupLayout(jpnTrangChinh);
        jpnTrangChinh.setLayout(jpnTrangChinhLayout);
        jpnTrangChinhLayout.setHorizontalGroup(
            jpnTrangChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChinhLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jlbTrangChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnTrangChinhLayout.setVerticalGroup(
            jpnTrangChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTrangChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTrangChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jpnSinhVien.setBackground(new java.awt.Color(0, 204, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_account_circle_black_24dp.png"))); // NOI18N
        jButton1.setText("Sinh Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnSinhVienLayout = new javax.swing.GroupLayout(jpnSinhVien);
        jpnSinhVien.setLayout(jpnSinhVienLayout);
        jpnSinhVienLayout.setHorizontalGroup(
            jpnSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSinhVienLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSinhVienLayout.setVerticalGroup(
            jpnSinhVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSinhVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnKyLuat.setBackground(new java.awt.Color(0, 204, 0));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_thumb_down_black_24dp.png"))); // NOI18N
        jButton2.setText("Kỷ Luật");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnKyLuatLayout = new javax.swing.GroupLayout(jpnKyLuat);
        jpnKyLuat.setLayout(jpnKyLuatLayout);
        jpnKyLuatLayout.setHorizontalGroup(
            jpnKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKyLuatLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKyLuatLayout.setVerticalGroup(
            jpnKyLuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKyLuatLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnKhenThuong.setBackground(new java.awt.Color(0, 204, 0));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_stars_black_24dp.png"))); // NOI18N
        jButton3.setText("Khen Thưởng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnKhenThuongLayout = new javax.swing.GroupLayout(jpnKhenThuong);
        jpnKhenThuong.setLayout(jpnKhenThuongLayout);
        jpnKhenThuongLayout.setHorizontalGroup(
            jpnKhenThuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhenThuongLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKhenThuongLayout.setVerticalGroup(
            jpnKhenThuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhenThuongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 0));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_exit_to_app_black_24dp.png"))); // NOI18N
        jButton6.setText("Thoát");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(34, 34, 34))
        );

        jpnLop.setBackground(new java.awt.Color(0, 204, 0));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_family_restroom_black_24dp.png"))); // NOI18N
        jButton4.setText("Gia Đình");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnLopLayout = new javax.swing.GroupLayout(jpnLop);
        jpnLop.setLayout(jpnLopLayout);
        jpnLopLayout.setHorizontalGroup(
            jpnLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLopLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnLopLayout.setVerticalGroup(
            jpnLopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnLopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(21, 21, 21))
        );

        jpnDoiMatKhau.setBackground(new java.awt.Color(0, 204, 0));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 51));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/outline_school_black_24dp.png"))); // NOI18N
        jButton5.setText("Lớp");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnDoiMatKhauLayout = new javax.swing.GroupLayout(jpnDoiMatKhau);
        jpnDoiMatKhau.setLayout(jpnDoiMatKhauLayout);
        jpnDoiMatKhauLayout.setHorizontalGroup(
            jpnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoiMatKhauLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnDoiMatKhauLayout.setVerticalGroup(
            jpnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoiMatKhauLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnView.setLayout(new java.awt.CardLayout());
        jpnView.add(trangChinhJPanel1, "card7");

        jLabel2.setText("Mã Sinh Viên");

        jLabel3.setText("Tên Sinh Viên");

        jLabel4.setText("Ngày Sinh");

        jLabel5.setText("Địa Chỉ");

        jLabel7.setText("Dân Tộc");

        jLabel8.setText("Số Điện Thoại");

        jLabel9.setText("Email");

        jLabel10.setText("CMND");

        jLabel11.setText("Giới Tính");

        jLabel12.setText("Mã Lớp");

        jLabel13.setText("Lớp");

        txtns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnsActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdnam);
        rdnam.setText("Nam");
        rdnam.setName("rdnam"); // NOI18N

        buttonGroup1.add(rdnu);
        rdnu.setText("Nữ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmsv)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttsv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtns, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(txtstd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdnam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdnu))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cblopsv, javax.swing.GroupLayout.Alignment.LEADING, 0, 86, Short.MAX_VALUE)
                                .addComponent(cbmlsv, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtstd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rdnam)
                    .addComponent(rdnu))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbmlsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cblopsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsapxep.setText("Sắp Xếp");
        btnsapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsapxepActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btntailai.setText("Tải Lại");
        btntailai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntailaiActionPerformed(evt);
            }
        });

        btnxoatrang.setText("Xóa Trắng");
        btnxoatrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatrangActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnthem)
                            .addComponent(btnxoa))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsapxep)
                            .addComponent(btnsua)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnxoatrang)
                        .addGap(18, 18, 18)
                        .addComponent(btntailai)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoa)
                    .addComponent(btnsapxep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoatrang)
                    .addComponent(btntailai))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tablesv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablesv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablesv);

        jLabel6.setText("Tìm Kiếm");

        buttonGroup2.add(rdtkmsv);
        rdtkmsv.setText("Mã Sinh Viên");

        buttonGroup2.add(rdtkml);
        rdtkml.setText("Mã Lớp");

        jButton7.setText("Tìm Kiếm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdtkml)
                            .addComponent(rdtkmsv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdtkmsv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(rdtkml))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout jpnSvLayout = new javax.swing.GroupLayout(jpnSv);
        jpnSv.setLayout(jpnSvLayout);
        jpnSvLayout.setHorizontalGroup(
            jpnSvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnSvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );
        jpnSvLayout.setVerticalGroup(
            jpnSvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSvLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        jpnView.add(jpnSv, "card2");

        jLabel14.setText("Mã Sinh Viên");

        jLabel15.setText("Mã Khen Thưởng");

        jLabel16.setText("Tên Khen Thưởng");

        jLabel17.setText("Hình Thức");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel17)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthtkt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txttkt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtmkt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtmsvkt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtmsvkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtmkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txttkt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txthtkt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnthemkt.setText("Thêm");
        btnthemkt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemktActionPerformed(evt);
            }
        });

        btnsuakt.setText("Sửa");
        btnsuakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaktActionPerformed(evt);
            }
        });

        btnxoakt.setText("Xóa");
        btnxoakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaktActionPerformed(evt);
            }
        });

        btnxoatrangkt.setText("Xóa Trắng");
        btnxoatrangkt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatrangktActionPerformed(evt);
            }
        });

        btnsapxepkt.setText("Sắp Xếp");
        btnsapxepkt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsapxepktActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnsapxepkt)
                        .addGap(18, 18, 18)
                        .addComponent(btnxoatrangkt))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnthemkt)
                            .addComponent(btnxoakt))
                        .addGap(32, 32, 32)
                        .addComponent(btnsuakt)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemkt)
                    .addComponent(btnsuakt))
                .addGap(22, 22, 22)
                .addComponent(btnxoakt)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsapxepkt)
                    .addComponent(btnxoatrangkt))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tablekt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablekt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablektMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablekt);

        javax.swing.GroupLayout jpnKtLayout = new javax.swing.GroupLayout(jpnKt);
        jpnKt.setLayout(jpnKtLayout);
        jpnKtLayout.setHorizontalGroup(
            jpnKtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnKtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnKtLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnKtLayout.setVerticalGroup(
            jpnKtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKtLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jpnKtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnKtLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jpnView.add(jpnKt, "card3");

        btnthemgd.setText("Thêm");

        btnsuagd.setText("Sửa");

        btnxoagd.setText("Xóa");

        btnxoatranggd.setText("Xóa Trắng");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(btnthemgd)
                .addGap(34, 34, 34)
                .addComponent(btnsuagd)
                .addGap(18, 18, 18)
                .addComponent(btnxoagd)
                .addGap(18, 18, 18)
                .addComponent(btnxoatranggd)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoatranggd)
                    .addComponent(btnxoagd)
                    .addComponent(btnsuagd)
                    .addComponent(btnthemgd))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel28.setText("Mã Sinh Viên");

        jLabel29.setText("Họ Tên");

        jLabel30.setText("Tuổi");

        jLabel31.setText("Địa Chỉ");

        jLabel32.setText("Dân Tộc");

        jLabel33.setText("Số Điện Thoại");

        jLabel34.setText("Nghề Nghiệp");

        jLabel35.setText("Họ Tên");

        jLabel36.setText("Tuổi");

        jLabel37.setText("Đại Chỉ");

        jLabel38.setText("Dân Tộc");

        jLabel39.setText("Số Điện Thoại");

        jLabel40.setText("Nghề Nghiệp");

        jLabel41.setText("Họ Tên");

        jLabel42.setText("Tuổi");

        jLabel43.setText("Anh/Chị/Em");

        jLabel44.setText("Địa Chỉ");

        jLabel45.setText("Dân Tộc");

        jLabel46.setText("Số Điện Thoại");

        jLabel47.setText("Nghề Nghiệp");

        jLabel48.setText("Bố");

        jLabel49.setText("Mẹ");

        txtdantocbo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdantocboActionPerformed(evt);
            }
        });

        txtdiachiace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachiaceActionPerformed(evt);
            }
        });

        txttuoiace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttuoiaceActionPerformed(evt);
            }
        });

        txtsdtace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtaceActionPerformed(evt);
            }
        });

        tablegd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablegd);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmsvgd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel44)
                                .addComponent(jLabel42)
                                .addComponent(jLabel41))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txttenace, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(txttuoiace)
                                .addComponent(txtdiachiace))
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel45)
                                .addComponent(jLabel46)
                                .addComponent(jLabel47))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtdantocace, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(txtsdtace)
                                .addComponent(txtnghenghiepace)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttenbo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttuoibo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(txtdantocbo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtsdtbo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtnghenghiepbo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel48))
                            .addGap(59, 59, 59)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel49)
                                .addComponent(jLabel35)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)
                                .addComponent(jLabel38)
                                .addComponent(jLabel39)
                                .addComponent(jLabel40))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtnghenghiepme, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtsdtme, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdantocme, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdiachime, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttuoime, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttenme, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtmsvgd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jLabel49))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel35)
                            .addComponent(txttenbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel36)
                            .addComponent(txttuoibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttuoime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel37)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel38)
                            .addComponent(txtdantocbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdantocme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel39)
                            .addComponent(txtsdtbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdtme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel40)
                            .addComponent(txtnghenghiepbo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnghenghiepme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txttenace, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdantocace, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(35, 35, 35)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtsdtace, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addContainerGap())
                                    .addComponent(txtnghenghiepace)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel41)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel42))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(113, 113, 113)
                                        .addComponent(txttuoiace, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtdiachiace)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jpnGdLayout = new javax.swing.GroupLayout(jpnGd);
        jpnGd.setLayout(jpnGdLayout);
        jpnGdLayout.setHorizontalGroup(
            jpnGdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnGdLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnGdLayout.setVerticalGroup(
            jpnGdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGdLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnView.add(jpnGd, "card4");

        jLabel18.setText("Mã Sinh Viên");

        jLabel19.setText("Mã Kỷ Luật");

        jLabel20.setText("Tên Kỷ Luật");

        jLabel21.setText("Hình Thức");

        jLabel22.setText("Mức Độ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtmsvkl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmdkl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txthtkl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtmkl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(txttkl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(81, 81, 81))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtmsvkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtmkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txttkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txthtkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtmdkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnthemkl.setText("Thêm");
        btnthemkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemklActionPerformed(evt);
            }
        });

        btnsuakl.setText("Sửa");

        btnxoakl.setText("Xóa");
        btnxoakl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaklActionPerformed(evt);
            }
        });

        btnsapxepkl.setText("Sắp Xếp");
        btnsapxepkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsapxepklActionPerformed(evt);
            }
        });

        btnxoatrangkl.setText("Xóa Trắng");
        btnxoatrangkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatrangklActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnxoakl)
                    .addComponent(btnthemkl)
                    .addComponent(btnxoatrangkl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsapxepkl)
                    .addComponent(btnsuakl))
                .addGap(29, 29, 29))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsuakl)
                    .addComponent(btnthemkl))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsapxepkl)
                    .addComponent(btnxoakl))
                .addGap(17, 17, 17)
                .addComponent(btnxoatrangkl)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        tablekl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablekl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableklMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablekl);

        javax.swing.GroupLayout jpnKlLayout = new javax.swing.GroupLayout(jpnKl);
        jpnKl.setLayout(jpnKlLayout);
        jpnKlLayout.setHorizontalGroup(
            jpnKlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKlLayout.createSequentialGroup()
                .addGroup(jpnKlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnKlLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnKlLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jpnKlLayout.setVerticalGroup(
            jpnKlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKlLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jpnKlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(jpnKlLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jpnView.add(jpnKl, "card5");

        jLabel23.setText("Mã Lớp");

        jLabel24.setText("Tên Lớp");

        jLabel25.setText("Giáo Viên Chủ Nhiệm");

        jLabel26.setText("Sĩ Số");

        jLabel27.setText("Ngành");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtss, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnganh, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbgvcn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmll, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txttll))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtmll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(txttll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cbgvcn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtnganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        btntheml.setText("Thêm");
        btntheml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemlActionPerformed(evt);
            }
        });

        btnsual.setText("Sửa");
        btnsual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsualActionPerformed(evt);
            }
        });

        btnxoal.setText("Xóa");
        btnxoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoalActionPerformed(evt);
            }
        });

        btnxoatrangl.setText("Xóa Trắng");
        btnxoatrangl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoatranglActionPerformed(evt);
            }
        });

        jLabel50.setText("Tìm Kiếm");

        rdtkmll.setText("Mã Lớp");

        rdtkgvcn.setText("GVCN");

        jButton8.setText("Tìm Kiếm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdtkgvcn)
                            .addComponent(rdtkmll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addGap(20, 20, 20))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdtkmll)
                        .addGap(3, 3, 3)
                        .addComponent(rdtkgvcn))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton8)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntheml)
                    .addComponent(btnxoal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsual)
                    .addComponent(btnxoatrangl))
                .addGap(33, 33, 33))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntheml)
                    .addComponent(btnsual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoal)
                    .addComponent(btnxoatrangl))
                .addGap(40, 40, 40)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablelop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablelop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablelopMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablelop);

        javax.swing.GroupLayout jpnLLayout = new javax.swing.GroupLayout(jpnL);
        jpnL.setLayout(jpnLLayout);
        jpnLLayout.setHorizontalGroup(
            jpnLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnLLayout.setVerticalGroup(
            jpnLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnLLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jpnView.add(jpnL, "card6");

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpnLop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnKhenThuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnKyLuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnSinhVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnTrangChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnDoiMatKhau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1009, 1009, 1009))
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1060, 1060, 1060))))
            .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnMenuLayout.createSequentialGroup()
                    .addGap(404, 404, 404)
                    .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnTrangChinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpnMenuLayout.createSequentialGroup()
                    .addGap(78, 78, 78)
                    .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnsActionPerformed

    private void txtdantocboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdantocboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdantocboActionPerformed

    private void txttuoiaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttuoiaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttuoiaceActionPerformed

    private void txtdiachiaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachiaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachiaceActionPerformed

    private void txtsdtaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtaceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jpnView.removeAll();
        jpnView.add(jpnSv);
        jpnView.repaint();
        jpnView.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jpnView.removeAll();
        jpnView.add(jpnKl);
        jpnView.repaint();
        jpnView.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jpnView.removeAll();
        jpnView.add(jpnKt);
        jpnView.repaint();
        jpnView.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jpnView.removeAll();
        jpnView.add(jpnGd);
        jpnView.repaint();
        jpnView.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jpnView.removeAll();
        jpnView.add(jpnL);
        jpnView.repaint();
        jpnView.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
          
          ButtonGroup gb = new ButtonGroup();
            gb.add(rdnu);
            gb.add(rdnam);
          String msv = txtmsv.getText();
          String ten = txttsv.getText();
          String sdt =txtstd.getText();
          String ns =txtns.getText();
          String dt =txtdt.getText();
          String dc =txtdc.getText();
          String cmnd =txtcmnd.getText();
          String email =txtemail.getText();
          String malop = cbmlsv.getSelectedItem().toString();
          String tenlop = cblopsv.getSelectedItem().toString();
          
          if(rdnam.isSelected()){
               gt = String.valueOf(rdnam.getText()) ;
          }
          if(rdnu.isSelected()){
                gt = String.valueOf(rdnu.getText()) ;
          }
           String lop1 = "insert into SinhVien values('" + msv + "','" + ten + "','" + ns + "','" + gt + "','" + dc + "','" + sdt + "','" + email + "','" + dt + "','" + cmnd + "','" + tenlop + "','" + malop + "')";
            conn.doSQL(lop1);
        arr_hocsinh.clear();
        try {
        String sql = "Select * from SINHVIEN";
        if (conn.getData_SinhVien(sql) != null) {
            arr_hocsinh = conn.getData_SinhVien(sql);
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
        
        loadTableSinhVien();
        Xoatrang1();
        cbmlsv.removeAllItems();
        loadComboMaLop1();
        cblopsv.removeAllItems();
        loadComboTenLop();
        JOptionPane.showMessageDialog(this, "Thêm thành công thông tin sinh viên !!!");  
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
          ButtonGroup gb = new ButtonGroup();
          gb.add(rdnu);
          gb.add(rdnam);
          String msv = txtmsv.getText();
          String ten = txttsv.getText();
          String sdt =txtstd.getText();
          String ns =txtns.getText();
          String dt =txtdt.getText();
          String dc =txtdc.getText();
          String cmnd =txtcmnd.getText();
          String email =txtemail.getText();
          String malop = cbmlsv.getSelectedItem().toString();
          String tenlop = cblopsv.getSelectedItem().toString();
          
          if(rdnam.isSelected()){
               gt = String.valueOf(rdnam.getText()) ;
          }
          if(rdnu.isSelected()){
                gt = String.valueOf(rdnu.getText()) ;
          }
          String lop1 = "update SinhVien set Hoten = '" + ten + "', ngaysinh = '" + ns + "',gioitinh='" + gt + "',diachi='" + dc + "',SDT='" + sdt + "',email='" + email + "',dantoc='" + dt + "',CMND='" + cmnd + "',lop='" + tenlop + "',malop='" + malop + "' "
                + "where msv = '" + msv + "'";
            conn.doSQL(lop1);
            arr_hocsinh.clear();
        String sql = "Select * from SinhVien";
        if (conn.getData_SinhVien(sql) != null) {
            arr_hocsinh = conn.getData_SinhVien(sql);
            loadTableSinhVien();
            Xoatrang1();
            cbmlsv.removeAllItems();
            loadComboMaLop1();
            cblopsv.removeAllItems();
            loadComboTenLop();
            JOptionPane.showMessageDialog(this, "Sửa thành công thông tin sinh viên !!!");
        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int dlr = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không ???", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (dlr == JOptionPane.YES_OPTION) {
            dong = tablesv.getSelectedRow();
            if (dong != -1) {
                String masv = arr_hocsinh.get(dong).getMsv();
                String sql = "delete from SinhVien where msv = '" + masv + "'";
                conn.doSQL(sql);

                arr_hocsinh.clear();
                String sql_lop = "Select * from SinhVien";
                if (conn.getData_SinhVien(sql_lop) != null) {
                    arr_hocsinh = conn.getData_SinhVien(sql_lop);
                    loadTableSinhVien();
                    Xoatrang1();
                    cbmlsv.removeAllItems();
                    loadComboMaLop1();
                    cblopsv.removeAllItems();
                    loadComboTenLop();
                    JOptionPane.showMessageDialog(this, "Xóa thành công thông tin sinh viên !!!");
                }  
            }
        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnxoatrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatrangActionPerformed
        // TODO add your handling code here:
        Xoatrang1();
    }//GEN-LAST:event_btnxoatrangActionPerformed

    private void btntailaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntailaiActionPerformed
        // TODO add your handling code here:
        loadTableSinhVien();
    }//GEN-LAST:event_btntailaiActionPerformed

    private void btnsapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsapxepActionPerformed
        // TODO add your handling code here:
         Comparator<SinhVien> c = new Comparator<SinhVien>() {

              
             @Override
             public int compare(SinhVien o1, SinhVien o2) {
                 return o1.getTensv().compareToIgnoreCase(o2.getTensv());
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
            };
            Collections.sort(arr_hocsinh,c);
            loadTableSinhVien();
    }//GEN-LAST:event_btnsapxepActionPerformed

    private void tablesvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesvMouseClicked
        // TODO add your handling code here:
        dong = tablesv.getSelectedRow();
        SinhVien as = arr_hocsinh.get(dong);
          txtmsv.setText(as.getMsv());
          txttsv.setText(as.getTensv());
          txtstd.setText(as.getSdt());
          txtns.setText(as.getNgaysinh().toString());
          txtdt.setText(as.getDantoc());
          txtdc.setText(as.getDiachi());
          txtcmnd.setText(as.getCmnd());
          txtemail.setText(as.getEmail());
          cbmlsv.setSelectedItem(as.getMalop());
          cblopsv.setSelectedItem(as.getLop());
          dong = -1;
    }//GEN-LAST:event_tablesvMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ArrayList<SinhVien> sv = new ArrayList<>();
        if (rdtkmsv.isSelected()) {
            sv.clear();
            for (int i = 0; i < arr_hocsinh.size(); i++) {
                if (txtmsv.getText().equals(arr_hocsinh.get(i).getMsv())) {
                    sv.add(arr_hocsinh.get(i));
                }
            }
        } else if (rdtkml.isSelected()) {
            sv.clear();
            for (int i = 0; i < arr_hocsinh.size(); i++) {
                if (cbmlsv.getSelectedItem().toString().equals(arr_hocsinh.get(i).getMalop())) {
                    sv.add(arr_hocsinh.get(i));
                }
            }
        }

        tablesv.setModel(new CustomTableSinhVien(sv));
    }//GEN-LAST:event_jButton7ActionPerformed
public void Xoatrang2(){
    txtmsvkt.setText("");
    txtmkt.setText("");
    txttkt.setText("");
    txthtkt.setText("");
}
    private void btnthemktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemktActionPerformed
        // TODO add your handling code here:
          String msv = txtmsvkt.getText();
          String mkt = txtmkt.getText();
          String tkt =txttkt.getText();
          String ht =txthtkt.getText();
          
          
          
        String lop1 = "insert into KhenThuong values('" + msv + "','" + mkt + "','" + tkt + "','" + ht + "')";
            conn.doSQL(lop1);
        arr_khenthuong.clear();
        try {
        String sql = "Select * from KhenThuong";
        if (conn.getData_KhenThuong(sql) != null) {
            arr_khenthuong = conn.getData_KhenThuong(sql);
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
        
        loadTableKhenThuong();
        Xoatrang2();
        JOptionPane.showMessageDialog(this, "Thêm thành công thông tin khen thưởng !!!"); 
        
    }//GEN-LAST:event_btnthemktActionPerformed

    private void btnxoaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaktActionPerformed
        // TODO add your handling code here:
        int dlr = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không ???", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (dlr == JOptionPane.YES_OPTION) {
            dong = tablekt.getSelectedRow();
            
            if (dong != -1) {
                String msv = arr_khenthuong.get(dong).getMsv();
                String makt = arr_khenthuong.get(dong).getMakt();
                String sql = "delete from KhenThuong where msv = '" + msv + "' and makt = '"+makt+"'";
                conn.doSQL(sql);

                arr_khenthuong.clear();
                String sql_lop = "Select * from KhenThuong";
                if (conn.getData_KhenThuong(sql_lop) != null) {
                    arr_khenthuong = conn.getData_KhenThuong(sql_lop);
                    loadTableKhenThuong();
                    Xoatrang2();
                    JOptionPane.showMessageDialog(this, "Xóa thành công thông tin Khen thưởng !!!");
                }              
            }
        }
    }//GEN-LAST:event_btnxoaktActionPerformed

    private void btnsuaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaktActionPerformed
        // TODO add your handling code here:    
          String msv = txtmsvkt.getText();
          String mkt = txtmkt.getText();
          String tkt =txttkt.getText();
          String ht =txthtkt.getText();
          String lop1 = "update KhenThuong set makt = '" + mkt + "', tenkt = '" + tkt + "',hinhthuc='" + ht + "' "
                + "where msv = '" + msv + "'";
            conn.doSQL(lop1);
            arr_khenthuong.clear();
        String sql = "Select * from Khenthuong";
        if (conn.getData_KhenThuong(sql) != null) {
            arr_khenthuong = conn.getData_KhenThuong(sql);
        }
        loadTableKhenThuong();
        Xoatrang2();
        JOptionPane.showMessageDialog(this, "Sửa thành công thông tin Khen Thưởng !!!");
    }//GEN-LAST:event_btnsuaktActionPerformed

    private void btnxoatrangktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatrangktActionPerformed
        // TODO add your handling code here:
        Xoatrang2();
    }//GEN-LAST:event_btnxoatrangktActionPerformed

    private void btnsapxepktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsapxepktActionPerformed
        // TODO add your handling code here:
        Comparator<KhenThuong> c = new Comparator<KhenThuong>() {
            @Override
            public int compare(KhenThuong o1, KhenThuong o2) {
                return o1.getMakt().compareToIgnoreCase(o2.getMakt());
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            };
            Collections.sort(arr_khenthuong,c);
            loadTableKhenThuong();
    }//GEN-LAST:event_btnsapxepktActionPerformed

    private void btnthemlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemlActionPerformed
        // TODO add your handling code here:
          String nganh = txtnganh.getText();
          int ss = Integer.valueOf(txtss.getText());
          String malop = txtmll.getText();
          String tenlop = txttll.getText();
          String gvcn = cbgvcn.getSelectedItem().toString();
          String lop1 = "insert into Lop values('" + malop + "','" + tenlop + "'," + ss + ",'" + gvcn + "','" + nganh + "')";
          conn.doSQL(lop1);
        arr_Lop.clear();
        try {
        String sql = "Select * from Lop";
        if (conn.getData_Lop(sql) != null) {
            arr_Lop = conn.getData_Lop(sql);
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());

        }
        
        loadBangLop();
        Xoatrang3();
        
        cbgvcn.removeAllItems();
        loadComboGVCN();

        JOptionPane.showMessageDialog(this, "Thêm thành công thông tin Lớp !!!");
        
    }//GEN-LAST:event_btnthemlActionPerformed
public void Xoatrang3(){
    txtnganh.setText("");
    txtss.setText("");
    txttll.setText("");
    txtmll.setText("");
}

    private void btnsualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsualActionPerformed
        // TODO add your handling code here:
          String nganh = txtnganh.getText();
          int ss = Integer.valueOf(txtss.getText());
          String malop = txtmll.getText();
          String tenlop = txttll.getText();
          String gvcn = cbgvcn.getSelectedItem().toString();
          String lop1 = "update Lop set tenlop = '" + tenlop + "', siso = " + ss + ",giaovienchunhiem='" + gvcn + "',nganh='" + nganh + "' "
                + "where malop = '" + malop + "'";
            conn.doSQL(lop1);
            arr_Lop.clear();
        String sql = "Select * from Lop";
        if (conn.getData_Lop(sql) != null) {
            arr_Lop = conn.getData_Lop(sql);
        }

        loadBangLop();
        Xoatrang3();
        
        cbgvcn.removeAllItems();
        loadComboGVCN();

        JOptionPane.showMessageDialog(this, "Sửa thành công thông tin Lớp !!!");
        
    }//GEN-LAST:event_btnsualActionPerformed

    private void btnxoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoalActionPerformed
        // TODO add your handling code here:
        int dlr = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không ???", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (dlr == JOptionPane.YES_OPTION) {
            dong = tablelop.getSelectedRow();
            if (dong != -1) {
                String malop = arr_Lop.get(dong).getMalop();
                String sql = "delete from Lop where malop = '" + malop + "'";
                conn.doSQL(sql);

                arr_Lop.clear();
                String sql_lop = "Select * from Lop";
                if (conn.getData_Lop(sql_lop) != null) {
                    arr_Lop = conn.getData_Lop(sql_lop);
                }           
        loadBangLop();
        Xoatrang3();
        
        cbgvcn.removeAllItems();
        loadComboGVCN();
                JOptionPane.showMessageDialog(this, "Xóa thành công thông tin Lớp học !!!");
            }
        }
    }//GEN-LAST:event_btnxoalActionPerformed

    private void tablelopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelopMouseClicked
        // TODO add your handling code here:
        dong = tablelop.getSelectedRow();
        Lop as = arr_Lop.get(dong);
        txtnganh.setText(as.getNganh());
        txtss.setText(as.getSiso()+"");
        cbgvcn.setSelectedItem(as.getGvcn());
        txtmll.setText(as.getMalop());
        txttll.setText(as.getTenlop());
        dong = -1;
    }//GEN-LAST:event_tablelopMouseClicked

    private void tablektMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablektMouseClicked
        // TODO add your handling code here:
        dong = tablekt.getSelectedRow();
        KhenThuong as = arr_khenthuong.get(dong);
        txtmsvkt.setText(as.getMsv());
        txtmkt.setText(as.getMakt());
        txttkt.setText(as.getTenkt());
        txthtkt.setText(as.getHinhthuckt());
        dong = -1;
    }//GEN-LAST:event_tablektMouseClicked

    private void btnxoatranglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatranglActionPerformed
        // TODO add your handling code here:
        Xoatrang3();
    }//GEN-LAST:event_btnxoatranglActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ArrayList<Lop> sv = new ArrayList<>();
        if (rdtkmll.isSelected()) {
            sv.clear();
            for (int i = 0; i < arr_Lop.size(); i++) {
                if (txtmll.getText().equals(arr_Lop.get(i).getMalop())) {
                    sv.add(arr_Lop.get(i));
                }
            }
        } else if (rdtkgvcn.isSelected()) {
            sv.clear();
            for (int i = 0; i < arr_Lop.size(); i++) {
                if (cbgvcn.getSelectedItem().toString().equals(arr_Lop.get(i).getGvcn())) {
                    sv.add(arr_Lop.get(i));
                }
            }
        }
        tablelop.setModel(new CustonTableLop(sv));
    }//GEN-LAST:event_jButton8ActionPerformed

    // KY LUAT
    private void tableklMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableklMouseClicked
        dong = tablekl.getSelectedRow();
        KyLuat as = arr_kyluat.get(dong);
        txtmsvkl.setText(as.getMsv());
        txtmkl.setText(as.getMkl());
        txttkl.setText(as.getTenkyluat());
        txthtkl.setText(as.getHinhthuc());
        txtmdkl.setText(as.getMucdo());
        dong=-1;
    }//GEN-LAST:event_tableklMouseClicked

    private void xoaTrangKyLuat() {
        txtmsvkl.setText("");
        txtmkl.setText("");
        txttkl.setText("");
        txthtkl.setText("");
        txtmdkl.setText("");
    }
    
    private void btnxoatrangklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoatrangklActionPerformed
        // TODO add your handling code here:
        xoaTrangKyLuat();
    }//GEN-LAST:event_btnxoatrangklActionPerformed

    private void btnsapxepklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsapxepklActionPerformed
        // TODO add your handling code here:
         Comparator<KyLuat> c = new Comparator<KyLuat>() {
            @Override
            public int compare(KyLuat o1, KyLuat o2) {
                return o1.getMsv().compareTo(o2.getMsv());
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            };
            Collections.sort(arr_kyluat,c);
            loadTableKhenThuong();
    }//GEN-LAST:event_btnsapxepklActionPerformed

    private void btnxoaklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaklActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        int dlr = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không ???", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (dlr == JOptionPane.YES_OPTION) {
            dong = tablekl.getSelectedRow();
            if (dong != -1) {
                String makl = arr_kyluat.get(dong).getMkl();
                String msv = arr_kyluat.get(dong).getMsv();
                String sql = "delete from KyLuat where makl = '" + makl + "' and msv = '"+ msv +"' " ;
                conn.doSQL(sql);

                arr_kyluat.clear();
                String sql_lop = "Select * from KyLuat";
                if (conn.getData_KyLuat(sql_lop) != null) {
                    arr_kyluat = conn.getData_KyLuat(sql_lop);
                    loadTableKyLuat();
                    xoaTrangKyLuat();
                    JOptionPane.showMessageDialog(this, "Xóa thành công  !!!");
                }  
            }
        }
    }//GEN-LAST:event_btnxoaklActionPerformed

    private void btnthemklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemklActionPerformed
        // TODO add your handling code here:
        
        String msv = txtmsvkl.getText();
        String maKyLuat = txtmkl.getText();
        String tenKyLuat =txttkl.getText();
        String hinhThucKyLuat =  txthtkl.getText();
        String mucDoKyLuat =txtmdkl.getText();
          
        String insertKyLuat = "insert into KyLuat values('" + msv + "','" + maKyLuat + "','" + tenKyLuat + "','" + hinhThucKyLuat + "','" + mucDoKyLuat + "')";
            conn.doSQL(insertKyLuat);
        arr_kyluat.clear();
        try {
        String sql = "Select * from KyLuat";
        if (conn.getData_KyLuat(sql) != null) {
            arr_kyluat = conn.getData_KyLuat(sql);
            loadTableKyLuat();
            xoaTrangKyLuat();
            JOptionPane.showMessageDialog(this, "Thêm thành công !"); 
        }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnthemklActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsapxep;
    private javax.swing.JButton btnsapxepkl;
    private javax.swing.JButton btnsapxepkt;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnsuagd;
    private javax.swing.JButton btnsuakl;
    private javax.swing.JButton btnsuakt;
    private javax.swing.JButton btnsual;
    private javax.swing.JButton btntailai;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthemgd;
    private javax.swing.JButton btnthemkl;
    private javax.swing.JButton btnthemkt;
    private javax.swing.JButton btntheml;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton btnxoagd;
    private javax.swing.JButton btnxoakl;
    private javax.swing.JButton btnxoakt;
    private javax.swing.JButton btnxoal;
    private javax.swing.JButton btnxoatrang;
    private javax.swing.JButton btnxoatranggd;
    private javax.swing.JButton btnxoatrangkl;
    private javax.swing.JButton btnxoatrangkt;
    private javax.swing.JButton btnxoatrangl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbgvcn;
    private javax.swing.JComboBox cblopsv;
    private javax.swing.JComboBox cbmlsv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jlbTrangChinh;
    private javax.swing.JPanel jpnDoiMatKhau;
    private javax.swing.JPanel jpnGd;
    private javax.swing.JPanel jpnKhenThuong;
    private javax.swing.JPanel jpnKl;
    private javax.swing.JPanel jpnKt;
    private javax.swing.JPanel jpnKyLuat;
    private javax.swing.JPanel jpnL;
    private javax.swing.JPanel jpnLop;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnSinhVien;
    private javax.swing.JPanel jpnSv;
    private javax.swing.JPanel jpnTrangChinh;
    private javax.swing.JPanel jpnView;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JRadioButton rdtkgvcn;
    private javax.swing.JRadioButton rdtkml;
    private javax.swing.JRadioButton rdtkmll;
    private javax.swing.JRadioButton rdtkmsv;
    private javax.swing.JTable tablegd;
    private javax.swing.JTable tablekl;
    private javax.swing.JTable tablekt;
    private javax.swing.JTable tablelop;
    private javax.swing.JTable tablesv;
    private View.TrangChinhJPanel trangChinhJPanel1;
    private javax.swing.JTextField txtcmnd;
    private javax.swing.JTextField txtdantocace;
    private javax.swing.JTextField txtdantocbo;
    private javax.swing.JTextField txtdantocme;
    private javax.swing.JTextField txtdc;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtdiachiace;
    private javax.swing.JTextField txtdiachime;
    private javax.swing.JTextField txtdt;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthtkl;
    private javax.swing.JTextField txthtkt;
    private javax.swing.JTextField txtmdkl;
    private javax.swing.JTextField txtmkl;
    private javax.swing.JTextField txtmkt;
    private javax.swing.JTextField txtmll;
    private javax.swing.JTextField txtmsv;
    private javax.swing.JTextField txtmsvgd;
    private javax.swing.JTextField txtmsvkl;
    private javax.swing.JTextField txtmsvkt;
    private javax.swing.JTextField txtnganh;
    private javax.swing.JTextField txtnghenghiepace;
    private javax.swing.JTextField txtnghenghiepbo;
    private javax.swing.JTextField txtnghenghiepme;
    private javax.swing.JTextField txtns;
    private javax.swing.JTextField txtsdtace;
    private javax.swing.JTextField txtsdtbo;
    private javax.swing.JTextField txtsdtme;
    private javax.swing.JTextField txtss;
    private javax.swing.JTextField txtstd;
    private javax.swing.JTextField txttenace;
    private javax.swing.JTextField txttenbo;
    private javax.swing.JTextField txttenme;
    private javax.swing.JTextField txttkl;
    private javax.swing.JTextField txttkt;
    private javax.swing.JTextField txttll;
    private javax.swing.JTextField txttsv;
    private javax.swing.JTextField txttuoiace;
    private javax.swing.JTextField txttuoibo;
    private javax.swing.JTextField txttuoime;
    // End of variables declaration//GEN-END:variables
}
