//package
package operatecsv.inputcsv;

//import 
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import operatecsv.BullCodeExchanger;
import operatecsv.dataholder.F1ETDataList;
import operatecsv.dataholder.IndivData;
import operatecsv.dataholder.IndivDataList;





public class IndivCsvOperator extends BaseCsvInput{
	/*
	 * 個体リスト読み込みを担当するクラス
	 */
	
	public IndivCsvOperator(String file_path) {
		super(file_path);
	}
	
	
	@Override
	public boolean isCorrectFileFormat() throws Exception {
		/*
		 * 個体リストファイルであるか確認するメソッド
		 */
        List<CSVRecord> record_list = this.InputCsvFile();   //引数にファイルパスを設定できるようにする
        CSVRecord header_list = record_list.get(0);
        //レコードを文字列のリストにする
        List<String> checked_list = new ArrayList<>();
        for (int i=0; i<header_list.size(); i++){checked_list.add(header_list.get(i));}
        //必要な要素が含まれているか確認する
        String[] check_list = {"個体識別番号", "最終種付日", "種付種雄牛名", "繁殖ステータス"};
        for (String elem: check_list){
            if (checked_list.contains(elem) == false){
                return false;
            }
        }
        return true;
	}
	
	
    public IndivDataList createIndivDataList() throws Exception{
    	/*
    	 * ファイルからIndivDataListを作成するメソッド
    	 */
    	
        //ファイルを読み込みヘッダーを削除する
        List<CSVRecord> record_list = this.InputCsvFile();
        //ヘッダーリストを作成する
        List<String> checked_list = new ArrayList<>();
        CSVRecord header_list = record_list.get(0);
        for (int i=0; i<header_list.size(); i++){checked_list.add(header_list.get(i));}
        record_list.remove(0);      //ヘッダーを削除する

        //リストをループして必要な情報を抜き出す
        IndivDataList result_list = new IndivDataList();
        for (CSVRecord record: record_list){
            if (!(record.get(checked_list.indexOf("繁殖ステータス")).equals("妊娠鑑定+"))){     //妊娠鑑定+以外の個体を除外する
                continue;   
            }
            //保管用クラスをインスタンス化
            IndivData Indiv = new IndivData();
            //必要な項目を抽出する
            Indiv.setId(record.get(checked_list.indexOf("個体識別番号")));
            Indiv.setFertilDate(record.get(checked_list.indexOf("最終種付日")));
            Indiv.setBullName(record.get(checked_list.indexOf("種付種雄牛名")));
            //IndivDataListに要素を加える
            result_list.addIndivData(Indiv);
        }
        return result_list;
    }
    
    
    public F1ETDataList createF1ETList() throws Exception{
    	/*
    	 * 最終種付履歴がF1ETのものを抽出するメソッド
    	 */
        //ファイルを読み込みヘッダーを削除する
        List<CSVRecord> record_list = this.InputCsvFile();
        //ヘッダーリストを作成する
        List<String> checked_list = new ArrayList<>();
        CSVRecord header_list = record_list.get(0);
        for (int i=0; i<header_list.size(); i++){checked_list.add(header_list.get(i));}
        record_list.remove(0);      //ヘッダーを削除する

        //リストをループして必要な情報を抜き出す
        F1ETDataList result_list = new F1ETDataList();
        for (CSVRecord record: record_list){
            if (!(record.get(checked_list.indexOf("繁殖ステータス")).equals("妊娠鑑定+"))){     //妊娠鑑定+以外の個体を除外する
                continue;   
            }
            //種付種雄牛名がF1のものだけを抽出する
            String bull_name = record.get(checked_list.indexOf("種付種雄牛名"));
            if (new BullCodeExchanger().isF1Egg(bull_name) == false) {
            	continue;
            }
            //保管用クラスをインスタンス化
            IndivData Indiv = new IndivData();
            //必要な項目を抽出する
            Indiv.setId(record.get(checked_list.indexOf("個体識別番号")));
            Indiv.setFertilDate(record.get(checked_list.indexOf("最終種付日")));
            Indiv.setBullName(record.get(checked_list.indexOf("種付種雄牛名")));
            //IndivDataListに要素を加える
            result_list.addF1Data(Indiv);
        }
        return result_list;
    	
		
	}
}
