//package
package operatecsv.dataholder;

//import
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ActivityDataList {
  /** ActivityDataのリストを操作するクラス */
  private List<ActivityData> activity_data = new ArrayList<>();

  
  public void addActivityData(ActivityData data){
      /**activity_dataのSetter */
      this.activity_data.add(data);
  }


  //Getter
  public List<ActivityData> getActivityDataList(){
      /**個体識別番号のリストを取得するゲッター */
      return activity_data;
  }
  public List<String> getIdList(){
      /**個体識別番号のリストを取得するゲッター */
      List<String> result_list = new ArrayList<>();
      this.activity_data.stream().forEach(e -> result_list.add(e.getId()));
      return result_list;
  }
  public List<LocalDate> getActivityDateList(){
      /**個体識別番号のリストを取得するゲッター */
      List<LocalDate> result_list = new ArrayList<>();
      this.activity_data.stream().forEach(e -> result_list.add(e.getActivityDate()));
      return result_list;
  }
  public List<String> getWorkerList(){
      /**個体識別番号のリストを取得するゲッター */
      List<String> result_list = new ArrayList<>();
      this.activity_data.stream().forEach(e -> result_list.add(e.getWorker()));
      return result_list;
  }
 public List<String> getMethodList() {
	/** 種付け方法リストを作成するゲッター*/
     List<String> result_list = new ArrayList<>();
     this.activity_data.stream().forEach(e -> result_list.add(e.getMethod()));
     return result_list;
}
  public List<String> getBullNameList(){
      /**個体識別番号のリストを取得するゲッター */
      List<String> result_list = new ArrayList<>();
      this.activity_data.stream().forEach(e -> result_list.add(e.getBullName()));
      return result_list;
  }
}