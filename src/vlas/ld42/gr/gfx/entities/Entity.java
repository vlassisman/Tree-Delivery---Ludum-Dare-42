package vlas.ld42.gr.gfx.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.level.Level;

public abstract class Entity{

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	public Rectangle bounds;
	protected Level level;
	
	public Entity(Handler handler, float x , float y, int width , int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle((int)x, (int)y, width , height);
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
	protected abstract void render(Graphics g);
	protected abstract void update();

	public Handler getHandler() {
		return handler;
	}

	//getters and setters
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}