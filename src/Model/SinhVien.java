package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

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

    public SinhVien(String msv) {
        this.msv = msv;
    }

    public SinhVien() {
    }

    public void setMsv(String msv) throws Exception {
        if(msv.trim().equals("")) {
            throw new Exception("Mã sinh viên không được để trống!!!");
        } 
        this.msv = msv;
    }

    public void setTensv(String tensv) throws Exception {
        if(tensv.trim().equals("")) {
            throw new Exception("Tên sinh viên không được để trống!!!");
        } 
        this.tensv = tensv;
    }
    
    public boolean isNumber(String string) {
        try {
            Long intValue = Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Không phải là số");
        }
        return false;
    }

    public void setSdt(String sdt) throws Exception {
        if(sdt.trim().equals("")) {
            throw new Exception("Số điện thoại không được để trống!!!");
        } 
        if(!isNumber(sdt)){
            throw new Exception("Số điện thoại chỉ bao gồm số!!");
        }
        if(sdt.trim().length()<10) {
            throw new Exception("Số điện thoại phải >= 10 chữ số!!");
        }
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) throws Exception {
        if(diachi.trim().equals("")) {
            throw new Exception("Địa chỉ không được để trống!!!");
        } 
        this.diachi = diachi;
    }

    public void setDantoc(String dantoc) throws Exception {
        if(dantoc.trim().equals("")) {
            throw new Exception("Dân tộc không được để trống!!!");
        } 
        this.dantoc = dantoc;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setCmnd(String cmnd) throws Exception {
        if(cmnd.trim().equals("")) {
            throw new Exception("CMND không được để trống!!!");
        } 
        this.cmnd = cmnd;
    }

    public boolean isEmail(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
    }
    
    public void setEmail(String email) throws Exception {
        if(email.trim().equals("")) {
            throw new Exception("Email không được để trống!!!");
        } 
        if(!isEmail(email)) {
            throw new Exception("Email phải có dạng: abc@def.xyz");
        }
        this.email = email;
    }

    public void setGioitinh(String gioitinh) throws Exception {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.msv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SinhVien other = (SinhVien) obj;
        if (!Objects.equals(this.msv, other.msv)) {
            return false;
        }
        return true;
    }


}
