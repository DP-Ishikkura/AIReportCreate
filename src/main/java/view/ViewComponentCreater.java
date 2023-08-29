//package
package view;

//import
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.config.baseconfig.BtnConfig;
import view.config.baseconfig.ImgConfig;
import view.config.baseconfig.LabelConfig;





public class ViewComponentCreater {
	/*
	 * GUI画面の基本部成作成を担当するクラス
	 */
	
	
	public JLabel createLabel(LabelConfig conf) {
		/*
		 * タイトルパネルを作成するメソッド
		 */
		//ラベルの作成
		JLabel label = new JLabel(conf.getTitle());
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font(
				conf.getFontFamily(), 
				conf.getFontType(), 
				conf.getFontSize()
				));
		return label;
	}
	
	
	public JButton createButton(BtnConfig conf) {
		/*
		 * ボタンを作成するメソッド
		 */
		JButton btn = new JButton(conf.getTitle());
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setBackground(Color.decode("#ffffff"));
//        btn.setBackground(Color.decode(conf.getBtnColor()));
        btn.setFont(
        		new Font(conf.getFontFamily(), 
        				conf.getFontType(), 
        				conf.getFontSize()
        				)
        		);
        return btn;
	}
	
	
	public JButton createImgButton(ImgConfig conf) {
		/*
		 * 画像付きのボタンを作成するメソッド
		 */
		//画像の作成とサイズの設定
		ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon image_icon = new ImageIcon(cl.getResource(conf.getFilePath()));
        Image image = image_icon.getImage();
        image = image.getScaledInstance(conf.getWidth(), conf.getHeight(), java.awt.Image.SCALE_SMOOTH);
        image = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        //ボタンの作成
        JButton btn = new JButton();
        btn.setIcon(icon);
        return btn;
	}
	
}
