package Ex3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		// ham khoi tao cac gia trido hoa
		initUI();
	}

	public void initUI() {
		this.setSize(1520, 820);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ex3 - NHOM 13");

		// o trong nhap so lieu
		tf1.setBounds(140, 50, 100, 40);
		tf1.setFocusable(true);
		tf1.setText("");
		tf1.setEditable(true);

		tf2.setBounds(140, 110, 100, 40);
		tf2.setFocusable(true);
		tf2.setText("");
		tf2.setEditable(true);

		label1.setBounds(20, 50, 150, 40);
		label1.setEnabled(false);
		label1.setText("Tam O: ");
		label1.setFont(new Font("Ink Free", Font.BOLD, 20));

		label2.setBounds(20, 110, 150, 40);
		label2.setEnabled(false);
		label2.setText("Ban Kinh R: ");
		label2.setFont(new Font("Ink Free", Font.BOLD, 20));

		// nut thu nhat
		bt0.setText("DRAW!");
		bt0.setBounds(70, 200, 150, 100);
		bt0.setBorder(BorderFactory.createBevelBorder(1));
		bt0.setFocusable(false);
		bt0.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 16));

		label6.setBounds(50, 640, 600, 40);
		label6.setEnabled(false);
		label6.setText("NOTE!!! 15 pixels/square  ");
		label6.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 20));

		this.add(label2);
		this.add(label1);

		this.add(tf2);
		this.add(tf1);
		
		this.add(label6);
		// nut0
		this.add(bt0);
		bt0.setActionCommand("DRAW!");
		bt0.addActionListener(this);

		// add Panel
		this.add(sf);
	}

	public void xuLy() {
		try {
			int a = Integer.parseInt(tf1.getText()) * 15;
			int b = Integer.parseInt(tf2.getText()) * 15;
			int c = Integer.parseInt(tf3.getText()) * 15;
			int d = Integer.parseInt(tf4.getText()) * 15;

			if (a >= -375 && a <= 375 && b >= -375 && b <= 375 && c >= -375 && c <= 375 && d >= -375 && d <= 375) {
				if (a <= 0)
					a = 375 + a;
				else
					a = 375 + a;
				if (b <= 0)
					b = 375 - b;
				else
					b = 375 - b;
				if (c <= 0)
					c = 375 + c;
				else
					c = 375 + c;
				if (d <= 0)
					d = 375 - d;
				else
					d = 375 - d;
				sf.a = a;
				sf.b = b;
				sf.c = c;
				sf.d = d;
				System.out.println(sf.a);
				System.out.println(sf.b);
				System.out.println(sf.c);
				System.out.println(sf.d);
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
		if ("gach noi".equals(e.getActionCommand())) {
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