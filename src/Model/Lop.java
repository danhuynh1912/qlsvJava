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
public class Lop {
    private String malop, tenlop,gvcn,nganh;
    private int siso;

    public Lop(String malop, String tenlop, int siso,String gvcn,String Nganh) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.gvcn = gvcn;
        this.siso = siso;
        this.nganh= Nganh;
    }

    public Lop(String malop) {
        this.malop = malop;
    }

    public Lop() {
    }

    public String getMalop() {
        return malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public String getGvcn() {
        return gvcn;
    }

    public int getSiso() {
        return siso;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public void setGvcn(String gvcn) {
        this.gvcn = gvcn;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    
}
