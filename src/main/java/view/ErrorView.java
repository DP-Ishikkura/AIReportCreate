package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.config.msgviewconfig.ErrorLabelConfig;
import view.config.storefileconfig.PreviousBtnConfig;
import view.dataholder.ViewData;

public class ErrorView extends ViewComponentCreater implements ActionListener {
	//ボタンを作成する
	public JButton previous_btn = this.createButton(new PreviousBtnConfig());
	
	
	public JPanel createMsgPanel() {
		/*
		 *メッセージパネルを作成するメソッド
		 */
		JLabel label = this.createLabel(new ErrorLabelConfig());
		//メッセージパネルの作成とレイアウトの定義
		JPanel panel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		panel.setLayout(layout);
		panel.add(label);
		return panel;
	}
	
	
	public JPanel createFooterPanel() {
		/*
		 * フッターパネルを作成するメソッド
		 */
		//ボタンとイベントの作成
		JComponent[] Comp = new JComponent[]{
			new JLabel(""), new JLabel(""), new JLabel(""), 
			new JLabel(""), this.previous_btn
		};
		this.previous_btn.addActionListener(this);
		return new StoreFileView().createFooterPanel(Comp);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * イベント誘起
		 */
		if (e.getSource() == this.previous_btn) {
			ViewData.layout.show(ViewData.card_panel, "select");
		}
	}
}
