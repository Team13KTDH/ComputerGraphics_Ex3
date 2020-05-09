package Ex3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import javax.swing.JPanel;

public class Surface extends JPanel {
	// toa do diem X(a,b), Y(c,d)
	public int a;
	public int b;
	public int c;
	public int d;
	public int index;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.GREEN);
		this.setBounds(600, 0, 750, 750);
		Graphics2D g2d = (Graphics2D) g;
		Axis(g2d);
		doDrawing(g2d);
	}

	// ham ve thi ta ve vao day
	public Surface() {
		this.index = -1;
	}

	public void doDrawing(Graphics2D g2d) {
		// ham chuc nang
		Axis(g2d);
		if (index == 0) {
			// circleDraw(g2d)
		}
	}

	// ham ve toa do
	public void Axis(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 0; i <= 80; i++) {
			g2d.drawLine(15 * i, 0, 15 * i, 750);// moi don vi la 15pixel
			g2d.drawLine(0, 15 * i, 750, 15 * i);
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, 375, 750, 375);
		g2d.drawLine(375, 0, 375, 750);
	}

	// ham ve dda1 (Net Dut)
	public void dDA1(Graphics2D g2d) {
		{
			int temp;

			if (abs(c - a) > abs(d - b)) {
				if (a > c) {
					temp = a;
					a = c;
					c = temp;
					temp = b;
					b = d;
					d = temp;
				}
				int x = a;
				float y = b;
				float m = (float) (d - b) / (float) (c - a);
				int count = 0;
				while (x <= c) {
					y = y + m;
					if (count >= 8 && count <= 14) {
						x++;
						if (count == 14) {
							count = 0;
							continue;
						}
						count++;
						continue;
					}
					g2d.setColor(Color.BLACK);
					g2d.setStroke(new BasicStroke(5));
					g2d.drawLine(x, Math.round(y), x, Math.round(y));
					x++;
					count++;
				}
			}
			if (a == c && b == d) {
				g2d.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(5));
				g2d.drawLine(a, b, a, b);
			} else {
				if (b > d) {
					temp = a;
					a = c;
					c = temp;
					temp = b;
					b = d;
					d = temp;
				}
				float x = a;
				int y = b;
				float m = (float) (c - a) / (float) (d - b);
				int count = 0;
				while (y <= d) {
					x = x + m;
					if (count >= 8 && count <= 14) {
						y++;
						if (count == 14) {
							count = 0;
							continue;
						}
						count++;
						continue;
					}
					g2d.setColor(Color.BLACK);
					g2d.setStroke(new BasicStroke(5));
					g2d.drawLine(Math.round(x), y, Math.round(x), y);
					y++;
					count++;
				}
			}

		}
		// ve toa do X, Y
		int x1 = Math.round(a / 15);
		int y1 = Math.round(b / 15);
		int x2 = Math.round(c / 15);
		int y2 = Math.round(d / 15);
		x1 = x1 - 25;
		x2 = x2 - 25;
		y1 = 25 - y1;
		y2 = 25 - y2;
		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("", Font.BOLD, 20));
		g2d.drawString("(" + x1 + "," + y1 + ")", a, b + 30);
		g2d.drawString("(" + x2 + "," + y2 + ")", c, d + 30);
	}

	// ve Duong Thang
	public void duongthang(Graphics2D g2d, int x1, int y1, int x2, int y2) {
		int dx, dy;
		int xet = 1;
		float Xinc, Yinc, x, y, steps;
		int tamx, tamy;
		// MidpointLine(g2d,c,d,c-45,d+30);

		if (x1 > x2 || y1 > y2) {
			tamx = x1;
			x1 = x2;
			x2 = tamx;
			tamy = y1;
			y1 = y2;
			y2 = tamy;
		}

		dy = y2 - y1;
		dx = x2 - x1;

		if (dy > dx) {
			steps = Math.abs(dy);
		} else {
			steps = Math.abs(dx);
		}
		x = x1;
		y = y1;
		Yinc = dy / steps;
		Xinc = dx / steps;

		while (steps != 0) {
			if (xet % 2 != 0) {
				// net gach
				for (int i = 0; i < 15; i++) {
					steps--;
					x = x + Xinc;
					y = y + Yinc;
					g2d.setColor(Color.BLUE);
					g2d.fillOval(Math.round(x), Math.round(y), 5, 5);
				}
			}
			xet++;
		}
	}
}
