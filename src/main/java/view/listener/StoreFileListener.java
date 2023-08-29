package view.listener;

import java.io.File;

import javax.swing.JFileChooser;

import operatecsv.dataholder.UnionedDataList;
import view.dataholder.ViewData;
import writeexcel.ExcelContentCreater;
import writeexcel.ExportExcel;

public class StoreFileListener{
	/*
	 * ファイル作成と保存に関するリスナー
	 */
	
	public String setStoreDir() {
		/*
		 * フォルダ選択するメソッド
		 */
		//フォルダ選択ダイアログを開く
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int selected = filechooser.showSaveDialog(null);
        //
        String result = "";
      //開くが選択された時の処理
        if (selected == JFileChooser.APPROVE_OPTION){
        	File file = filechooser.getSelectedFile();
        	ViewData.store_path = file.getAbsolutePath();
        	result = file.getAbsolutePath();
        }
        return result;
	}
	
	
	public void storeUnionedData() throws Exception {
		/*
		 * データを書き込み保存するメソッド
		 */
		ExcelContentCreater Ecc = new ExcelContentCreater(ViewData.indiv_path, ViewData.activity_path);
		UnionedDataList for_excel_data = Ecc.createForExcelData();
		this.setStoreDir();
		new ExportExcel(for_excel_data).writeExcel(ViewData.store_path);
	}
	
	
	public void storeUnionedData(String file_path) throws Exception {
		/*
		 * データを書き込み保存するメソッド
		 */
		ExcelContentCreater Ecc = new ExcelContentCreater(ViewData.indiv_path, ViewData.activity_path);
		UnionedDataList for_excel_data = Ecc.createForExcelData();
		this.setStoreDir();
		new ExportExcel(for_excel_data).writeExcel(file_path);
	}
}
