//package
package view.config.fileselectviewconfig;

//import
import java.awt.Font;

import view.config.baseconfig.BtnConfig;

public class CancelBtnConfig extends BtnConfig{
	/*
	 * 実行ボタンの設定に関するクラス
	 */
	private String title = "キャンセル";		//タイトル
	private String btn_color = "";	//背景色
	private String font_family = "メイリオ";	//フォントの種類
	private int font_size = 24;		//フォントサイズ
	private int font_type = Font.BOLD;		//フォントタイプ
	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return btn_color
	 */
	public String getBtnColor() {
		return btn_color;
	}
	/**
	 * @return font_family
	 */
	public String getFontFamily() {
		return font_family;
	}
	/**
	 * @return font_size
	 */
	public int getFontSize() {
		return font_size;
	}
	/**
	 * @return font_type
	 */
	public int getFontType() {
		return font_type;
	}
}
