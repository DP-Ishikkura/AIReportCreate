//package 
package operatecsv.inputcsv;

//import
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;




public abstract class BaseCsvInput {
	/**Csvファイルの読み込みを担当するクラス */
	
	String file_path;
	public BaseCsvInput(String file_path) {
		this.file_path = file_path;
	}
	
    //正しいファイルフォーマットであるか確認する
    public abstract boolean isCorrectFileFormat() throws Exception;
    
    
	public static boolean isCsv(String file_path) {
		/**ファイルがcsvファイルであるか確認するメソッド */
		
        //ファイルの存在を調べる
        if (new File(file_path).exists() == false){return false;}   
        //csvファイルであるか調べる
        if (file_path.endsWith(".csv") == false){return false;}
        return true;
	}
	
	
    public List<CSVRecord> InputCsvFile() throws Exception{
        /**csvファイルを読み込むメソッド */
        List<CSVRecord> recordList = null;
        try(FileInputStream fos = new FileInputStream(this.file_path);){
            //csvファイルを読み込み、csvParse型にする
            BufferedReader reader = new BufferedReader(new InputStreamReader(fos, "cp932"));
            CSVParser parse = CSVFormat.DEFAULT.parse(reader);
            recordList = parse.getRecords();
        }catch (IOException e) {
           ;  
        }  
        return recordList;
    }
}