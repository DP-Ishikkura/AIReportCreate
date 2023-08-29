package csvoperatortest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import operatecsv.inputcsv.BaseCsvInput;

public class CsvInputTest {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("BaseCsvInputのテストを開始");
	}
	
	
	@Test
	public void checkIsCsv() {
		/*
		 * CSVファイルであるか確認するメソッド
		 */
		String[] file = {
				"src/test/resources/sample_file/Fertilization.csv",	//正しいファイル
				"src/test/resources/sample_file/Heat.csv",			//他のcsv
				"src/test/resources/sample_file/sample.png",		//画像ファイル
				"src/test/resources/sample_file/sample.txt"			//テキストファイル
		};
		assertEquals(true, BaseCsvInput.isCsv(file[0]));
		assertEquals(true, BaseCsvInput.isCsv(file[1]));
		assertEquals(false, BaseCsvInput.isCsv(file[2]));
		assertEquals(false, BaseCsvInput.isCsv(file[3]));
	}

	
	@AfterAll
	public static void afterAll() {
		System.out.println("BaseCsvInputのテストを開始");
	}
}
