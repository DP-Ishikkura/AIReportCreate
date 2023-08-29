package writeexcel;

import operatecsv.BullCodeExchanger;
import operatecsv.FarmCodeExchanger;
import operatecsv.TechnitianExchanger;
import operatecsv.dataholder.ActivityDataList;
import operatecsv.dataholder.F1ETDataList;
import operatecsv.dataholder.IndivDataList;
import operatecsv.dataholder.UnionedData;
import operatecsv.dataholder.UnionedDataList;
import operatecsv.inputcsv.ActivityCsvOperator;
import operatecsv.inputcsv.IndivCsvOperator;
import operatecsv.uniondata.UnionData;

public class ExcelContentCreater {
	/*
	 * エクセルファイルに書き込むためのデータを作成するためのクラス
	 */
	private String indiv_path;
	private String activity_path;
	public ExcelContentCreater(String indiv_path, String activity_path) {
		this.indiv_path = indiv_path;
		this.activity_path = activity_path;
	}
	
	
	public UnionedDataList createForExcelData() throws Exception {
		/*
		 * エクセルに書き込むまでの処理を行うメソッド
		 */
		//csvを読み込んで結合リストを作成する
		IndivDataList IDL = new IndivCsvOperator(this.indiv_path).createIndivDataList();
		F1ETDataList F1DL = new IndivCsvOperator(this.indiv_path).createF1ETList();
		ActivityDataList ADL = new ActivityCsvOperator(this.activity_path).createActivityDataList();
		UnionData UD = new UnionData(IDL, F1DL, ADL);
		UD.createUnionedList();
		//コード生成クラスの作成
		FarmCodeExchanger Fce = new FarmCodeExchanger();
		BullCodeExchanger Bce = new BullCodeExchanger();
		TechnitianExchanger Tce = new TechnitianExchanger();
		//各種コードを作成する
		UnionedDataList Udl = UD.getUnionedDataList();
		for (UnionedData elem: Udl.getUnionedDataList()) {
			Fce.setHayashiFarmCode(elem);
			Bce.getBullCode(elem);
			Tce.getTechCode(elem);
		}
		return Udl;
	}
}
