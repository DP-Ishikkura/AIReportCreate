//package
package view.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;

import operatecsv.inputcsv.ActivityCsvOperator;
import operatecsv.inputcsv.BaseCsvInput;
import operatecsv.inputcsv.IndivCsvOperator;
import view.dataholder.ViewData;

public class SelectFileListener{
	/*
	 * ファイル選択画面のイベントを管理するためのクラス
	 */
	public void setIndivFile() {
		/*
		 * 個体リストを選択するメソッド
		 */
		//ファイル選択ダイアログを開く
        JFileChooser filechooser = new JFileChooser();
        int selected = filechooser.showOpenDialog(null);
        //開くが選択された時の処理
        if (selected == JFileChooser.APPROVE_OPTION){
        	File file = filechooser.getSelectedFile();
        	ViewData.indiv_path = file.getAbsolutePath();
        	ViewData.indiv_label.setText(new File(ViewData.indiv_path).getName());
        }
	}
	
	public void setActivityFile() {
		/*
		 * 個体リストを選択するメソッド
		 */
		//ファイル選択ダイアログを開く
        JFileChooser filechooser = new JFileChooser();
        int selected = filechooser.showOpenDialog(null);
        //開くが選択された時の処理
        if (selected == JFileChooser.APPROVE_OPTION){
        	File file = filechooser.getSelectedFile();
        	ViewData.activity_path = file.getAbsolutePath();
        	ViewData.activity_label.setText(new File(ViewData.activity_path).getName());
        }
	}
	
	
	public boolean checkContainsFalse() {
		/*
		 * 正しいファイルが選択されているか調べるメソッド
		 * 含まれている場合はtrueを返す
		 */
		boolean result = false;
		List<Boolean> check_list = new ArrayList<Boolean>(Arrays.asList(
				ViewData.indiv_is_csv, ViewData.activity_is_csv,
				ViewData.is_indiv_file, ViewData.is_activity_file
				));
		result = check_list.contains(false);
		return result;
	}
	
	

	
	
	private void checkCsvFile() {
		/*
		 * csvファイルか確認するための処理
		 */
		if (BaseCsvInput.isCsv(ViewData.indiv_path) == true) {
			ViewData.indiv_is_csv = true;	//個体リストがcsvか確認
		}
		if (BaseCsvInput.isCsv(ViewData.activity_path) == true) {
			ViewData.activity_is_csv = true;	//個体リストがcsvか確認
		}
	}
	
	
	private void checkIndivFileFormat() throws Exception{
		/*
		 * 選択されたファイルが個体リストのフォーマットに合致しているか確認するメソッド
		 */
		BaseCsvInput Ope = new IndivCsvOperator(ViewData.indiv_path);
		ViewData.is_indiv_file = Ope.isCorrectFileFormat() == true? true: false;
	}
	
	
	private void checkActivityFileFormat() throws Exception{
		/*
		 * 選択されたファイルが個体リストのフォーマットに合致しているか確認するメソッド
		 */
		BaseCsvInput Ope = new ActivityCsvOperator(ViewData.activity_path);
		ViewData.is_activity_file = Ope.isCorrectFileFormat() == true? true: false;
	}
	
	
	public void checkCorrectCsvFile() {
		/*
		 * csvかつ正しいフォーマットであるか調べるメソッド
		 */
		this.checkCsvFile();
    	//個体リストが適切な形のcsvであるか調べる
    	try {
			this.checkIndivFileFormat();
		} catch (Exception e1) {
			ViewData.is_indiv_file = false;
		}
    	//活動履歴が適切な形のcsvであるか調べる
    	try {
			this.checkActivityFileFormat();
		} catch (Exception e1) {
			ViewData.is_activity_file = false;
		}
		
	}
//	
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		/*
//		 *ボタンが押された際の処理
//		 */
//        SelectFileView view = new SelectFileView();
//        if (e.getSource() == view.indiv_btn) {	//個体リスト選択時の処理
//        	this.setIndivFile();
//        }else if(e.getSource() == view.activity_btn) {
//        	this.setActivityFile();
//        }
//	}
}
