/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Model.KhenThuong;
import Model.KyLuat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class KhenThuongCustomTable extends AbstractTableModel{
    private String names[] = {"MSV","Mã khen thưởng", "Thành tích", "Hình thức khen thưởng"};
    private Class classes[] = {String.class,String.class, String.class, String.class};
    
    ArrayList<KhenThuong> khenThuongList = new ArrayList<>();

    public KhenThuongCustomTable(ArrayList<KhenThuong> khenThuongList) {
        ArrayList<KhenThuong> mangRong = new ArrayList<>();
        this.khenThuongList = khenThuongList != null? khenThuongList:mangRong;
    }

    @Override
    public int getRowCount() {
        return khenThuongList.size();
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return khenThuongList.get(rowIndex).getMsv();
            case 1:
                return khenThuongList.get(rowIndex).getMakt();
            case 2:
                return khenThuongList.get(rowIndex).getTenkt();
            case 3:
                return khenThuongList.get(rowIndex).getHinhthuckt();
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
