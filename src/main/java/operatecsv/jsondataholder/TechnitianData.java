//package
package operatecsv.jsondataholder;

import java.util.ArrayList;
//import 
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;





public class TechnitianData{
	/*
	 * TechnitianInfo.jsonの内容を保持するクラス
	 */
	public List<Technitian> technitians = new ArrayList<>();
	
	public TechnitianData() {
		this.technitians.add(new Technitian("石川 恵", "0106000409", true, false));
		this.technitians.add(new Technitian("石倉 夏樹", "2000002915", true, true));
		this.technitians.add(new Technitian("平 勇人", "", true, false));
	}
	
	
	public List<String> getNameList(){
		/*
		 * 技術者全員の名前を取得するメソッド
		 */
		List<String> result_List = this.technitians.stream()
				.map(info -> info.name)
				.collect(Collectors.toList());
		return result_List;
	}
	
	
	public List<String> getETTechNameList(){
		/*
		 * ET技術者名リストを取得するメソッド
		 */		
		List<String> result_List = this.technitians.stream()
				.filter(info -> info.et == true)
				.map(info -> info.name)
				.collect(Collectors.toList());
		return result_List;
	}
	
	
	public List<String> getETTechCodeList(){
		/*
		 * ET技術者の授精師コード一覧を取得するメソッド
		 */
		List<String> result_List = this.technitians.stream()
				.filter(info -> info.et == true)
				.map(info -> info.code)
				.collect(Collectors.toList());
		return result_List;
	}
	
	
	public List<String> getAITechNameList(){
		/*
		 * AI技術者名のリストを取得するメソッド
		 */		
		List<String> result_List = this.technitians.stream()
				.filter(info -> info.ai == true)
				.map(info -> info.name)
				.collect(Collectors.toList());
		return result_List;
	}
	
	
	public List<String> getAITechCodeList(){
		/*
		 * ET技術者の授精師コード一覧を取得するメソッド
		 */
		List<String> result_List = this.technitians.stream()
				.filter(info -> info.ai == true)
				.map(info -> info.code)
				.collect(Collectors.toList());
		return result_List;
	}
	
	
	private String getRandomTechCode(Supplier<List<String>> func) {
		/*
		 * ランダムな授精師コードを取得するメソッド
		 */
		List<String> code_list = func.get();
		Random rand = new Random();
		int num = rand.nextInt(code_list.size());
		return code_list.get(num);
	}
	
	
	public String getRandomAITechCode() {
		/*
		 * ランダムな人口授精師の授精師コードを取得するメソッド
		 */
		Supplier<List<String>> func = this::getAITechCodeList;
		return this.getRandomTechCode(func);
	}
	

	public String getRandomETTechCode() {
		/*
		 * ランダムな人口授精師の授精師コードを取得するメソッド
		 */
//		Supplier<List<String>> func = new TechnitianData()::getETTechCodeList;
		Supplier<List<String>> func = this::getETTechCodeList;
		return this.getRandomTechCode(func);
	}
	
	public TechnitianData getTechnitianData() {
		return this;
	}
}
