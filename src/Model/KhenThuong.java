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
public class KhenThuong {
    private String msv,  makt, tenkt, hinhthuckt;

    public KhenThuong() {
    }

    public KhenThuong(String msv, String makt, String tenkt, String hinhthuckt) {
        this.msv = msv;
        this.makt = makt;
        this.tenkt = tenkt;
        this.hinhthuckt = hinhthuckt;
    }

    public KhenThuong(String makt, String tenkt, String hinhthuckt) {
        this.makt = makt;
        this.tenkt = tenkt;
        this.hinhthuckt = hinhthuckt;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

 

    public String getMakt() {
        return makt;
    }

    public String getTenkt() {
        return tenkt;
    }

    public String getHinhthuckt() {
        return hinhthuckt;
    }

    public void setMakt(String makt) {
        this.makt = makt;
    }

    public void setTenkt(String tenkt) {
        this.tenkt = tenkt;
    }

    public void setHinhthuckt(String hinhthuckt) {
        this.hinhthuckt = hinhthuckt;
    }
    
}
