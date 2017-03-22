package baseClass;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Excel {
	String xlsName;
	String sheetName;
	private int rows;
	private int columns;
	String [][] sheetContent;
	public Excel(){
		this.xlsName = null;
		this.sheetName = null;
		this.rows = 0;
		this.columns = 0;
		this.sheetContent = null;
	}
	public Excel(String xlsName, String sheetName, int rows, int columns, String[][] sheetContent) {
		super();
		this.xlsName = xlsName;
		this.sheetName = sheetName;
		this.rows = rows;
		this.columns = columns;
		this.sheetContent = sheetContent;
	}
	public String getXlsName() {
		return xlsName;
	}
	public void setXlsName(String xlsName) {
		this.xlsName = xlsName;
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public String[][] getSheetContent() {
		return sheetContent;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String [][] readExcel(String xlsName) throws BiffException, IOException{
		Workbook workbook=Workbook.getWorkbook(new File(xlsName));
		Sheet sheet = workbook.getSheet(0);
		rows = sheet.getRows();
		columns = sheet.getColumns();
		System.out.println("rows:"+rows+" columns:"+columns);
		sheetContent = new String[columns][rows];
		for(int i = 0;i < columns;i++){
			for(int j=0;j<rows;j++){
				sheetContent[i][j] = sheet.getCell(i,j).getContents();
			}
		}
		workbook.close();
		return sheetContent;
	}
	public String [][] readExcel() throws BiffException, IOException{
		Workbook workbook=Workbook.getWorkbook(new File(xlsName));
		Sheet sheet = workbook.getSheet(0);
		rows = sheet.getRows();
		columns = sheet.getColumns();
		System.out.println("rows:"+rows+" columns:"+columns);
		sheetContent = new String[rows][columns];
		for(int i = 0;i < rows;i++){
			for(int j=0;j<columns;j++){
				sheetContent[i][j] = sheet.getCell(j,i).getContents();
			}
		}
		workbook.close();
		return sheetContent;
	}
	public void printExcel(){
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				System.out.print(sheetContent[i][j]+" ");
				if(j==columns-1){
					System.out.print("\n");
				}
			}
		}
	}
	public void writeExcel(int c,int r,String content){
		try {
			Workbook workbook=Workbook.getWorkbook(new File(xlsName));
			WritableWorkbook ww = Workbook.createWorkbook(new File(xlsName+"-updated.xls"), workbook);
			WritableSheet ws = ww.getSheet(0);
			if(ws == null){
				ws = ww.createSheet(sheetName, 0);
			}
			try {
				if(content.equals("Pass")){
					jxl.write.WritableCellFormat wc = new jxl.write.WritableCellFormat();
					wc.setBackground(jxl.format.Colour.GREEN);
					ws.addCell(new jxl.write.Label(c,r,content,wc));
				}else if(content.equals("Fail")){
					jxl.write.WritableCellFormat wc = new jxl.write.WritableCellFormat();
					wc.setBackground(jxl.format.Colour.RED);
					ws.addCell(new jxl.write.Label(c,r,content,wc));
				}else{
				ws.addCell(new jxl.write.Label(c,r,content));
				}
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			workbook.close();
			ww.write();
			ww.close();
			
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void writeExcel(String [][] sheetContent){
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File(xlsName));
			WritableWorkbook ww = Workbook.createWorkbook(new File(xlsName+"-updated.xls"), workbook);
			WritableSheet ws = ww.getSheet(0);
			if(ws == null){
				ws = ww.createSheet(sheetName, 0);
			}
			int row = sheetContent.length;
			int col = sheetContent[0].length;
			System.out.print("row:"+row+" col:"+col+"\n");
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					String content = sheetContent[i][j];
					if(content.equals("Pass")){
						jxl.write.WritableCellFormat wc = new jxl.write.WritableCellFormat();
						wc.setBackground(jxl.format.Colour.GREEN);
						ws.addCell(new jxl.write.Label(j,i,content,wc));
					}else if(content.equals("Fail")){
						jxl.write.WritableCellFormat wc = new jxl.write.WritableCellFormat();
						wc.setBackground(jxl.format.Colour.RED);
						ws.addCell(new jxl.write.Label(j,i,content,wc));
					}else{
					ws.addCell(new jxl.write.Label(j,i,content));
					}
				}
			}
			workbook.close();
			ww.write();
			ww.close();
		} catch (BiffException | IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
