/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class KyLuat {
    private String mkl, tenkyluat, hinhthuc,mucdo;
    private String msv;

 

    public KyLuat( String msv,String mkl, String tenkyluat, String hinhthuc, String mucdo) {
        this.mkl = mkl;
        this.tenkyluat = tenkyluat;
        this.hinhthuc = hinhthuc;
        this.mucdo = mucdo;
        this.msv = msv;
    }

    public KyLuat() {
    }

    public String getMkl() {
        return mkl;
    }

    public String getTenkyluat() {
        return tenkyluat;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public String getMucdo() {
        return mucdo;
    }

    public String getMsv() {
        return msv;
    }

    public void setMkl(String mkl) {
        this.mkl = mkl;
    }

    public void setTenkyluat(String tenkyluat) {
        this.tenkyluat = tenkyluat;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public void setMucdo(String mucdo) {
        this.mucdo = mucdo;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

}
