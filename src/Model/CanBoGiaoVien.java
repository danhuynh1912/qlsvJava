/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quang Vinh
 */
public class CanBoGiaoVien {
    private String magv;
    private String hoTen;
    private String taikhoan;
    private String matkhau;

    public CanBoGiaoVien() {
    }

    public CanBoGiaoVien(String magv, String hoTen, String taikhoan, String matkhau) {
        this.magv = magv;
        this.hoTen = hoTen;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        
    }

    
    
    
    public String getMagv() {
        return magv;
    }

    public void setMagv(String magv) {
        this.magv = magv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }


    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    
    
}
