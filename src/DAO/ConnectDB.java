package DAO;

import Model.CanBoGiaoVien;
import Model.GiaDinh;
import Model.KhenThuong;
import Model.KyLuat;
import Model.Lop;
import Model.SinhVien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectDB {

    Statement stm = null;
    ResultSet rs = null;
    Connection cnn = null;

    String uRl = "jdbc:derby://localhost:1527/QLSV";
    String userName = "QUANLISINHVIEN";
    String pas = "123456";

    public ConnectDB() {
        try {
            //org.apache.derby.jdbc.ClientDriver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            cnn = DriverManager.getConnection(uRl, userName, pas);
            System.out.println("ket noi thanh cong");
        } catch (Exception ex) {
            System.out.println("ket noi that bai" + ex.toString());
        }
    }

    protected Statement getStatement() throws Exception {
        if (this.stm == null || this.stm.isClosed()) {
            this.stm = this.cnn.createStatement();
        }
        return this.stm;
    }

    public void updateData(String sql) throws Exception {
        try {
            getStatement().executeUpdate(sql);
        } catch (Exception e) {

        }
    }

    public ResultSet executeSql(String sql) {
        try {
            stm = cnn.createStatement();
            rs = stm.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println(" khong thuc hien dc cau lẹnh sql\n" + sql);
            return rs;
        }

    }

    public void doSQL(String sql) {
        try {
            stm = cnn.createStatement();
            stm.execute(sql);
            System.out.println("Thực thi thành công");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(" khong thuc hien dc cau lẹnh sql\n" + sql);
        }

    }

    public ArrayList getData_Lop(String sql) {
        ArrayList<Lop> l = new ArrayList<Lop>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Lop sv = new Lop(rs.getString(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5));
                l.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return l;
    }

    public ArrayList getData_CBGV(String sql) {
        ArrayList<CanBoGiaoVien> ds = new ArrayList<CanBoGiaoVien>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                CanBoGiaoVien sv = new CanBoGiaoVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                ds.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return ds;
    }

    public ArrayList getData_SinhVien(String sql) {
        ArrayList<SinhVien> svi = new ArrayList<SinhVien>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getString(11));
                svi.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return svi;
    }




    public ArrayList getData_KhenThuong(String sql) {
        ArrayList<KhenThuong> kt = new ArrayList<>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                KhenThuong sv = new KhenThuong(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
                kt.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return kt;
    }

    public ArrayList getData_KyLuat(String sql) {
        ArrayList<KyLuat> kl = new ArrayList<>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                KyLuat sv = new KyLuat(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5));
                kl.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return kl;
    }

    public ArrayList getData_GiaDinh(String sql) {
        ArrayList<GiaDinh> gd = new ArrayList<>();
        try {
            stm = (Statement) cnn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                GiaDinh sv = new GiaDinh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),rs.getString(14), rs.getString(15),rs.getString(16),rs.getString(17), rs.getString(18),rs.getString(19));
                gd.add(sv);
            }
        } catch (Exception ex) {
            System.out.println("loi getData " + ex.toString());
            return null;
        }
        return gd;
    }
 

}
