//package
package operatecsv.dataholder;

//import 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class IndivDataList{
	/*
	 *IndivDataをまとめて扱うためのクラス 
	 */

  private List<IndivData> indiv_data = new ArrayList<>();
	  
  public void addIndivData(IndivData data){
	  /**indiv_dataのSetter */
	  this.indiv_data.add(data);
  }
  
  
  public List<IndivData> getIndivDataList(){
      /**個体識別番号のリストを取得するゲッター */
	  return this.indiv_data;
  }
  
  
  public List<String> getIdList(){
      /**個体識別番号のリストを取得するゲッター */
      List<String> result_list = new ArrayList<>();
      this.indiv_data.stream().forEach(e -> result_list.add(e.getId()));
      return result_list;
  }
  
  
  public List<String> getBullNameList(){
      /**種雄牛のリストを取得するゲッター */
      List<String> result_list = new ArrayList<>();
      this.indiv_data.stream().forEach(e -> result_list.add(e.getBullName()));
      return result_list;
  }


  public List<LocalDate> getFertilDateList(){
      /**個体識別番号のリストを取得するゲッター */
      List<LocalDate> result_list = new ArrayList<>();
      this.indiv_data.stream().forEach(e -> result_list.add(e.getFertilDate()));
      return result_list;
  }


}