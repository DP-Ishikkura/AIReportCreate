//package
package operatecsv.jsondataholder;

import java.util.ArrayList;
//import
import java.util.List;
import java.util.stream.Collectors;





public class FarmCodeData{
	/*
	 * FarmCode.jsonの内容を保持するクラス
	 */
	public List<Farm> farms = new ArrayList<>();
	public FarmCodeData() {
		this.farms.add(new Farm("林牧場", "158442077"));
	}
	
	
	public List<String> getFarmNameList(){
		/*
		 * 農場名の一覧を取得するメソッド
		 */
		
		List<String> result_list = this.farms.stream()
				.map(info -> info.name)
				.collect(Collectors.toList());
		return result_list;
	}
	
	
	public List<String> getFarmCodeList(){
		/*
		 * 農場名の一覧を取得するメソッド
		 */
		List<String> result_list = this.farms.stream()
				.map(info -> info.code)
				.collect(Collectors.toList());
		return result_list;
	}
	
	
	public FarmCodeData getFarmCodeData() {
		return this;
	}

}
