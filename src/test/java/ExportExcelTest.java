import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
import writeexcel.ExportExcel;


public class ExportExcelTest {
	private String indiv_path = "src/test/resources/sample_file/FullIndivData.csv";
	private String activity_path = "src/test/resources/sample_file/FullActivityData.csv";
	private Workbook Wb;
	private Sheet Ws;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("ExportExcelのテスト開始");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("ExportExcelのテスト終了");
	}
	
	private UnionedDataList getUnionedDataList() throws Exception {
		/*
		 * 融合したデータリストを作成するメソッド
		 */
		IndivDataList IDL = new IndivCsvOperator(this.indiv_path).createIndivDataList();
		F1ETDataList F1DL = new IndivCsvOperator(this.indiv_path).createF1ETList();
		ActivityDataList ADL = new ActivityCsvOperator(this.activity_path).createActivityDataList();
		//融合リストを作成
		UnionData UD = new UnionData(IDL, F1DL, ADL);
		UD.createUnionedList();
		return UD.getUnionedDataList();
	}
	
	
	private void setExcelComponent() throws Exception {
		this.Wb = new XSSFWorkbook();
		this.Ws = this.Wb.createSheet(new ExportExcel(this.getUnionedDataList()).createSheetName());
	}
	
	
	private UnionedDataList setEachCode(UnionedDataList Udl) throws JsonParseException, JsonMappingException, IOException {
		/*
		 * 農場コード、種雄牛コード, 移植師コードを作成
		 */
		for (UnionedData elem: Udl.getUnionedDataList()) {
			new FarmCodeExchanger().setHayashiFarmCode(elem);
			new BullCodeExchanger().getBullCode(elem);
			new TechnitianExchanger().getTechCode(elem);
		}
		return Udl;
	}

	
	@Test
	public void testExportExcel() throws Exception {
		/*
		 * エクセルが出力されるか確認するテスト
		 */
		UnionedDataList Udl = this.getUnionedDataList();
		ExportExcel Ee = new ExportExcel(Udl);
		System.out.println(Ee.createSheetName());
	}
	

	@Test
	public void testSetSheetHeader() throws Exception {
		/*
		 * エクセルのヘッダーが出力されるか確認するテスト
		 */
		this.setExcelComponent();
		ExportExcel Ee = new ExportExcel(this.setEachCode(this.getUnionedDataList()));
		Ee.setSheetHeader(this.Ws);
		Ee.setHeaderStyle(this.Wb, this.Ws);
	    FileOutputStream out = new FileOutputStream("src/test/resources/exporttest/SheetHeaderTest.xlsx");
	    this.Wb.write(out);
	}
	
	
	@Test
	public void testSheetContent() throws Exception{
		/*
		 * エクセルの中身が作成されるかテストする
		 */
		this.setExcelComponent();
		ExportExcel Ee = new ExportExcel(this.setEachCode(this.getUnionedDataList()));
		Ee.setSheetContent(this.Ws);
		Ee.setSheetContentStyle(this.Wb, this.Ws);
	    FileOutputStream out = new FileOutputStream("src/test/resources/exporttest/SheetContentTest.xlsx");
	    this.Wb.write(out);
	}
	

	@Test
	public void testCompleteSheet() throws Exception{
		/*
		 * エクセルの中身が作成されるかテストする
		 */
		this.setExcelComponent();
		ExportExcel Ee = new ExportExcel(this.setEachCode(this.getUnionedDataList()));
		Ee.setSheetHeader(this.Ws);
		Ee.setHeaderStyle(this.Wb, this.Ws);
		Ee.setSheetContent(this.Ws);
		Ee.setSheetContentStyle(this.Wb, this.Ws);
	    FileOutputStream out = new FileOutputStream("src/test/resources/exporttest/CompleteSheetTest.xlsx");
	    this.Wb.write(out);
	}
	

}
