import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Particle {
	
	Random r = new Random();
	
	
	double dx,dy,x,y;
	int radius = 10;
	int f = r.nextInt(255);
	int ss = r.nextInt(215) + 40;
	int alpha = r.nextInt(255);
	
	public Particle(int xx) {
		x = xx;
		y = Test.height;
		dx = 0.7 - r.nextDouble()*1.4;
		dy = -2.5 + r.nextDouble()*1.5;
				
	}
	
	public void update() {
		x += dx;
		y += dy;
		if(alpha >= 0) alpha -= r.nextInt(3);
	}
	
	public void show(Graphics g) {
		g.setColor(new Color(f, ss - 40, ss - 40, alpha));
		g.fillRect( (int)x, (int)y, radius*2, radius*2);
	}
	
	public int getAlpha() {
		return alpha;
	}

}
