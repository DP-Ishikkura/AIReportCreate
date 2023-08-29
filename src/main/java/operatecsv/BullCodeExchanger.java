//package
package operatecsv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import operatecsv.dataholder.UnionedData;


public class BullCodeExchanger {
	/*
	 * 種雄牛名から種雄牛コードへの変更を担当するクラス
	 */
//	UnionedDataList UD_List;		//結合データ
//	public BullCodeExchanger(UnionedDataList UD_List) {
//		this.UD_List = UD_List;
//	}
	
	
	private boolean checkSeedType(UnionedData ud, String regex) {
		/*
		 * 種の種類を調べるメソッド
		 */
		String bull_name = ud.getBullName();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bull_name);
        boolean result = matcher.find() == true? true:false;
        return result;
	}
	

	private boolean checkSeedType(String bull_name, String regex) {
		/*
		 * 種の種類を調べるメソッド
		 */
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bull_name);
        boolean result = matcher.find() == true? true:false;
        return result;
	}
	
	
	private String getSemenLabel(UnionedData ud) {
		/*
		 * 精液ラベル番号を取得するメソッド
		 */
		String bull_name = ud.getBullName();
        Pattern pattern = Pattern.compile("_(.*)_");
        Matcher matcher = pattern.matcher(bull_name);
        //ラベル番号を取得する、失敗したら空文字を返す
        String result = matcher.find() == true? matcher.group(1): "";
        return result;
	}
	
	
    private boolean isHolsteinSemen(UnionedData ud) {
        /**ホルスタイン精液か確認するメソッド */
        String regex = "\\[ホ雌\\]|\\[ホ普\\]";
        return this.checkSeedType(ud, regex);
    }


    private boolean isWagyuSemen(UnionedData ud) {
        /**ホルスタイン精液か確認するメソッド */
        String regex = "\\[和雌\\]|\\[和普\\]|\\[和雄\\]";
        return this.checkSeedType(ud, regex);
    }


    private boolean isF1Egg(UnionedData ud) {
        /**F1受精卵か確認するメソッド */
        String regex = "\\[F1卵\\]|\\[F1\\]|F1受精卵";
        return this.checkSeedType(ud, regex);
    }

    
    public boolean isF1Egg(String bull_name) {
        /**F1受精卵か確認するメソッド */
        String regthis = "\\[F1卵\\]|\\[F1\\]|F1受精卵";
        return this.checkSeedType(bull_name, regthis);
    }

    
    private boolean isHolsteinEgg(UnionedData ud) {
        /**F1受精卵か確認するメソッド */
        String regex = "\\[ホ卵\\]|ホル受精卵";
        return this.checkSeedType(ud, regex);
    }


    private boolean isWagyuEgg(UnionedData ud) {
        /**和牛受精卵か確認するメソッド */
        String regex = "\\[和卵\\]|黒毛受精卵";
        return this.checkSeedType(ud, regex);
    }

    
    public void getBullCode(UnionedData ud) {
    	/*
    	 * 種雄牛コードを取得するメソッド
    	 */
    	String result = "";
    	
    	if (this.isHolsteinSemen(ud) == true || this.isWagyuSemen(ud) == true) {
    		result = this.getSemenLabel(ud);
    	}else if (this.isWagyuEgg(ud) == true) {
    		result = "黒毛受精卵";
    	}else if (this.isF1Egg(ud) == true) {
    		result = "F1受精卵";
    	}else if (this.isHolsteinEgg(ud) == true) {
    		result = "ホル受精卵";
    	} else {
    		result = "";
    	}
    	ud.setBullCode(result);
    }
    
}
