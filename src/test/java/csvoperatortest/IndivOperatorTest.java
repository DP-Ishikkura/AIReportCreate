package csvoperatortest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import operatecsv.dataholder.F1ETDataList;
import operatecsv.dataholder.IndivDataList;
import operatecsv.inputcsv.IndivCsvOperator;

public class IndivOperatorTest {
	private String path = "src/test/resources/sample_file/IndividialList.csv";

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("IndivCsvOperatorのテスト");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("IndivCsvOperatorのテスト");
	}

	@Test
	public void testCorrectFormat() throws Exception {
		/*
		 * 正しいフォーマットであるかテストする
		 */
		String[] file = {
				"src/test/resources/sample_file/IndividialList.csv",
				"src/test/resources/sample_file/Fertilization.csv",	//正しいファイル
				"src/test/resources/sample_file/Heat.csv",			//他のcsv
				"src/test/resources/sample_file/sample.png",		//画像ファイル
				"src/test/resources/sample_file/sample.txt"			//テキストファイル
		};
		IndivCsvOperator ICO = new IndivCsvOperator(file[0]);
		assertEquals(true, ICO.isCorrectFileFormat());
		for(int i=1; i<file.length; i++) {
			ICO = new IndivCsvOperator(file[i]);
			assertEquals(false, ICO.isCorrectFileFormat());
		}
	}
	
	
	@Test
	public void testIDList() throws Exception {
		/*
		 * 個体リストのIDを取得するテスト
		 */
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"1584433437", "1535730875", "1391737353", "1535731384", "1535731414"
				));
		IndivCsvOperator ICO = new IndivCsvOperator(this.path);
		IndivDataList DL = ICO.createIndivDataList();
		assertEquals(correct_list, DL.getIdList());
	}

	
	@Test
	public void testBullNameList() throws Exception {
		/*
		 * 個体リストの種雄牛名を取得するテスト
		 */
		List<String> correct_list = new ArrayList<>(Arrays.asList(
				"[和卵]久福久x美津百合x安平", 
				"[和卵]久福久x美津百合x安平", 
				"[F1卵]ノースベッツIVF卵", 
				"[和卵]_福増E黒031x北福波x平茂勝", 
				"[和卵]_紀多福"
				));
		IndivCsvOperator ICO = new IndivCsvOperator(this.path);
		IndivDataList DL = ICO.createIndivDataList();
		assertEquals(correct_list, DL.getBullNameList());
	}
	
	
	@Test
	public void testFertilDateList() throws Exception {
		/*
		 * 個体リストの授精日を取得するテスト
		 */
		List<LocalDate> correct_list = new ArrayList<LocalDate>(Arrays.asList(
				LocalDate.of(2022, 11, 6),
				LocalDate.of(2022, 11, 11),
				LocalDate.of(2022, 11, 14),
				LocalDate.of(2022, 11, 20),
				LocalDate.of(2022, 11, 24)
				));
		IndivCsvOperator ICO = new IndivCsvOperator(this.path);
		IndivDataList DL = ICO.createIndivDataList();
		assertEquals(correct_list, DL.getFertilDateList());
	}
	

	@Test
	public void testF1IDList() throws Exception {
		/*
		 * 個体リストのIDを取得するテスト
		 */
		List<String> correct_list = new ArrayList<>(Arrays.asList("1391737353"));
		IndivCsvOperator ICO = new IndivCsvOperator(this.path);
		F1ETDataList DL = ICO.createF1ETList();
		assertEquals(correct_list, DL.getIdList());
	}
	
	
	@Test
	public void testF1BullNameList() throws Exception {
		/*
		 * 個体リストの種雄牛名を取得するテスト
		 */
		List<String> correct_list = new ArrayList<>(Arrays.asList("[F1卵]ノースベッツIVF卵"));
		IndivCsvOperator ICO = new IndivCsvOperator(this.path);
		F1ETDataList DL = ICO.createF1ETList();
		assertEquals(correct_list, DL.getBullNameList());
	}
	
	
	@Test
	public void testF1FertilDateList() throws Exception {
		/*
		 * 個体リストの授精日を取得するテスト
		 */
		List<LocalDate> correct_list = new ArrayList<LocalDate>(Arrays.asList(LocalDate.of(2022, 11, 14)));
		IndivCsvOperator ICO = new IndivCsvOperator(this.path);
		IndivDataList DL = ICO.createF1ETList();
		assertEquals(correct_list, DL.getFertilDateList());
	}

}
