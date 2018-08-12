package vlas.ld42.gr;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import vlas.ld42.gr.gfx.ImageLoader;

public class Frame extends Canvas{

	private static final long serialVersionUID = 1L;
	private int width, height;
	private Canvas canvas;
	private JFrame frame;
	
	public Frame(int width, int height) {
		this.width = width;
		this.height = height;
		createFrame();
	}
	
	private void createFrame() {
		frame = new JFrame();
		//frame.setTitle(Game.title);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(ImageLoader.loadImage("/textures/tree.png"));
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}

	//getters and setters
	
	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
