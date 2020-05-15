package Ex3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.abs;
import javax.swing.JPanel;

public class Surface extends JPanel {
	// toa do
	int R;
	int index;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		this.setBackground(Color.YELLOW);
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
			drawCircle(g2d, R);
		}
	}

	// ham ve toa do
	public void Axis(Graphics2D g2d) {
		g2d.setColor(Color.GRAY);
		g2d.setStroke(new BasicStroke(1));
		for (int i = 0; i <= 150; i++) {
			g2d.drawLine(5 * i, 0, 5 * i, 750);// moi don vi la 15pixel
			g2d.drawLine(0, 5 * i, 750, 5 * i);
		}
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawLine(0, 375, 750, 375);// truc ngang
		g2d.drawLine(375, 0, 375, 750);// truc doc
	}

	// Ve 8 diem doi xung
	void Put8Pixel(Graphics2D g2d, int x, int y) {
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.BLUE);

		y = 375 - y * 5;
		x = 375 - x * 5;
		g2d.drawLine(375, 375, 375, 375);
		g2d.drawLine(x, y, x, y);
		g2d.drawLine(y, x, y, x);
		g2d.drawLine(x, 750 - y, x, 750 - y);
		g2d.drawLine(750 - y, x, 750 - y, x);
		g2d.drawLine(750 - y, 750 - x, 750 - y, 750 - x);
		g2d.drawLine(750 - x, 750 - y, 750 - x, 750 - y);
		g2d.drawLine(750 - x, y, 750 - x, y);
		g2d.drawLine(y, 750 - x, y, 750 - x);
	}

	public void drawCircle(Graphics2D g2d, int R) {
		float p;
		int d = 0;
		int x = 0, y = R;
		Put8Pixel(g2d, x, y);
		p = 5/4 - R;
		while (x < y) {
			if (p < 0)
				p += 2 * x + 3;
			else {
				p += 2 * (x - y) + 5;
				y--;
			}
			x++;
			if (d % 13 != 0)
				Put8Pixel(g2d, x, y);
			d++;
		}
	}
}
