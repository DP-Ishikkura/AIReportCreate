//package
package operatecsv.dataholder;

import java.time.LocalDate;
//import
import java.util.ArrayList;
import java.util.List;

public class F1ETDataList extends IndivDataList{
	/*
	 * F1ETデータをまとめて扱うためのクラス
	 */
	private List<IndivData> f1_data = new ArrayList<>();
	
	
	public void addF1Data(IndivData data){
		/**indiv_dataのSetter */
		this.f1_data.add(data);
	}
	
	public List<IndivData> getF1DataList(){
		return this.f1_data;
	}

	public List<String> getIdList(){
		/**個体識別番号のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.f1_data.stream().forEach(e -> result_list.add(e.getId()));
		return result_list;
	}
	
	public List<LocalDate> getFertilDateList(){
		/**個体識別番号のリストを取得するゲッター */
		List<LocalDate> result_list = new ArrayList<>();
		this.f1_data.stream().forEach(e -> result_list.add(e.getFertilDate()));
		return result_list;
	}
	
	public List<String> getBullNameList(){
		/**種雄牛のリストを取得するゲッター */
		List<String> result_list = new ArrayList<>();
		this.f1_data.stream().forEach(e -> result_list.add(e.getBullName()));
		return result_list;
	}

	
//	private boolean isFollowET(ActivityData Act) {
//		/*
//		 * Actに指定した種付けデータがF1ETに関連するものか調べるメソッド
//		 */	
//		boolean result = false;
//		for (IndivData f1: this.getF1DataList()) {
//			//個体リストと活動履歴の種付日を変数として設定
//			LocalDate et_date = f1.getFertilDate();
//			LocalDate activity_date = Act.getActivityDate();
//			LocalDate minus10days = f1.getFertilDate().minusDays(10);	//種付日-10日
//			//個体識別番号が一致するか
//			if (Act.getId().equals(f1.getId()) == false) {
//				result = false;
//			}else if(activity_date.equals(et_date) == true) {
//				result = true;		//種付日が同一ならtrue
//				break;
//			}else if (activity_date.isBefore(et_date) == true && activity_date.isAfter(minus10days) == true) {
//				result = true;		//種付日を起点として-10日以内にAIした場合はtrue
//				break;
//			}
//		}
//		return result;	
//	}
	
	
	private boolean isFollowET(ActivityData Act) {
		/*
		 * Actに指定した種付けデータがF1ETに関連するものか調べるメソッド
		 */	
		boolean result = false;
		//F1追い移植を行った牛を特定する
		int index = this.getIdList().indexOf(Act.getId());
		IndivData f1 = this.getF1DataList().get(index);
		//個体リストと活動履歴の種付日を変数として設定
		LocalDate et_date = f1.getFertilDate();
		LocalDate activity_date = Act.getActivityDate();
		LocalDate minus10days = f1.getFertilDate().minusDays(10);	//種付日-10日
		//個体識別番号が一致するか
		if (Act.getId().equals(f1.getId()) == false) {
			result = false;
		}else if(activity_date.equals(et_date) == true) {
			result = true;		//種付日が同一ならtrue
		}else if (activity_date.isBefore(et_date) == true && activity_date.isAfter(minus10days) == true) {
			result = true;		//種付日を起点として-10日以内にAIした場合はtrue
		}
		return result;
		
	}
	
	
	public boolean checkFollowET(ActivityData Act) {
		/*
		 * Actに指定した種付けデータがF1ETに関連するものか調べるメソッド
		 */
		boolean result = false;
		List<String> id_list = this.getIdList();
		//F1を種付した個体リストに活動履歴のデータが含まれているか確認する
		if (id_list.contains(Act.getId()) == true) {
			if (this.isFollowET(Act) == true) {
				result = true;
			}else {
				result = false;
			}
		}else {
			result = false;
		}
		return result;
	}
	
	
	
	public boolean checkFollowET(IndivData Ind, ActivityData Act) {
		/*
		 * Actに指定した種付けデータがF1ETに関連するものか調べるメソッド
		 */
		boolean result = false;
		//F1を種付した個体リストに活動履歴のデータが含まれているか確認する
		if (Ind.getId().equals(Act.getId()) == true) {
			result = this.isFollowET(Act) == true? true: false; 
		}else {
			result = false;
		}
		return result;
	}
}
