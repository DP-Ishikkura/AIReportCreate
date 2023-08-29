import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import view.PageManager;
import view.dataholder.ViewData;




public class Main extends JFrame{

	public static void main(String[] args) throws IOException {
		////フレームを作成
		JFrame frame = new JFrame("人工授精報告カード作成システム");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//アイコンの設定
		ClassLoader cl = new Main().getClass().getClassLoader();
        ImageIcon image_icon = new ImageIcon(cl.getResource("icon.png"));
        Image image = image_icon.getImage();
        frame.setIconImage(image);
		//部品の設置
		Container contentPane = frame.getContentPane();
		//画面の作成
		new PageManager().designComplexPanel();
		contentPane.add(ViewData.card_panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
}
