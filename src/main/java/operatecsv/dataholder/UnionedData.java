//package
package operatecsv.dataholder;

//import 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





public class UnionedData {
	/*
	 * 個体リスト種付履歴を結合したものを保持するクラス
	 */
	private String farm_code;	//農場コード	
	private String id;			//個体識別番号
	private LocalDate date;		//種付日
	private String method;		//種付方法
	private String worker;		//授精師
	private String worker_code;	//授精師コード
	private String bull_name;	//種雄牛名
	private String bull_code;	//精液ラベル

	
	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date セットする date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method セットする method
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return bull_name
	 */
	public String getBullName() {
		return bull_name;
	}
	/**
	 * @param bull_name セットする bull_name
	 */
	public void setBullName(String bull_name) {
		this.bull_name = bull_name;
	}
	/**
	 * @return worker
	 */
	public String getWorker() {
		return worker;
	}
	/**
	 * @param worker セットする worker
	 */
	public void setWorker(String worker) {
		this.worker = worker;
	}
	/**
	 * @return farm_code
	 */
	public String getFarmCode() {
		return farm_code;
	}
	/**
	 * @param farm_code セットする farm_code
	 */
	public void setFarmCode(String farm_code) {
		this.farm_code = farm_code;
	}
	/**
	 * @return worker_code
	 */
	public String getWorkerCode() {
		return worker_code;
	}
	/**
	 * @param worker_code セットする worker_code
	 */
	public void setWorkerCode(String worker_code) {
		this.worker_code = worker_code;
	}
	/**
	 * @return bull_code
	 */
	public String getBullCode() {
		return bull_code;
	}
	/**
	 * @param bull_code セットする bull_code
	 */
	public void setBullCode(String bull_code) {
		this.bull_code = bull_code;
	}
	
	
	private String createFormattedDate() {
		/*
		 * フォーマット化した日付データを出力するメソッド
		 */
		String result = "";
		//日付のデータを取得する
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		result = this.getDate().format(dateTimeFormatter);
		return result;
	}
	
	
	public List<String> getDataList(){
		/*
		 * 出力用のデータリストを取得するメソッド
		 */
		List<String> result_list = new ArrayList<>(Arrays.asList(
				this.getFarmCode(), 
				this.getWorkerCode(), 
				this.getId(),
				this.createFormattedDate(),
				this.getBullCode()
		));
		return result_list;
	}
}
