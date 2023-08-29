package view.config.msgviewconfig;

import java.awt.Font;

import view.config.baseconfig.LabelConfig;

public class FinishedLabelConfig extends LabelConfig{
	private String title = "<html><body>ファイル作成が完了しました。<br>終了するか戻るボタンを押してください。</body></html>";
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
