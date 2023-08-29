package view.config.storefileconfig;

import java.awt.Font;

import view.config.baseconfig.LabelConfig;

public class WrongMsgLabelConfig extends LabelConfig{
	/*
	 * ファイルが誤りの場合のラベルの設定を行うクラス
	 */
	private String title ;
	private int font_size = 20;
	private String font_family = "メイリオ";
	private int font_type = Font.BOLD;
	public WrongMsgLabelConfig(String msg) {
		this.title = msg;
	}
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
