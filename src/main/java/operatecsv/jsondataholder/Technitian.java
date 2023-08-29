package operatecsv.jsondataholder;

public class Technitian {
	/*
	 * 授精師データを格納するクラス
	 */
	public String name;		//授精師名
	public String code;		//授精師コード
	public boolean ai;		//AI免許有無
	public boolean et;		//ET免許有無
	
	public Technitian(String name, String code, boolean ai, boolean et) {
		this.name = name;
		this.code = code;
		this.ai = ai;
		this.et = et;
 	}

}
