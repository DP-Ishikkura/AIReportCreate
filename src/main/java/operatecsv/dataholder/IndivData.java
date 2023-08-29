//package
package operatecsv.dataholder;

//import
import java.time.LocalDate;




public class IndivData{
    /**報告カード作成に必要な個体リストのデータを格納するクラス */
    private String id;                  //個体識別番号
    private LocalDate fertil_date;      //活動日
    private String bull_name;           //種雄牛名
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
	 * @return fertil_date
	 */
	public LocalDate getFertilDate() {
		return fertil_date;
	}
	/**
	 * @param fertil_date セットする fertil_date
	 */
	public void setFertilDate(LocalDate fertil_date) {
		this.fertil_date = fertil_date;
	}
	/**
	 * @param fertil_date セットする fertil_date
	 */
    public void setFertilDate(String date){
        /**引数がStringの場合のセッター */
        
        //日付を年、月、日に分割してLocaleDateに代入する
        String[] split_date = date.split("[-/]");
        int[] date_elems = new int[split_date.length];
        for(int i=0; i<split_date.length; i++){
            date_elems[i] = Integer.parseInt(split_date[i]);
        }
        LocalDate formatted_date = LocalDate.of(date_elems[0], date_elems[1], date_elems[2]);
        this.fertil_date = formatted_date;
    }
}