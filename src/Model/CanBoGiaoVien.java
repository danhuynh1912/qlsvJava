package Model;

import java.util.Objects;

public class CanBoGiaoVien {
    private String magv;
    private String hoTen;
    private String taikhoan;
    private String matkhau;

    public CanBoGiaoVien() {
    }

    public CanBoGiaoVien(String taikhoan, String matkhau) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }


    public CanBoGiaoVien(String magv, String hoTen, String taikhoan, String matkhau) {
        this.magv = magv;
        this.hoTen = hoTen;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CanBoGiaoVien other = (CanBoGiaoVien) obj;
        if (!Objects.equals(this.taikhoan, other.taikhoan)) {
            return false;
        }
        if (!Objects.equals(this.matkhau, other.matkhau)) {
            return false;
        }
        return true;
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
