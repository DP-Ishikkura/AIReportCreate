//package
package view.dataholder;

//import
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ViewData {
	/*
	 * 画面のデータを保存するクラス
	 */
	
	//ファイルパスとファイル名を保存するためのフィールド
	public static String indiv_path ;
	public static String activity_path;	
	public static JLabel indiv_label = new JLabel();
	public static JLabel activity_label = new JLabel() ;
	//保存先選択画面に関する設定
	public static String store_path = "保存先が選択されていません";
	
	//ファイルのチェック
	//csvファイルであるか確認
	public static boolean indiv_is_csv = false;
	public static boolean activity_is_csv = false;
	//ファイルの形式が正し形式か確認
	public static boolean is_indiv_file = false;
	public static boolean is_activity_file = false;
	
	//画面遷移
	public static JPanel card_panel ;
	public static CardLayout layout = new CardLayout();
}

