package Utility;

import Model.Lop;
import Model.SinhVien;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class CustonTableLop extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Lớp","Tên Lớp","Giáo Viên Chủ Nhiệm","Sĩ Số","Ngành"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<Lop> dsThiSinh=new ArrayList<Lop>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustonTableLop(ArrayList<Lop> list)
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
            
            case 0: return dsThiSinh.get(rowIndex).getMalop();
            
            case 1: return dsThiSinh.get(rowIndex).getTenlop();
            
            case 2: return dsThiSinh.get(rowIndex).getGvcn();
            
            case 3: return dsThiSinh.get(rowIndex).getSiso();
            
            case 4: return dsThiSinh.get(rowIndex).getNganh();

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
