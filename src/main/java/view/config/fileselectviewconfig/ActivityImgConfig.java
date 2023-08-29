//package
package view.config.fileselectviewconfig;

//import
import view.config.baseconfig.ImgConfig;





public class ActivityImgConfig extends ImgConfig{
	/*
	 * 個体リストアップアナウンスの画像を設定するクラス
	 */
	private String file_path = "ActivityImg.png";		//ファイルパス
	private int height = 200;			//画像の高さ
	private int width = 200;			//画像の幅

	public String getFilePath() {
		return file_path;
	}
	/**
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
}