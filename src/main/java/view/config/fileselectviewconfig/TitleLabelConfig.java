//package
package view.config.fileselectviewconfig;

//import 
import java.awt.Font;

import view.config.baseconfig.LabelConfig;




public class TitleLabelConfig extends LabelConfig{
	/*
	 * タイトルラベルの設定を行うクラス
	 */
	private String title = "人工授精報告カード作成システム";
	private int font_size = 30;
	private String font_family = "メイリオ";
	private int font_type = Font.BOLD;
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return font_size
	 */
	public int getFontSize() {
		return font_size;
	}
	/**
	 * @param font_size セットする font_size
	 */
	public void setFontSize(int font_size) {
		this.font_size = font_size;
	}
	/**
	 * @return font_family
	 */
	public String getFontFamily() {
		return font_family;
	}
	/**
	 * @return font_type
	 */
	public int getFontType() {
		return font_type;
	}
}
