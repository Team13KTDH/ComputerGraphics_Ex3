package Ex3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

	Surface sf = new Surface();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JButton bt1 = new JButton();
	JButton bt2 = new JButton();
	JButton bt3 = new JButton();
	JButton bt4 = new JButton();
	JButton bt0 = new JButton();

	// ham khoi tao
	public MainFrame() {
		// ham khoi tao cac gia tri do hoa
		initUI();
	}

	public void initUI() {
		this.setSize(1520, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ex3 - NHOM 13");

		// o trong nhap so lieu

		tf2.setBounds(140, 110, 100, 40);
		tf2.setFocusable(true);
		tf2.setText("");
		tf2.setEditable(true);

		label2.setBounds(20, 110, 150, 40);
		label2.setEnabled(false);
		label2.setText("Ban Kinh R: ");
		label2.setFont(new Font("Ink Free", Font.BOLD, 20));
		
		label3.setBounds(50, 600, 150, 40);
		label3.setEnabled(false);
		label3.setText("Limit: R <= 70 ");
		label3.setFont(new Font("Ink Free", Font.BOLD, 20));

		// nut thu nhat
		bt0.setText("DRAW!");
		bt0.setBounds(70, 200, 150, 100);
		bt0.setBorder(BorderFactory.createBevelBorder(1));
		bt0.setFocusable(false);
		bt0.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));
		bt0.setMnemonic(KeyEvent.VK_ENTER);
		this.getRootPane().setDefaultButton(bt0);
		

		label6.setBounds(50, 640, 600, 40);
		label6.setEnabled(false);
		label6.setText("NOTE!!! 5 pixels/square  ");
		label6.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 20));

		this.add(label2);
		this.add(tf2);
		this.add(label6);
		this.add(label3);
		// nut0
		this.add(bt0);
		bt0.setActionCommand("DRAW!");
		bt0.addActionListener(this);

		// add Panel
		this.add(sf);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			sf.index = 0;
			xuLy();
			break;
		}
	}

	public void xuLy() {
		try {
			int r = Integer.parseInt(tf2.getText());
			if (r <= 70) {
				sf.R = r;
				System.out.print(sf.R);
				sf.repaint();
			} else {
				String message = "Vui long nhap dung dinh dang! ";
				JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception q) {
			String message = "Vui long nhap dung dinh dang! ";
			JOptionPane.showMessageDialog(new JFrame(), message, "Canh bao", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("DRAW!".equals(e.getActionCommand()) ) {
			sf.index = 0;
			xuLy();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MainFrame mainframe = new MainFrame();
				mainframe.setVisible(true);
			}
		});
	}
}