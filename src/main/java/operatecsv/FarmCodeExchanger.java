//package
package operatecsv;

//import
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import operatecsv.dataholder.UnionedData;
import operatecsv.jsondataholder.FarmCodeData;





public class FarmCodeExchanger {
	/*
	 * 農場コードの取り扱いを担当するクラス
	 */
	FarmCodeData FD;
	public FarmCodeExchanger() throws JsonParseException, JsonMappingException, IOException {
		this.FD = new JsonHolderCreater().createFarmCodeHolder();
	}
	
	
	public void setFarmCode(UnionedData ud, String farm_name) {
		/*
		 * 牧場名から農場コードを設定するクラス
		 */
		String result = "";
		List<String> name_List = this.FD.getFarmNameList();
		//リストに名前が含まれている場合はコードを取得する
		if (name_List.contains(farm_name)) {
			int index = name_List.indexOf(farm_name);
			result = FD.farms.get(index).code;
		}
		ud.setFarmCode(result);
	}
	
	
	public void setHayashiFarmCode(UnionedData ud) {
		/*
		 * 林牧場の農場コードを取得するメソッド
		 */
		String farm_name = "林牧場";
		this.setFarmCode(ud, farm_name);
	}
}
