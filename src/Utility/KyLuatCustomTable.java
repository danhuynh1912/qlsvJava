package Utility;

import Model.KyLuat;
import Model.SinhVien;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class KyLuatCustomTable extends AbstractTableModel{
    private String names[] = {"MSV","Mã kỷ luật" ,"Tên Vi Phạm","Hình Thức", "Mức độ"};
    private Class classes[] = {String.class,String.class, String.class, String.class, String.class};
    
    ArrayList<KyLuat> kyLuatList = new ArrayList<>();

    public KyLuatCustomTable(ArrayList<KyLuat> kyLuatList) {
        ArrayList<KyLuat> mangRong = new ArrayList<>();
        this.kyLuatList = kyLuatList != null? kyLuatList:mangRong;
    }

    @Override
    public int getRowCount() {
        return kyLuatList.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return kyLuatList.get(rowIndex).getMsv();
            case 1:
                return kyLuatList.get(rowIndex).getMkl();
            case 2:
                return kyLuatList.get(rowIndex).getTenkyluat();
            case 3:
                return kyLuatList.get(rowIndex).getHinhthuc();
            case 4:
                return kyLuatList.get(rowIndex).getMucdo();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return names[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
