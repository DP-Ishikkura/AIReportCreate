package csvoperatortest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import operatecsv.dataholder.ActivityDataList;
import operatecsv.inputcsv.ActivityCsvOperator;

public class ActivityOperatorTest {
	private String path = "src/test/resources/sample_file/Fertilization.csv";

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("ActivityCsvOperatorクラスのテスト開始");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("ActivityCsvOperatorクラスのテスト終了");
	}
	

	@Test
	public void testCorrectFormat() throws Exception {
		/*
		 * 正しいフォーマットであるかテストする
		 */
		String[] file = {
				"src/test/resources/sample_file/Fertilization.csv",	//正しいファイル
				"src/test/resources/sample_file/IndividialList.csv",
				"src/test/resources/sample_file/Heat.csv",			//他のcsv
				"src/test/resources/sample_file/sample.png",		//画像ファイル
				"src/test/resources/sample_file/sample.txt"			//テキストファイル
		};
		ActivityCsvOperator ACO = new ActivityCsvOperator(file[0]);
		assertEquals(true, ACO.isCorrectFileFormat());
		for(int i=1; i<file.length; i++) {
			ACO = new ActivityCsvOperator(file[i]);
			assertEquals(false, ACO.isCorrectFileFormat());
		}
	}
	
	

	
	@Test
	public void testIDList() throws Exception {
		/*
		 * 活動履歴のIDリストが正しく出力されているか確認する
		 */
		List<String> correct_list = new ArrayList<>(Arrays.asList("1404734577", "1584432942", "1388439352", "1584433772", "1386930028"));
		ActivityCsvOperator ACO = new ActivityCsvOperator(this.path);
		ActivityDataList DL = ACO.createActivityDataList();
		assertEquals(correct_list, DL.getIdList());	
	}
	
	
	@Test
	public void testDateList() throws Exception {
		/*
		 * 活動履歴のIDリストが正しく出力されているか確認する
		 */
		List<LocalDate> correct_list = new ArrayList<LocalDate>(Arrays.asList(
				LocalDate.of(2023, 8, 7),
				LocalDate.of(2023, 8, 7),
				LocalDate.of(2023, 8, 4),
				LocalDate.of(2023, 8, 4),
				LocalDate.of(2023, 8, 4)
				));
		ActivityCsvOperator ACO = new ActivityCsvOperator(this.path);
		ActivityDataList DL = ACO.createActivityDataList();
		assertEquals(correct_list, DL.getActivityDateList());	
	}
	
	
	@Test
	public void testWorkersList() throws Exception {
		/*
		 * 活動履歴のIDリストが正しく出力されているか確認する
		 */
		List<String> correct_list = new ArrayList<String>(Arrays.asList("石倉 夏樹", "石倉 夏樹", "石川 恵", "石川 恵", "石川 恵"));
		ActivityCsvOperator ACO = new ActivityCsvOperator(this.path);
		ActivityDataList DL = ACO.createActivityDataList();
		assertEquals(correct_list, DL.getWorkerList());	
	}
	
	@Test
	public void testMethodsList() throws Exception {
		/*
		 * 活動履歴のIDリストが正しく出力されているか確認する
		 */
		List<String> correct_list = new ArrayList<String>(Arrays.asList("人工授精", "人工授精", "人工授精", "人工授精", "受精卵移植"));
		ActivityCsvOperator ACO = new ActivityCsvOperator(this.path);
		ActivityDataList DL = ACO.createActivityDataList();
		assertEquals(correct_list, DL.getMethodList());	
	}
	
	@Test
	public void testBullNameList() throws Exception {
		/*
		 * 活動履歴のIDリストが正しく出力されているか確認する
		 */
		List<String> correct_list = new ArrayList<String>(Arrays.asList("[和普]_HK312_鉄晴幸", "[和普]_HK312_鉄晴幸", "[ホ雌]_551H4119_キャプテン", "[和普]_HK312_鉄晴幸", "[和卵]北美津久x安福久x平茂勝"));
		ActivityCsvOperator ACO = new ActivityCsvOperator(this.path);
		ActivityDataList DL = ACO.createActivityDataList();
		assertEquals(correct_list, DL.getBullNameList());	
	}
}
