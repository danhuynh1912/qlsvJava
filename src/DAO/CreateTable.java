/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author QuyetChien
 */
public class CreateTable {

    ConnectDB conn = new ConnectDB();

    public void Create_TableLop() {
        String sql = "Create table Lop(malop varchar(50) primary key,tenlop varchar(50), "
                + "siso integer, giaovienchunhiem varchar(50),nganh varchar(50))";
        conn.doSQL(sql);
    }

    public void Create_TableSinhVien() {
        String sql = "Create table SINHVIEN(msv varchar(50) primary key,Hoten varchar(50),ngaysinh date, "
                + " gioitinh varchar(50), diachi varchar(50),SDT varchar(50),email varchar(50),dantoc varchar(50), CMND varchar(50),lop varchar(50),malop varchar(50))";
        conn.doSQL(sql);
    }

    public void Create_TableKhenThuong() {
        String sql = "Create table KhenThuong(msv varchar(50),makt varchar(50) ,"
                + " tenkt varchar(50), hinhthuc varchar(50))";
        conn.doSQL(sql);
    }

    public void Create_TableKyLuat() {
        String sql = "Create table KyLuat(msv varchar(50),makl varchar(50) ,"
                + " tenkl varchar(50), hinhthuc varchar(50),mucdo varchar(50))";
        conn.doSQL(sql);
    }

    public void Create_TableGiaDinh() {
        String sql = "Create table GiaDinh(msv varchar(50),tenbo varchar(50),tuoibo varchar(50), nghebo varchar(50),diachibo varchar(50) ,sobo varchar(50),dantocbo varchar(50) , tenme varchar(50),tuoime varchar(50), ngheme varchar(50),diachime varchar(50) ,sodtme varchar(50),dantocme varchar(50) ,tenace varchar(50),tuoiace varchar(50), ngheace varchar(50),diachiace varchar(50) ,soace varchar(50),dantocace varchar(50))";
        conn.doSQL(sql);
    }

    public void Create_TableGIAOVIEN(){
        String sql = "Create table GIAOVIEN(magv varchar(50) primary key,hoten varchar(50),"
                + "taikhoan varchar(50), matkhau varchar(50))";
        conn.doSQL(sql);
    }

    
}
