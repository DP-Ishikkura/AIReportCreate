package csvoperatortest;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import operatecsv.dataholder.ActivityDataList;
import operatecsv.dataholder.F1ETDataList;
import operatecsv.inputcsv.ActivityCsvOperator;
import operatecsv.inputcsv.IndivCsvOperator;

class CheckFollowETTest {
	private String activity_path = "src/test/resources/sample_file/ETActivityReport.csv";
	private String indiv_path = "src/test/resources/sample_file/ETFertilReport.csv";
	Logger log = LogManager.getLogger(CheckFollowETTest.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("F1ETDataListテスト開始");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("F1ETDataListテスト終了");
	}

	@Test
	public void testFollowET() throws Exception {
		/*
		 * 置い移植とその前の授精についてテストする
		 */
		ActivityCsvOperator ACO = new ActivityCsvOperator(this.activity_path);
		IndivCsvOperator ICO = new IndivCsvOperator(this.indiv_path);
		//データリストを作成する
		ActivityDataList ADL = ACO.createActivityDataList();
		F1ETDataList FDL = ICO.createF1ETList();
		//Loggingの設定
		boolean[] demand_value = {
				true, true, false,
				true, true, true, 
				true, true, false, false, 
				true, 
				true, true, 
				};
		boolean real_value = true;
		//テスト
		for (int i=0; i<demand_value.length; i++) {
			real_value = FDL.checkFollowET(ADL.getActivityDataList().get(i));
//			log.trace("求める値: " + String.valueOf(demand_value[i]) + "実際値: " + String.valueOf(real_value));
			System.out.print("牛番号: " + ADL.getIdList().get(i) + "  ");
			System.out.println("求める値: " + String.valueOf(demand_value[i]) + "  実際値: " + String.valueOf(real_value));
			assertEquals(demand_value[i], real_value);
		}
	}

}
