package vlas.ld42.gr.gfx;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.entities.Entity;

public class Camera {

	private float xOffset, yOffset;
	private Handler handler;
	
	public Camera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = (e.getY() - handler.getHeight() / 2 + e.getHeight() / 2) - 128;
	}
	
	//getters setters
	
	public float getxOffset() {
		return xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
