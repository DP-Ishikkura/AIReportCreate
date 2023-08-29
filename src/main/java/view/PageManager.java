//package
package view;

//import
import java.awt.BorderLayout;

import javax.swing.JPanel;

import view.dataholder.ViewData;

public class PageManager{
	/*
	 * ページ遷移を担当するクラス
	 */
	private SelectFileView SelectView = new SelectFileView();
//	//レイアウトとパネル
//	public JPanel card_panel;
//	public  CardLayout card_layout;
	
	
	private JPanel designTemplatePanel(JPanel content_p, JPanel footer_p) {
		/*
		 * テンプレートパネルを作成するメソッド
		 */
		//パネルのレイアウト
		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		//部品の配置
		panel.add(content_p, BorderLayout.CENTER);
		panel.add(footer_p, BorderLayout.SOUTH);
		return panel;
	}
	
	
	public JPanel designSelectFilePanel() {
		/*
		 * ファイル選択パネルを取得するメソッド
		 */
		//部品を作成する
		JPanel contetn_p = SelectView.createSelectFilePanel();
		JPanel footer_p = SelectView.createFooterPanel();
		//パネルの作成
		return this.designTemplatePanel(contetn_p, footer_p);
		
	}

	public JPanel designTrueMsgPanel() {
		/*
		 * ファイル選択画面を作成するメソッド
		 */
		//ページの部品を作成する
		JPanel file_panel = new StoreFileView().createCorrectMsgPanel();
		JPanel footer_panel = new StoreFileView().createTrueFooterPanel();
		//パネルのレイアウト
		return this.designTemplatePanel(file_panel, footer_panel);
	}
	
	
	public JPanel designFalseMsgPanel() {
		/*
		 * ファイル選択画面を作成するメソッド
		 */
		//ページの部品を作成する
		JPanel file_panel = new StoreFileView().createMsgPanel();
		JPanel footer_panel = new StoreFileView().createFalseFooterPanel();
		//パネルのレイアウト
		return this.designTemplatePanel(file_panel, footer_panel);
	}
	
	
	public JPanel designErrorPanel() {
		/*
		 * エラー画面を作成するメソッド
		 */
		JPanel msg_panel = new ErrorView().createMsgPanel();
		JPanel footer_panel = new ErrorView().createFooterPanel();
		//パネルのレイアウト
		return this.designTemplatePanel(msg_panel, footer_panel);
	}
	
	public JPanel designFinishedPanel() {
		/*
		 * エラー画面を作成するメソッド
		 */
		JPanel msg_panel = new FinishedView().createMsgPanel();
		JPanel footer_panel = new  FinishedView().createFooterPanel();
		//パネルのレイアウト
		return this.designTemplatePanel(msg_panel, footer_panel);
	}
	
	
	

	
	
	
	public void designComplexPanel() {
		/*
		 * 遷移用のパネルを作成するメソッド
		 */
		//部品の作成
		JPanel select_panel = this.designSelectFilePanel();
		JPanel true_panel = this.designTrueMsgPanel();
		JPanel false_panel = this.designFalseMsgPanel();
		JPanel error_panel = this.designErrorPanel();
		JPanel finished_panel = this.designFinishedPanel();
		//レイアウトの定義
		JPanel panel = new JPanel();
		panel.setLayout(ViewData.layout);
		//部品の配置
		panel.add(select_panel, "select");
		panel.add(true_panel, "true");
		panel.add(false_panel, "false");
		panel.add(error_panel, "error");
		panel.add(finished_panel, "finished");
		ViewData.card_panel = panel;
	}
}
