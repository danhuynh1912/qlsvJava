package Utility;

import Model.SinhVien;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class CustomTableSinhVien extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã sinh viên","Tên sinh viên","Giới tính","Ngày sinh","Điện thoại","Lớp","Địa Chỉ","Dân Tộc","CMND","Email","Mã Lớp"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,Date.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<SinhVien> dsThiSinh=new ArrayList<SinhVien>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTableSinhVien(ArrayList<SinhVien> list)
   {
       this.dsThiSinh=list;
   }
    
    @Override
    public int getRowCount()
    {
        return dsThiSinh.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            
            case 0: return dsThiSinh.get(rowIndex).getMsv();
            
            case 1: return dsThiSinh.get(rowIndex).getTensv();
            
            case 2: return dsThiSinh.get(rowIndex).getGioitinh();
            
            case 3: return dsThiSinh.get(rowIndex).getNgaysinh();
            
            case 4: return dsThiSinh.get(rowIndex).getSdt();
            
            case 5: return dsThiSinh.get(rowIndex).getLop();
                
            case 6: return dsThiSinh.get(rowIndex).getDiachi();
                
            case 7: return dsThiSinh.get(rowIndex).getDantoc();
                
            case 8: return dsThiSinh.get(rowIndex).getCmnd();
                
            case 9: return dsThiSinh.get(rowIndex).getEmail(); 
            
            case 10: return dsThiSinh.get(rowIndex).getMalop();
            default :return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
