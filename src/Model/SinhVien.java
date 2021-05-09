package Model;

import java.util.ArrayList;
import java.util.Date;

public class SinhVien{
    private String msv,tensv,sdt,diachi,dantoc,lop,cmnd,email,gioitinh;
    private String malop;
    private Date ngaysinh;

    public SinhVien(String msv, String tensv, Date ngaysinh, String gioitinh, String diachi, String sdt, String email, String dantoc, String cmnd, String lop, String malop) {
        this.msv = msv;
        this.tensv = tensv;
        this.sdt = sdt;
        this.diachi = diachi;
        this.dantoc = dantoc;
        this.lop = lop;
        this.cmnd = cmnd;
        this.email = email;
        this.gioitinh = gioitinh;
        this.malop = malop;
        this.ngaysinh = ngaysinh;
    }

    public SinhVien() {
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setDantoc(String dantoc) {
        this.dantoc = dantoc;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getMsv() {
        return msv;
    }

    public String getTensv() {
        return tensv;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getDantoc() {
        return dantoc;
    }

    public String getLop() {
        return lop;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getEmail() {
        return email;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getMalop() {
        return malop;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }


}
