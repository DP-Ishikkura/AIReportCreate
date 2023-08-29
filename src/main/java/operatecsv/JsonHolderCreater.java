package operatecsv;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import operatecsv.jsondataholder.FarmCodeData;
import operatecsv.jsondataholder.TechnitianData;

public class JsonHolderCreater {
	/*
	 * Jsonファイルの情報からのJavaオブジェクト作成を担当するクラス
	 */
//	private String farmdata_path = "src/main/resources/ReportCode/FarmCode.json";
//	private String techdata_path = "src/main/resources/ReportCode/Technitian.json";
	
	
	public FarmCodeData createFarmCodeHolder() throws JsonParseException, JsonMappingException, IOException {
		/*
		 * 農場データJsonをオブジェクトに代入するメソッド
		 */
//		ObjectMapper mapper= new ObjectMapper();
//		FarmCodeData holder= mapper.readValue(new File(this.getFarmDataPath()), FarmCodeData.class);
		FarmCodeData holder = new FarmCodeData().getFarmCodeData();
		return holder;
	}
	

	public TechnitianData createTechCodeHolder() throws JsonParseException, JsonMappingException, IOException {
		/*
		 * 技術者データJsonをオブジェクトに代入するメソッド
		 */
//		ObjectMapper mapper= new ObjectMapper();
//		TechnitianData holder= mapper.readValue(new File(getTechDataPath()), TechnitianData.class);
		TechnitianData holder = new TechnitianData().getTechnitianData();
		return holder;
	}
}
