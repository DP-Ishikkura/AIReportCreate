//package
package operatecsv.dataholder;

//import 
import java.time.LocalDate;

public class ActivityData {
    /**報告カード作成に必要な活動履歴のデータを格納するクラス */
    private String id;                      //個体識別番号
    private LocalDate activity_date;        //活動日
    private String worker;                  //作業者
    private String method;					//種付方法
    private String bull_name;               //種雄牛名
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getActivityDate() {
		return activity_date;
	}
	public void setActivityDate(LocalDate activity_date) {
		this.activity_date = activity_date;
	}
    public void setActivityDate(String date){
        /**引数がStringの場合のセッター */
        
        //日付を年、月、日に分割してLocaleDateに代入する
        String[] split_date = date.split("[-/]");
        int[] date_elems = new int[split_date.length];
        for(int i=0; i<split_date.length; i++){
            date_elems[i] = Integer.parseInt(split_date[i]);
        }
        LocalDate formatted_date = LocalDate.of(date_elems[0], date_elems[1], date_elems[2]);
        this.activity_date = formatted_date;
    }
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	/**@return bull_name*/
	public String getBullName() {
		return bull_name;
	}
	/**@param bull_name セットする bull_name*/
	public void setBullName(String bull_name) {
		this.bull_name = bull_name;
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


}