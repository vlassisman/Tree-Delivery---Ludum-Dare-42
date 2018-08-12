package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;

import vlas.ld42.gr.Handler;

public abstract class State {

	protected Handler handler;
	private static State currentState = null;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public static State getState() {
		return currentState;
	}
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
}
