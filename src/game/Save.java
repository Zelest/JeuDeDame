package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import game.Game;
//ne marche pas
public class Save {

	@SuppressWarnings("resource")
	public static void saveScore(String gagnant, String perdant) throws IOException {
		ArrayList<String> values = new ArrayList<String>();
		
		File file = new File("Score.xlsx");
		
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook wb;
		wb = new XSSFWorkbook("C:\\Users\\theom\\eclipse-workspace\\Java Project 1\\Score.xlsx");
		
		Sheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		for (int i = 0; i < rowCount+1; i++) {

			
			
	        Row row = sheet.getRow(i);
	        
	        
	        
	        
	        if (gagnant == row.getCell(1).getStringCellValue()) {
	        	int nbVictoire =Integer.parseInt(row.getCell(2).getStringCellValue());
	        	nbVictoire++;
	        	
	        }

	        if (perdant == row.getCell(1).getStringCellValue()) {
	        	int nbDefaite =Integer.parseInt(row.getCell(3).getStringCellValue());
	        	nbDefaite++;
	        	
	        }

	        System.out.println();
	    } 
	}

	
}
