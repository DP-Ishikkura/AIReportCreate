//package
package operatecsv.dataholder;

//import 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UnionedDataList {
	/*
	 * UnionedDataのリストを扱うクラス
	 */
	private List<UnionedData> unioned_list = new ArrayList<>();

	
	public void addUnionedData(UnionedData data){
		/*
		 * unioned_listにデータを追加するメソッド
		 */
		this.unioned_list.add(data);
	}
	
	public List<UnionedData> getUnionedDataList(){
		return this.unioned_list;
	}
	
	public List<String> getFarmCodeList(){
		/**個体識別番号のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getFarmCode()));
		return result_list;
	}
	public List<String> getIdList(){
		/**個体識別番号のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getId()));
		return result_list;
	}
	public List<LocalDate> getDateList(){
		/*種付日のリストを取得するゲッター */
		List<LocalDate> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getDate()));
		return result_list;
	}
	public List<String> getMethodList(){
		/**種付方法のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getMethod()));
		return result_list;
	}
	public List<String> getWorkerList(){
		/**種付方法のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getWorker()));
		return result_list;
	}
	public List<String> getWorkerCodeList(){
		/**種付方法のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getWorkerCode()));
		return result_list;
	}
	public List<String> getBullNameList(){
		/**種雄牛名のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getBullName()));
		return result_list;
	}
	public List<String> getBullCodeList(){
		/**種雄牛名のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.unioned_list.stream().forEach(e -> result_list.add(e.getBullCode()));
		return result_list;
	}

}
