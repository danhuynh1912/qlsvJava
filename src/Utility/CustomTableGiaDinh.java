package Utility;

import Model.GiaDinh;
import Model.SinhVien;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class CustomTableGiaDinh extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã sinh viên","Tên Bố","Tuổi Bố","Số Điện Thoại Bố","Địa Chỉ Bố","Tên Mẹ","Tuổi Mẹ","Số Điện Thoại Mẹ","Địa Chỉ Mẹ","Tên Ace","Tuổi Ace","Số Điện Thoại Ace","Địa Chỉ Ace"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<GiaDinh> dsThiSinh=new ArrayList<GiaDinh>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTableGiaDinh(ArrayList<GiaDinh> list)
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
            
            case 1: return dsThiSinh.get(rowIndex).getTenBo();
            
            case 2: return dsThiSinh.get(rowIndex).getTuoiBo();
            
            case 3: return dsThiSinh.get(rowIndex).getSoBo();
            
            case 4: return dsThiSinh.get(rowIndex).getDiachiBo();
            
            case 5: return dsThiSinh.get(rowIndex).getTenme();
                
            case 6: return dsThiSinh.get(rowIndex).getTuoiMe();
                
            case 7: return dsThiSinh.get(rowIndex).getSoMe();
                
            case 8: return dsThiSinh.get(rowIndex).getDiachiMe();
            
            case 9: return dsThiSinh.get(rowIndex).getTenAce();
            
            case 10: return dsThiSinh.get(rowIndex).getTuoiAce();
                
            case 11: return dsThiSinh.get(rowIndex).getSoAce();
                
            case 12: return dsThiSinh.get(rowIndex).getDiachiAce();
            
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
