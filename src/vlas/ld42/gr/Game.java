package vlas.ld42.gr;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import vlas.ld42.gr.gfx.Assets;
import vlas.ld42.gr.gfx.Camera;
import vlas.ld42.gr.gfx.State.State;
import vlas.ld42.gr.gfx.State.StoryState;
import vlas.ld42.gr.input.Keyboard;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	//frame
	private Frame frame;
	private int width, height;
	private String title = "LD42 - Tree Delivery" ;
	//thread
	private Thread thread;
	private boolean running = false;
	//handler
	private Handler handler;
	//gfx
	private Graphics g;
	private BufferStrategy bs;
	//input
	private Keyboard keyboard;
	//camera
	private Camera camera;
	
	public Game(int width , int height) {
		this.width = width;
		this.height = height;
		
		keyboard = new Keyboard();
	}

	public void init() {
		frame = new Frame(width, height);
		frame.getFrame().addKeyListener(keyboard);
		frame.getCanvas().addKeyListener(keyboard);
		handler = new Handler(this);
		Assets.init();
		camera = new Camera(handler, 0, 1800);
		State.setState(new StoryState(handler));
	}
	
	public void update() {
		keyboard.update();
		if(State.getState() != null) {
			State.getState().update();
		}
	}
	
	public void render() {
		bs = frame.getCanvas().getBufferStrategy();
		if(bs == null) {
			frame.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//render here
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		
		long lastTime = System.nanoTime();
		long lastTimer = System.currentTimeMillis();
		double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				updates++;
				delta--;
			} 

			render();
			frames++;

			while (System.currentTimeMillis() - lastTimer > 1000) {
				lastTimer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.getFrame().setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//getters and setters
	
	public Keyboard getKeyboard() {
		return keyboard;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}