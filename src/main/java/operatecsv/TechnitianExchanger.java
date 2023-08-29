package operatecsv;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import operatecsv.dataholder.UnionedData;
import operatecsv.jsondataholder.TechnitianData;


public class TechnitianExchanger {
	/*
	 * 
	 */
	TechnitianData Td ;				//授精師データ
	public TechnitianExchanger() throws JsonParseException, JsonMappingException, IOException {
		this.Td = new JsonHolderCreater().createTechCodeHolder();
	}
	
	
	private String baseGetTechCode(UnionedData ud) {
		/*
		 * 技術者の授精師コードを取得する
		 */
		//結果のリストとTechnitianJsonの名前リストを取得
		String result = "";
		List<String> name_List = Td.getNameList();
		//リストに名前が含まれている場合はコードを取得する
		if (name_List.contains(ud.getWorker())) {
			int index = name_List.indexOf(ud.getWorker());
			result = Td.technitians.get(index).code;
		}
		return result;	
	}
	
	
	public void getTechCode(UnionedData ud) {
		/*
		 * ETとAIで技術者コードを取得するメソッド
		 */
		String result = "";
		//授精師名リストに名前がない場合は、名前をそのまま残す
		if (this.Td.getAITechNameList().contains(ud.getWorker()) == false) {
			result = ud.getWorker();
		}else if (ud.getMethod().equals("人工授精")) {		//種付方法が人工授精の場合の処理
			if (this.Td.getAITechNameList().contains(ud.getWorker()) == true) {
				result = baseGetTechCode(ud);		//人工授精師一覧に名前がある場合はコードを代入
			}else {
				result = this.Td.getRandomAITechCode();						//一覧にない場合は他の授精師コードを代入
			}
		}else if(ud.getMethod().equals("受精卵移植")) {	//受精卵移植の場合
			if (this.Td.getETTechNameList().contains(ud.getWorker()) == true) {
				result = baseGetTechCode(ud);		//移植師一覧に名前がある場合はコードを代入
			}else {
				result = this.Td.getRandomETTechCode();								//一覧にない場合は空文字を代入
			}
		}
		ud.setWorkerCode(result);
	}
}
