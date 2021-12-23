package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.NguoiDungDAO;
import dao.impl.NguoidungImpl;
import entity.NguoiDung;

public class TestExcel {
	public static void main(String[] args) {
		try {
			XSSFWorkbook workbook= new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Người dùng");

            Row row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 2);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SÁCH HỌC VIÊN");

            row = spreadsheet.createRow((short) 3);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Họ và tên");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày sinh");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Giới tính");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Số điện thoại");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            NguoiDungDAO nguoidungDAO = new NguoidungImpl();

            List<NguoiDung> listItem = nguoidungDAO.layTatCaNguoidung();

            for (int i = 0; i < listItem.size(); i++) {
                NguoiDung nguoidung = listItem.get(i);
                row = spreadsheet.createRow((short) 4 + i);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(nguoidung.getTenNguoidung());
                row.createCell(2).setCellValue(nguoidung.getNamSinh());
                row.createCell(3).setCellValue(nguoidung.getGioiTinh());
                row.createCell(4).setCellValue(nguoidung.getSoDienthoai());
                row.createCell(5).setCellValue(nguoidung.getDiaChi());
            }

            FileOutputStream out = new FileOutputStream(new File("E:/IUH_University/HocKy_I(2021-2022)/LapTrinhPhanTanJava/Project/UngDungThiTracNghiem_Nhom2/ungdungkiemtra/excel/nguoidung.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
