package exchangertest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import operatecsv.BullCodeExchanger;
import operatecsv.dataholder.ActivityDataList;
import operatecsv.dataholder.F1ETDataList;
import operatecsv.dataholder.IndivDataList;
import operatecsv.dataholder.UnionedData;
import operatecsv.dataholder.UnionedDataList;
import operatecsv.inputcsv.ActivityCsvOperator;
import operatecsv.inputcsv.IndivCsvOperator;
import operatecsv.uniondata.UnionData;

public class BullCodeExchangerTest {
	private String indiv_path = "src/test/resources/uniondatatest/ForUnionIndiv.csv";
	private String activity_path = "src/test/resources/uniondatatest/ForUnionActivity.csv";

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("BullCodeExchangerのテスト開始");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("BullCodeExchangerのテスト終了");
	}
	
	
	private UnionedDataList getUnionedDataList() throws Exception {
		IndivDataList Idl = new IndivCsvOperator(this.indiv_path).createIndivDataList();
		F1ETDataList F1dl = new IndivCsvOperator(this.indiv_path).createF1ETList();
		ActivityDataList Adl = new ActivityCsvOperator(this.activity_path).createActivityDataList();
		//融合リストを作成
		UnionData UD = new UnionData(Idl, F1dl, Adl);
		UD.createUnionedList();
		return UD.getUnionedDataList();
	}
	
	
	@Test
	public void testGetBullCode() throws Exception {
		/*
		 * 種雄牛コードが作成されているかテストする
		 */
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"F1受精卵","F1受精卵","HK312","HK312","黒毛受精卵","HK312","551H4119","551HO04267" 
				));
		List<String> correct_id = new ArrayList<>(Arrays.asList(
				"1628336700", "1628336281", "1628336281", "1628336281","1556632233", "1556632004", "1390339107", "1390338940"
				));
		List<LocalDate> correct_date = new ArrayList<>(Arrays.asList(
				LocalDate.of(2023, 7, 17),
				LocalDate.of(2023, 7, 23),
				LocalDate.of(2023, 7, 15),
				LocalDate.of(2023, 7, 14),
				LocalDate.of(2023, 7, 19),
				LocalDate.of(2023, 7, 18),
				LocalDate.of(2023, 7, 13),
				LocalDate.of(2023, 7, 13)
				));
		List<String> correct_method = new ArrayList<>(Arrays.asList(
				"受精卵移植", "受精卵移植", "人工授精", "人工授精", "受精卵移植", "人工授精", "人工授精", "人工授精"
				));
		List<String> correct_worker = new ArrayList<>(Arrays.asList(
				"石川 恵", "石川 恵", "石倉 夏樹", "石倉 夏樹", "石川 恵", "石川 恵", "石川 恵", "石川 恵"
				));
		List<String> correct_bull = new ArrayList<>(Arrays.asList(
				"[F1卵]美津茂洋", "[F1]PK730", "[和普]_HK312_鉄晴幸", "[和普]_HK312_鉄晴幸", "[和卵]_紀多福", "[和普]_HK312_鉄晴幸", "[ホ雌]_551H4119_キャプテン", "[ホ雌]_551HO04267_バクストン"
				));
		UnionedDataList Udl = this.getUnionedDataList();
		for (UnionedData elem: Udl.getUnionedDataList()) {
			new BullCodeExchanger().getBullCode(elem);
		}
		//テスト
		assertEquals(correct_list, Udl.getBullCodeList());
		assertEquals(correct_id, Udl.getIdList());
		assertEquals(correct_date, Udl.getDateList());
		assertEquals(correct_method, Udl.getMethodList());
		assertEquals(correct_worker, Udl.getWorkerList());
		assertEquals(correct_bull, Udl.getBullNameList());
	}
}
