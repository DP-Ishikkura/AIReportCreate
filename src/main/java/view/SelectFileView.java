//package
package view;

//import
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.config.baseconfig.LabelConfig;
import view.config.fileselectviewconfig.ActBtnConfig;
import view.config.fileselectviewconfig.ActivityImgConfig;
import view.config.fileselectviewconfig.CancelBtnConfig;
import view.config.fileselectviewconfig.IndivImgConfig;
import view.dataholder.ViewData;
import view.listener.SelectFileListener;




public class SelectFileView extends ViewComponentCreater implements ActionListener{
	/*
	 * ファイル選択画面の作成を担当するクラス
	 */
	//ボタンを作成する
	public JButton activity_btn = this.createImgButton(new ActivityImgConfig());	//活動履歴選択ボタン
	public JButton indiv_btn = this.createImgButton(new IndivImgConfig());			//個体リスト選択ボタン
	public JButton cancel_btn = this.createButton(new CancelBtnConfig());			//キャンセルボタン
	public JButton act_btn = this.createButton(new ActBtnConfig());					//実行ボタン
	
	
	public JPanel createTitlePanel(LabelConfig conf) {
		/*
		 * タイトルパネルを作成するメソッド
		 */
		//パネルの作成
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1E8232"));
		//ラベルの設置
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel label = this.createLabel(conf);
		panel.add(label);
		return panel;
	}
	
	
	private JPanel createBtnPanel(JButton btn, JLabel label) {
		/*
		 * タイトルパネルを作成するメソッド
		 */
		//パネルの作成
		JPanel panel = new JPanel();
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		panel.add(label, BorderLayout.NORTH);
		panel.add(btn, BorderLayout.CENTER);
		return panel;
	}
	
	
	public JPanel createSelectFilePanel() {
		/*
		 * ファイル選択パネルを作成するメソッド
		 */
		//ラベルの作成
		ViewData.indiv_path = "ファイルが選択されていません";
		ViewData.activity_path = "ファイルが選択されていません";
		//ボタンの作成
		this.indiv_btn.addActionListener(this);
		this.activity_btn.addActionListener(this);
		//イメージボタンの作成
		JPanel indiv_panel = this.createBtnPanel(this.indiv_btn, ViewData.indiv_label);
		JPanel act_panel = this.createBtnPanel(this.activity_btn, ViewData.activity_label);
		//イベントの登録
		//パネルの作成
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(1, 2);
		panel.setLayout(layout);
		//部品の設置
		panel.add(indiv_panel);
		panel.add(act_panel);
		return panel;
	}
	
	private JPanel createTemplateFooterPanel(JComponent[] comp) {
		/*
		 * フッターパネルを作成するメソッド
		 */
		//パネルを作成してレイアウトを定義する
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(1, 5);
		panel.setLayout(layout);
		panel.setBackground(Color.decode("#1E8232"));
		//ぱねるの設置
		for (int i=0; i<5; i++) {
			panel.add(comp[i]);
		}
		return panel;
	}
	
	
	public JPanel createFooterPanel() {
		/*
		 * フッターパネルを作成するメソッド
		 */
		//パネルを作成してレイアウトを定義する
		JComponent[] comp = {
				new JLabel(""), new JLabel(""),new JLabel(""),
				new JLabel(""), this.act_btn
		};
		this.act_btn.addActionListener(this);
		return this.createTemplateFooterPanel(comp);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		//個体リストの選択アクション
        if (e.getSource() == this.indiv_btn) {	
//        	new SelectFileListener().setIndivFile();
        	new SelectFileListener().setIndivFile();
        //活動履歴の選択アクション
        }else if(e.getSource() == this.activity_btn) {
        	new SelectFileListener().setActivityFile();
        //ファイルフォーマットのチェックと画面遷移
        }else if (e.getSource() == this.act_btn) {
        	new SelectFileListener().checkCorrectCsvFile();
        	if (new SelectFileListener().checkContainsFalse() == true) {
        		new StoreFileView().setWrongMsg();
        		ViewData.layout.show(ViewData.card_panel, "false");
        	}else{
//        		new StoreListener().setCorrectMsg();
        		ViewData.layout.show(ViewData.card_panel, "true");
        	}
        }
	}
}
