import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test extends JPanel implements ActionListener{
	
	Timer ti = new Timer(8,this);
	LinkedList<Particle> particles = new LinkedList<Particle>();
	
	static int particleMul = 1;
	static int width = 600;
	static int height = 600;

	public static void main(String[] args) {
		Test t = new Test();
		JFrame f = new JFrame();
		t.setPreferredSize(new Dimension(width, height));
		f.getContentPane().add(t);
		f.pack();
		f.setTitle("Smoke");
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setBackground(new Color(15,15,17));
		for(int i = particles.size() - 1; i > 0; i--) {
			particles.get(i).show(g);
		}
		
		ti.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < particleMul; i++) {
			Particle p = new Particle(width/2 - 50);
			Particle s = new Particle(width/2 + 50);
			Particle n = new Particle(width/2 + 150);
			Particle l = new Particle(width/2 - 150);
			particles.push(p);
			particles.push(s);
			particles.push(n);
			particles.push(l);
		}
		for(int i = particles.size() - 1; i > 0; i--) {
			particles.get(i).update();
			if(particles.get(i).getAlpha() <= 0) {
				particles.remove(i);
			}
		}
		repaint();
		
	}

}
