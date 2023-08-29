//package
package operatecsv.uniondata;

//import
import java.time.LocalDate;

import operatecsv.dataholder.ActivityData;
import operatecsv.dataholder.ActivityDataList;
import operatecsv.dataholder.F1ETDataList;
import operatecsv.dataholder.IndivData;
import operatecsv.dataholder.IndivDataList;
import operatecsv.dataholder.UnionedData;
import operatecsv.dataholder.UnionedDataList;



public class UnionData {
	/*
	 * 種付履歴と個体リストの結合を担当するクラス
	 */
	IndivDataList Ind_List ;		//個体リスト
	F1ETDataList F1ET_List;		//被F1ETリスト
	ActivityDataList Act_List;		//活動履歴
	UnionedDataList Unioned_List;	//結果
	
	public UnionData(IndivDataList indiv, F1ETDataList f1et, ActivityDataList activity) {
		this.Ind_List = indiv;
		this.F1ET_List = f1et;
		this.Act_List = activity;
		this.Unioned_List = new UnionedDataList();
	}
	
	private boolean isSameData(IndivData Indiv, ActivityData Act) {
		/*
		 * IndivDataとActivityDataが同一のものか確認するメソッド
		 */
		boolean result = false;
		if (Indiv.getId().equals(Act.getId()) == false) {
			result = false;		//IDが異なればfalse
		}else if(Indiv.getBullName().equals(Act.getBullName()) == false) {
			result = false;		//種雄牛名が異なればfalse
		}else if(Indiv.getFertilDate().equals(Act.getActivityDate()) == false) {
			result = false;		//種付日が異なればfalse
		}else {
			result = true;
		}
		return result;
	}
	

	private boolean includedRange(IndivData Indiv, LocalDate start, LocalDate end) {
		/*
		 * Indivが開始日から終了日の範囲内に治っているか調べるメソッド
		 */
		boolean result = false;
		if (Indiv.getFertilDate().equals(start) == true) {
			result = true;
		}else if(Indiv.getFertilDate().equals(end) == true) {
			result = true;
		}else if (end.isAfter(Indiv.getFertilDate()) == true || start.isBefore(Indiv.getFertilDate()) == true) {
			result = true;
		}
		return result;
		
	}
	
	
	public void createUnionedList() {
		/*
		 * 種付履歴と個体リストを結合するメソッド
		 */
		//リストの作成
		for (IndivData Indiv: this.Ind_List.getIndivDataList()) {
			for (ActivityData Act: Act_List.getActivityDataList()) {
				//F1リストに含まれており、追い移植前の授精である場合は続行
				if (F1ET_List.getIdList().contains(Indiv.getId()) == true) {
					if (this.F1ET_List.checkFollowET(Indiv, Act) == false) {
						continue;
					}
				}else if(this.isSameData(Indiv, Act) == false) {
					continue;
				}
				//保管クラスをインスタンス化
				UnionedData Uni = new UnionedData();
				Uni.setId(Indiv.getId());
				Uni.setMethod(Act.getMethod());
				Uni.setDate(Act.getActivityDate());
				Uni.setWorker(Act.getWorker());
				Uni.setBullName(Act.getBullName());
				this.Unioned_List.addUnionedData(Uni);		//インスタンス変数に格納する
//				break;
			}
		}
	}
	

	public void createUnionedList(LocalDate start, LocalDate end) {
		/*
		 * 種付履歴と個体リストを結合するメソッド(作成期間選択可能Ver)
		 */
		for (IndivData Indiv: Ind_List.getIndivDataList()) {
			//種付け日が選択された範囲に含まれていない場合はcontinue
			if (this.includedRange(Indiv, start, end) == false) {
				continue;
			}
			for (ActivityData Act: Act_List.getActivityDataList()) {
				if (this.F1ET_List.checkFollowET(Act) == true) {
					;
				}else if(this.isSameData(Indiv, Act) == false) {
					continue;
				}
				//保管クラスをインスタンス化
				UnionedData Uni = new UnionedData();
				Uni.setId(Act.getId());
				Uni.setMethod(Act.getMethod());
				Uni.setDate(Act.getActivityDate());
				Uni.setWorker(Act.getWorker());
				Uni.setBullName(Act.getBullName());
				this.Unioned_List.addUnionedData(Uni);		//インスタンス変数に格納する
			}
		}
	}
	
	
	public UnionedDataList getUnionedDataList() {
		return this.Unioned_List;
	}
}
