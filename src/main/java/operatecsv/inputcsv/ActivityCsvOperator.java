//package
package operatecsv.inputcsv;

//import
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import operatecsv.dataholder.ActivityData;
import operatecsv.dataholder.ActivityDataList;





public class ActivityCsvOperator extends BaseCsvInput{
	/** 活動履歴の読み込みを行うクラス */
	
	public ActivityCsvOperator(String file_path) {
		super(file_path);
	}
	
	@Override
	public boolean isCorrectFileFormat() throws Exception {
        /**活動履歴の種付けファイルであるか確認するメソッド */

        //csvを読み込み、column名を取得する
        List<CSVRecord> record_list = this.InputCsvFile();   
        CSVRecord header_list = record_list.get(0);
        //レコードを文字列のリストにする
        List<String> checked_list = new ArrayList<>();
        for (int i=0; i<header_list.size(); i++){checked_list.add(header_list.get(i));}
        //必要な要素が含まれているか確認する
        String[] check_list = {"個体識別番号", "活動日", "作業者", "種付方法", "種雄牛名"};
        for (String elem: check_list){
            if (checked_list.contains(elem) == false){
                return false;
            }
        }
        return true;
    }
	

    public ActivityDataList createActivityDataList() throws Exception{
        /**種付けリストを整形して読み込むメソッド */

        //ファイルを読み込みヘッダーを削除する
        List<CSVRecord> record_list = this.InputCsvFile();
        //ヘッダーリストを作成する
        List<String> checked_list = new ArrayList<>();
        CSVRecord header_list = record_list.get(0);
        for (int i=0; i<header_list.size(); i++){checked_list.add(header_list.get(i));}
        record_list.remove(0);      //ヘッダーを削除する

        //
        ActivityDataList result_list = new ActivityDataList();
        //リストをループして必要な情報を抜き出す
        for (CSVRecord record: record_list){
            //保管用クラスをインスタンス化
            ActivityData Act = new ActivityData();
            //必要な項目を抽出する　
            Act.setId(record.get(checked_list.indexOf("個体識別番号")));
            Act.setActivityDate(record.get(checked_list.indexOf("活動日")));
            Act.setWorker(record.get(checked_list.indexOf("作業者")));
            Act.setMethod(record.get(checked_list.indexOf("種付方法")));
            Act.setBullName(record.get(checked_list.indexOf("種雄牛名")));  
            //一次保管用リストを準備する
            result_list.addActivityData(Act);
        }
        return result_list;
    }    
}
