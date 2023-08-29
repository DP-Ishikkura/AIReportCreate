package uniontest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import operatecsv.dataholder.ActivityDataList;
import operatecsv.dataholder.F1ETDataList;
import operatecsv.dataholder.IndivDataList;
import operatecsv.dataholder.UnionedDataList;
import operatecsv.inputcsv.ActivityCsvOperator;
import operatecsv.inputcsv.IndivCsvOperator;
import operatecsv.uniondata.UnionData;

public class UnionDataTest {
	private String indiv_path = "src/test/resources/uniondatatest/ForUnionIndiv.csv";
	private String activity_path = "src/test/resources/uniondatatest/ForUnionActivity.csv";
//	private String indiv_path = "src/test/resources/sample_file/FullIndivData.csv";
//	private String activity_path = "src/test/resources/sample_file/FullActivityData.csv";
	private UnionedDataList UDL;


	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("UnionDataのテストを開始");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("UnionDataのテストを終了");
	}
	
	private void createUnionedDataList() throws Exception {
		/*
		 * 融合したデータリストを作成するメソッド
		 */
		IndivDataList IDL = new IndivCsvOperator(this.indiv_path).createIndivDataList();
		F1ETDataList F1DL = new IndivCsvOperator(this.indiv_path).createF1ETList();
		ActivityDataList ADL = new ActivityCsvOperator(this.activity_path).createActivityDataList();
		//融合リストを作成
		UnionData UD = new UnionData(IDL, F1DL, ADL);
		UD.createUnionedList();
		this.UDL = UD.getUnionedDataList();
	}

	@Test 
	public void testGetIdList() throws Exception{
		/*
		 * getIdListをチェックするメソッド
		 */
		this.createUnionedDataList();
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"1628336700", "1628336281", "1628336281", "1628336281", "1556632233", "1556632004", "1390339107", "1390338940"
				));
		assertEquals(correct_list, this.UDL.getIdList());
	}
	
	
	@Test 
	public void testGetDateList() throws Exception{
		/*
		 * getIdListをチェックするメソッド
		 */
		this.createUnionedDataList();
		List<LocalDate> correct_list = new ArrayList<>(Arrays.asList(
				LocalDate.of(2023, 7, 17),
				LocalDate.of(2023, 7, 23),
				LocalDate.of(2023, 7, 15),
				LocalDate.of(2023, 7, 14),
				LocalDate.of(2023, 7, 19),
				LocalDate.of(2023, 7, 18),
				LocalDate.of(2023, 7, 13),
				LocalDate.of(2023, 7, 13)
				));
		assertEquals(correct_list, this.UDL.getDateList());
	}
	
	
	@Test 
	public void testGetMethodList() throws Exception{
		/*
		 * getIdListをチェックするメソッド
		 */
		this.createUnionedDataList();
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"受精卵移植", "受精卵移植","人工授精","人工授精", "受精卵移植", "人工授精", "人工授精", "人工授精"
				));
		assertEquals(correct_list, this.UDL.getMethodList());
	}
	
	
	@Test 
	public void testGetWorkerList() throws Exception{
		/*
		 * getIdListをチェックするメソッド
		 */
		this.createUnionedDataList();
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"石川 恵", "石川 恵", "石倉 夏樹", "石倉 夏樹", "石川 恵", "石川 恵", "石川 恵", "石川 恵"
				));
		assertEquals(correct_list, this.UDL.getWorkerList());
	}
	
	
	@Test 
	public void testGetBullNameList() throws Exception{
		/*
		 * getIdListをチェックするメソッド
		 */
		this.createUnionedDataList();
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"[F1卵]美津茂洋", "[F1]PK730","[和普]_HK312_鉄晴幸", "[和普]_HK312_鉄晴幸", "[和卵]_紀多福", "[和普]_HK312_鉄晴幸", "[ホ雌]_551H4119_キャプテン", "[ホ雌]_551HO04267_バクストン"
				));
		assertEquals(correct_list, this.UDL.getBullNameList());
	}

}
