//package
package writeexcel;

import java.io.FileOutputStream;
//import
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import operatecsv.dataholder.UnionedData;
import operatecsv.dataholder.UnionedDataList;





public class ExportExcel {
	/*
	 * 日本ホルスタイン登録協会に提出するエクセルファイルを作成するクラス
	 */
	UnionedDataList UD_List;
	String[] header = {
			"個体識別農場コード",
			"人工授精師",
			"精液を注入した雌牛",
			"授精年月日(西暦)",
			"供用種雄牛登録番号または略号"
	};
	public ExportExcel(UnionedDataList ud_list) {
		this.UD_List = ud_list;
	}
	
	
	public String createSheetName() {
		/*
		 * 報告カードのシート名を作成するメソッド
		 */
		String result = "";
		//日付のデータを取得する
		LocalDate today = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMM");
		String date = today.format(dateTimeFormatter);
		//結果を出力
		result = date + "授精報告データ";
		return result;
	}
	
	
	public void setSheetHeader(Sheet ws) throws Exception{
		/*
		 *エクセルシートの設定を行うメソッド
		 */
		//ヘッダーがない場合は作成する
		Row header_row = ws.getRow(0);
		header_row = header_row == null? ws.createRow(0): header_row;
		//ループを回してヘッダーを作成する
		for (int i=0; i<this.header.length; i++) {
			Cell cell = header_row.createCell(i);
			cell.setCellValue(header[i]);
		}
	}
	
	
	public  void setHeaderStyle(Workbook wb, Sheet ws) throws Exception{
		/*
		 * エクセルシートのヘッダーのフォーマットを設定するメソッド
		 */
		//ヘッダーがない場合は作成する
		Row header_row = ws.getRow(0);
		header_row = header_row == null? ws.createRow(0): header_row;
		//ループを回してフォーマットを設定する
		for (int i=0; i<this.header.length; i++) {
			//セルが存在しない場合は作成する
			Cell cell = header_row.getCell(i);
			cell = cell == null? header_row.createCell(i): cell;
			//セルスタイルを定義
            CellStyle cell_style = wb.createCellStyle();
            Font font = wb.createFont();
            font.setFontName("Yu Gothic UI");
            font.setFontHeightInPoints((short)10);
            cell_style.setFont(font);
            cell.setCellStyle(cell_style);
		}
	}
	
	
	public  void setSheetContent(Sheet ws) throws Exception {
		/*
		 * エクセルシートに授精データを記入するためのメソッド
		 */
		//データのリストを取得してループを回す
		List<UnionedData> ud_data = this.UD_List.getUnionedDataList();
		int i = 1;
		for (UnionedData elem: ud_data) {
			//データがない場合は作成する
			Row row = ws.getRow(i);
			row = row == null? ws.createRow(i): row;
			List<String> data = elem.getDataList();
			//データをセルに記入する
			for (int j=0; j<data.size(); j++) {
				//セルが存在しない場合は作成する
				Cell cell = row.getCell(j);
				cell = cell == null? row.createCell(j): cell ;
				cell.setCellValue(data.get(j));
			}
			i++;
		}
	}
	
	
	public  void setSheetContentStyle(Workbook wb, Sheet ws) throws Exception {
		/*
		 * エクセルシートに授精データを記入欄のスタイルを設定するメソッド
		 */
		//データのリストを取得してループを回す
		List<UnionedData> ud_data = this.UD_List.getUnionedDataList();
		int i = 1;
		for (UnionedData elem: ud_data) {
			//データがない場合は作成する
			Row row = ws.getRow(i);
			row = row == null? ws.createRow(i): row;
			List<String> data = elem.getDataList();
			//データをセルに記入する
			for (int j=0; j<data.size(); j++) {
				//セルが存在しない場合は作成する
				Cell cell = row.getCell(j);
				cell = cell == null? row.createCell(j): cell ;
				//セルスタイルを定義
	            CellStyle style = wb.createCellStyle();
	            style.setBorderTop(BorderStyle.THIN);
	            style.setBorderBottom(BorderStyle.THIN);
	            style.setBorderLeft(BorderStyle.THIN);
	            style.setBorderRight(BorderStyle.THIN);
	            cell.setCellStyle(style);
			}
			i++;
		}
	}
	
	
	public void writeExcel(String dir_path) throws Exception{
		/*
		 * エクセルシートに記入するメソッド
		 */
		Workbook wb = new XSSFWorkbook();
		Sheet ws = wb.createSheet(this.createSheetName());
		
		this.setSheetHeader(ws);
		this.setHeaderStyle(wb, ws);
		this.setSheetContent(ws);
		this.setSheetContentStyle(wb, ws);

	    // 出力用のストリームを用意
	    FileOutputStream out = new FileOutputStream(dir_path + "/" + this.createSheetName() + ".xlsx");
	 
	    // ファイルへ出力
	    wb.write(out);
	}
}
