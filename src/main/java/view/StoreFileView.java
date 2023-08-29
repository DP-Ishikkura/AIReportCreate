//package
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.config.storefileconfig.PreviousBtnConfig;
import view.config.storefileconfig.StoreBtnConfig;
import view.config.storefileconfig.WrongMsgLabelConfig;
import view.dataholder.ViewData;
import view.listener.StoreFileListener;


public class StoreFileView extends ViewComponentCreater implements ActionListener{
	/*
	 * ファイル保存画面の作成を担当するクラス
	 */
	//ボタンを作成する
	public JButton previous_btn = this.createButton(new PreviousBtnConfig());
	public JButton store_btn = this.createButton(new StoreBtnConfig());
	public static String message = "正しいファイルが選択されています";

	public static JLabel msg_label = new StoreFileView().createLabel(new WrongMsgLabelConfig(message));
	
	
	public String buildMessage() {
		/*
		 * ファイルが正しく選択されていない場合のメッセージを作成するめそっっど
		 */
		//StringBuilderを作成
		StringBuilder sb = new StringBuilder();
		//本文を作成する
		sb.append("<html><body>");
		if (ViewData.indiv_is_csv == false) {
			sb.append("個体リストがcsvファイルではありません<br>");
		}
		if(ViewData.activity_is_csv == false) {
			sb.append("活動履歴がcsvファイルではありません<br>");
		}
		if(ViewData.is_indiv_file == false) {
			sb.append("個体リストに必要な情報が含まれていません<br>");
		}
		if(ViewData.is_indiv_file == false) {
			sb.append("活動履歴に必要な情報が含まれていません<br>");
		}
		sb.append("</body></html>");
		//文字列に変換する
		String msg = sb.toString();
		return msg;
	}
	
	public void setWrongMsg() {
		/*
		 * メッセージを変更するメソッド
		 */
		String msg = this.buildMessage();
		StoreFileView.message = msg;
		StoreFileView.msg_label.setText(message);
	}
	
	
	public JPanel createMsgPanel() {
		/*
		 *メッセージパネルを作成するメソッド
		 */
//		JLabel label = this.createLabel(new MsgLabelConfig(message));
		//メッセージパネルの作成とレイアウトの定義
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		panel.setLayout(layout);
		panel.add(msg_label);
		return panel;
	}
	
	public JPanel createCorrectMsgPanel() {
		/*
		 *メッセージパネルを作成するメソッド
		 */
		JLabel label = this.createLabel(new WrongMsgLabelConfig("正しいファイルが選択されています"));
		//メッセージパネルの作成とレイアウトの定義
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		panel.setLayout(layout);
		panel.add(label);
		return panel;
	}
	
	
	
	public JPanel createFooterPanel(JComponent[] Comp) {
		/*
		 * フッターを作成するを作成するメソッド
		 */
		//パネルを作成してレイアウトを定義する
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(1, 5);
		panel.setLayout(layout);
		panel.setBackground(Color.decode("#1E8232"));
		//ぱねるの設置
		for (JComponent elem: Comp) {
			panel.add(elem);
		}
		return panel;
	}
	
	
	public JPanel createTrueFooterPanel() {
		/*
		 * フッターを作成するを作成するメソッド
		 */
		//ボタンとイベントの作成
		//部品の作成
		JComponent[] Comp = new JComponent[]{
			new JLabel(""), new JLabel(""), new JLabel(""), 
			this.previous_btn, this.store_btn
		};
		this.previous_btn.addActionListener(this);
		this.store_btn.addActionListener(this);
		return this.createFooterPanel(Comp);
	}
	
	
	public JPanel createFalseFooterPanel() {
		/*
		 * フッターを作成するを作成するメソッド
		 */
		//ボタンとイベントの作成
		JComponent[] Comp = new JComponent[]{
			new JLabel(""), new JLabel(""), new JLabel(""), 
			new JLabel(""), this.previous_btn
		};
		this.previous_btn.addActionListener(this);
		return this.createFooterPanel(Comp);
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * イベント誘起
		 */
		if (e.getSource() == this.previous_btn) {
			ViewData.layout.show(ViewData.card_panel, "select");
		}else if(e.getSource() == this.store_btn) {
			try {
				new StoreFileListener().storeUnionedData();
				ViewData.layout.show(ViewData.card_panel, "finished");
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
//				ViewData.layout.show(ViewData.card_panel, "error");
				e1.printStackTrace();
			}
		}
	}
}


