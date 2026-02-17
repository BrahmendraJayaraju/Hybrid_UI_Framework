package getdata;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceldataFramework {

	public static String getdata(String pathname, String Sheetname, int rn, int cn) throws Exception {
		{

			try {

				// create and read file
				File f = new File("./Data/input.xlsx");
				FileInputStream f1 = new FileInputStream(f);

				// create workbook
				XSSFWorkbook wb = new XSSFWorkbook(f1);

				// get sheet
				XSSFSheet sh = wb.getSheet(Sheetname);

				// get row

				XSSFRow r = sh.getRow(rn);

				// get cell

				XSSFCell c = r.getCell(cn);

				// get the data

				String data = c.getStringCellValue().toString();

				return data;
			}

			catch (Exception e) {
				return " ";
			}

		}

	}

	public static int getrowcount(String pathname, String Sheetname) throws Exception {
		{

			try {

				// create and read file
				File f = new File("./Data/input.xlsx");
				FileInputStream f1 = new FileInputStream(f);

				// create workbook
				XSSFWorkbook wb = new XSSFWorkbook(f1);

				// get sheet
				XSSFSheet sh = wb.getSheet(Sheetname);

				// get row

				int rncount = sh.getLastRowNum();

				return rncount;

			}

			catch (Exception e) {
				return 0;
			}

		}
	}

	public static int getcellcount(String pathname, String Sheetname, int rn) throws Exception {
		{

			try {

				// create and read file
				File f = new File("./Data/input.xlsx");
				FileInputStream f1 = new FileInputStream(f);

				// create workbook
				XSSFWorkbook wb = new XSSFWorkbook(f1);

				// get sheet
				XSSFSheet sh = wb.getSheet(Sheetname);

				// get row
				XSSFRow r = sh.getRow(0);

				int cncount = r.getLastCellNum();

				return cncount;
			}

			catch (Exception e) {
				return 0;
			}

		}

	}

}
