package excel_operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {
	
	public static Object[][] data_read(String path,String sheet) throws IOException {
	File file_path = new File(path);
	//read mode
	FileInputStream open_file_read_mode = new FileInputStream(file_path);
	//creating a workbook
	XSSFWorkbook wb = new XSSFWorkbook(open_file_read_mode);
	XSSFSheet sheet_login = wb.getSheet(sheet);

	//collecting num rows

	int num_of_rows = sheet_login.getLastRowNum();
	int col_num = sheet_login.getRow(0).getLastCellNum();

	System.out.println("num_of_rows ::"+num_of_rows);
	System.out.println("Col Nums :: "+col_num);

//	 String[][] data_excel = new String[num_of_rows + 1][col_num];
//	 CellType[][] originalTypes = new CellType[num_of_rows + 1][col_num];
	
	 String[][] data_excel = new String[num_of_rows + 1][col_num];
	 CellType[][] originalTypes = new CellType[num_of_rows + 1][col_num];
	
//	for(int row = 1 ; row < num_of_rows-1 ; row ++) {
//		for(int col = 0 ; col < col_num ; col ++) {
//			XSSFCell cell = sheet_login.getRow(row).getCell(col);
	 
	 for (int row = 1; row <= num_of_rows; row++) {
		    for (int col = 0; col < col_num; col++) {
		        XSSFCell cell = sheet_login.getRow(row).getCell(col);

			CellType type = cell.getCellType();

			switch (type) {
            case STRING:
                data_excel[row][col] = cell.getStringCellValue();
                System.out.println(data_excel[row][col]);
                break;
            case NUMERIC:
                // Convert numeric value to string
                data_excel[row][col] = cell.getRawValue();
                System.out.println(data_excel[row][col]);
                System.out.println("Numeric");
                String convertedNumber = String.valueOf(data_excel[row][col]);
               System.out.println("convertedNumber  "+convertedNumber);

                break;
            case BOOLEAN:
                data_excel[row][col] = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                // Blank cell
                System.out.println("Blank cell");
                break;
            default:
                // Handle other cell types as needed
                System.out.println("Other cell type");
	}}}
	return  data_excel;
	}
}