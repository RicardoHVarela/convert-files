package convertFiles.convertFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileConverter {
	
	// input: FileName, sheetName,  title Row, output columns 
	public static void excel2Text(String file_name, String sheet_name) {
		
		ArrayList<String> internal_name = new ArrayList<String>();
		ArrayList<String> thai_value = new ArrayList<String>();
		
		try {
			
			FileInputStream excelFile = new FileInputStream( new File(file_name) );
			Workbook workbook = new XSSFWorkbook( excelFile );
			Sheet datatypeSheet = workbook.getSheet( sheet_name );
			Iterator<Row> iterator = datatypeSheet.iterator();

			//Jump to content rows
			iterator.next();
			iterator.next();
			
			while( iterator.hasNext() ) {
				
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				
				while( cellIterator.hasNext() ) {
					
					Cell currentCell = cellIterator.next();
					//Internal Name column
					if ( currentCell.getColumnIndex() == 1) {
						internal_name.add( currentCell.getStringCellValue() );	
					}
					//Thai column
					else if (currentCell.getColumnIndex() == 3) {
						thai_value.add( currentCell.getStringCellValue() );
					}
				}
				
			}
			
		}
		catch( FileNotFoundException fnfException ) {
			fnfException.printStackTrace();
		}
		catch( IOException ioException ) {
			System.out.println( "Error" );
			System.out.println( ioException.getStackTrace() );
			
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		//Print to console the array lists
		for( int i = 0; i < internal_name.size(); i++ ) {
			System.out.println( internal_name.get(i) + "=" + thai_value.get(i));
		}
		
	}

}
