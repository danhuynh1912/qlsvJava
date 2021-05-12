package Exel;

import Model.SinhVien;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExel {
    public static final int COLUMN_INDEX_STT       = 0;
    public static final int COLUMN_INDEX_MSV       = 1;
    public static final int COLUMN_INDEX_HOTEN     = 2;
    public static final int COLUMN_INDEX_GIOITINH  = 3;
    public static final int COLUMN_INDEX_NGAYSINH  = 4;
    public static final int COLUMN_INDEX_DIENTHOAI = 5;
    public static final int COLUMN_INDEX_LOP       = 6;
    public static final int COLUMN_INDEX_DIACHI    = 7;
    public static final int COLUMN_INDEX_DANTOC    = 6;
    public static final int COLUMN_INDEX_CMND      = 8;
    public static final int COLUMN_INDEX_EMAIL     = 9;
    public static final int COLUMN_INDEX_MALOP     = 10;
    // Tao Workbook
    static Workbook workbook = new XSSFWorkbook();
    
    // Tao sheet
    static Sheet sheet = workbook.createSheet("Danh sách khách hàng");
     
    
    public static void taoExcel(List<SinhVien> ds, String excelFile) throws IOException {
        int rowIndex = 0;
       
        // Viet tieu de
        vietTieuDe(sheet, rowIndex);
 
        // Ghi du lieu sinh vien
        rowIndex++;
        for (SinhVien kh : ds) {
            // Tạo row
            Row row = sheet.createRow(rowIndex);
            // Viết dữ liệu trên row này
            ghiDL(kh, row);
            rowIndex++;
        }
        
        // Tự động điều chỉnh độ rộng cột
        int soLuongCot = sheet.getRow(0).getPhysicalNumberOfCells();
        autoFix(sheet, soLuongCot);
 
        
        //Tạo file
        taoFile(workbook, excelFile);
    }

    private static void vietTieuDe(Sheet sheet, int rowIndex) {
        // Tao row
        Row row = sheet.createRow(rowIndex);
        
        // Tao cell    
        Cell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue("STT");
        
        cell = row.createCell(COLUMN_INDEX_MSV);
        cell.setCellValue("Mã sinh viên");
        
        cell = row.createCell(COLUMN_INDEX_HOTEN);
        cell.setCellValue("Họ tên");
 
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellValue("Giới tính");
 
        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellValue("Ngày sinh");
 
        cell = row.createCell(COLUMN_INDEX_DIENTHOAI);
        cell.setCellValue("Điện thoại");
        
        cell = row.createCell(COLUMN_INDEX_LOP);
        cell.setCellValue("LỚP");
        
        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellValue("Địa chỉ");
        
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellValue("Dân tộc");
        
        cell = row.createCell(COLUMN_INDEX_CMND);
        cell.setCellValue("CMND");
        
        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue("Email");
        
        cell = row.createCell(COLUMN_INDEX_MALOP);
        cell.setCellValue("Mã lớp");
    }

    public static void ghiDL(SinhVien sv, Row row) {
        Cell cell = row.createCell(COLUMN_INDEX_STT);
        cell.setCellValue(row.getRowNum());
        
        cell = row.createCell(COLUMN_INDEX_MSV);
        cell.setCellValue(sv.getMsv());
        
        cell = row.createCell(COLUMN_INDEX_HOTEN);
        cell.setCellValue(sv.getTensv());
 
        cell = row.createCell(COLUMN_INDEX_GIOITINH);
        cell.setCellValue(sv.getGioitinh());
 
        cell = row.createCell(COLUMN_INDEX_NGAYSINH);
        cell.setCellValue(sv.getNgaysinh());
 
        cell = row.createCell(COLUMN_INDEX_DIENTHOAI);
        cell.setCellValue(sv.getSdt());
        
        cell = row.createCell(COLUMN_INDEX_LOP);
        cell.setCellValue(sv.getLop());
        
        cell = row.createCell(COLUMN_INDEX_DIACHI);
        cell.setCellValue(sv.getDiachi());
        
        cell = row.createCell(COLUMN_INDEX_DANTOC);
        cell.setCellValue(sv.getDantoc());
        
        cell = row.createCell(COLUMN_INDEX_CMND);
        cell.setCellValue(sv.getCmnd());
        
        cell = row.createCell(COLUMN_INDEX_EMAIL);
        cell.setCellValue(sv.getEmail());
        
        cell = row.createCell(COLUMN_INDEX_MALOP);
        cell.setCellValue(sv.getMalop());
    }

    private static void taoFile(Workbook workbook, String excelFile) throws FileNotFoundException, IOException {
         OutputStream fileOut = new FileOutputStream(excelFile);
         workbook.write(fileOut);
    }

    private static void autoFix(Sheet sheet, int soLuongCot) {
        for (int i = 0; i < soLuongCot; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}
