package DAO;

public class AddData {

    CreateTable table = new CreateTable();
    ConnectDB conn = new ConnectDB();

    public void add_Class() {
        table.Create_TableLop();
        String lop1 = "insert into Lop values('T01','CNTT1',70,'Lê Thị Thanh Đào','Công Nghệ Thông Tin')";
        String lop2 = "insert into Lop values('T02','HTTT1',70,'Hoàng Quyết Chiến','Công Nghệ Thông Tin')";
        String lop3 = "insert into Lop values('T03','KTLT1',70,'Trần Chiến Công','Kiến Trúc Máy Tính')";
        String lop4 = "insert into Lop values('T04','CNTT2',70,'Huỳnh Ngọc Trường Danh','Hệ Thống Thông Tin')";
        String lop5 = "insert into Lop values('T05','CNTT3',70,'Lê Thị Thanh Đào','Công Nghệ Thông Tin')";
        String lop6 = "insert into Lop values('T06','CNTT4',70,'Lê Thị Thanh Đào','Công Nghệ Thông Tin')";
        String lop7 = "insert into Lop values('T07','CNTT5',70,'Lê Thị Thanh Đào','Công Nghệ Thông Tin')";

        conn.doSQL(lop1);
        conn.doSQL(lop2);
        conn.doSQL(lop3);
        conn.doSQL(lop4);
        conn.doSQL(lop5);
        conn.doSQL(lop6);
        conn.doSQL(lop7);
        
    }

    public void add_GiaoVien() {
        table.Create_TableGIAOVIEN();
        String cbgv1 = "insert into GIAOVIEN values('sv01','Hoàng Quyết Chiến','QuyetChien@gmail.com','123456')";
        String cbgv2 = "insert into GIAOVIEN values('sv02','Lê Thị Thanh Đào','ThanhDao@gmail.com','123456')";
        String cbgv3 = "insert into GIAOVIEN values('sv03','Trần Chiến Công','ChienCong@gmail.com','123456')";
        String cbgv4 = "insert into GIAOVIEN values('sv04','Huỳnh Ngọc Trường Danh','TruongDanh@gmail.com','123456')";
        
        conn.doSQL(cbgv1);
        conn.doSQL(cbgv2);
        conn.doSQL(cbgv3);
        conn.doSQL(cbgv4);

    }

    public void add_SinhVien() {
        table.Create_TableSinhVien();

        String hs1 = "insert into SINHVIEN values('sv01','Hoàng Quyết Chiến','2000-02-02','Nam','Hà Nội','0358725873','Chien@gmail.com','Kinh','001234423','CNTT1','T01')";
        String hs2 = "insert into SINHVIEN values('sv02','Lê Thị Thanh Đào','2000-02-02','Nữ','Hưng Yên','0358725873','Dao@gmail.com','Kinh','23478234','CNTT1','T01')";
        String hs3 = "insert into SINHVIEN values('sv03','Trần Chiến Công','2000-02-02','Nam','Hà Nội','0358725873','Cong@gmail.com','Kinh','235334523','CNTT1','T01')";
        String hs4 = "insert into SINHVIEN values('sv04','Huỳnh Ngọc Trường Danh','2000-02-02','Nam','Hưng Yên','0358725873','Danh@gmail.com','Kinh','345223423','CNTT1','T01')";
        


        conn.doSQL(hs1);
        conn.doSQL(hs2);
        conn.doSQL(hs3);
        conn.doSQL(hs4);

    }

    public void add_KhenThuong() {
        table.Create_TableKhenThuong();
        String kt = "insert into KhenThuong values('sv01','kt01','HSG','500.000')";
        String kt2 = "insert into KhenThuong values('sv02','kt02','HSG','600.000')";
        conn.doSQL(kt);
        conn.doSQL(kt2);
    }

    public void add_KyLuat() {
        table.Create_TableKyLuat();
        String kl = "insert into KyLuat values('01','kl01','Đi Muộn','Phạt Tiền','100.000')";
        String k2 = "insert into KyLuat values('02','kl02','Đi Muộn','Phạt Tiền','200.000')";
        
        conn.doSQL(k2);
        conn.doSQL(kl);
    }

    public void add_GiaDinh() {
        table.Create_TableGiaDinh();
        String td = "insert into GiaDinh values('01','Hoàng Văn Đoàn','33','Nông Dân','Hà Nội','0358725873','Kinh','Dư Thanh Tâm','33','Nông Dân','Hà Nội','0358725873','Kinh','Hoàng Phương Ngân','18','Học Sinh','Hà Nội','0358725873','Kinh')";
        String td1 = "insert into GiaDinh values('02','Lê Văn Đoàn','33','Nông Dân','Hà Nội','0358725873','Kinh','Lê Văn Hoa','33','Nông Dân','Hà Nội','0358725873','Kinh','','','','','','')";
        String td2 = "insert into GiaDinh values('03','Trần Văn Đoàn','33','Nông Dân','Hà Nội','0358725873','Kinh','Lê Văn Hoa','33','Nông Dân','Hà Nội','0358725873','Kinh','Trần Phương Ngân','18','Học Sinh','Hà Nội','0358725873','Kinh')";
        String td3 = "insert into GiaDinh values('04','Huỳnh Văn Đoàn','33','Nông Dân','Hà Nội','0358725873','Kinh','Dư Thanh Tâm','33','Nông Dân','Hà Nội','0358725873','Kinh','Huỳnh Phương Ngân','18','Học Sinh','Hà Nội','0358725873','Kinh')";
        conn.doSQL(td);
        conn.doSQL(td1);
        conn.doSQL(td2);
        conn.doSQL(td3);
    }


}
