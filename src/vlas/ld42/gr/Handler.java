package vlas.ld42.gr;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import vlas.ld42.gr.gfx.Camera;
import vlas.ld42.gr.gfx.State.GameState;
import vlas.ld42.gr.gfx.level.Level;
import vlas.ld42.gr.input.Keyboard;

public class Handler {

	private Game game;
	
	public void renderText(Graphics graphics, String text, int x, int y, int size, int style, int color) {
		int r = (color & 0xff0000) >> 16;
		int g = (color & 0xff00) >> 8;
		int b = (color & 0xff);
		Color c = new Color(r, g, b);
		Font f = new Font("Verdana", style, size);
		graphics.setColor(c);
		graphics.setFont(f);
		graphics.drawString(text, x, y);
	}
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public Keyboard getKeyboard() {
		return game.getKeyboard();
	}
	
	public Camera getCamera() {
		return game.getCamera();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public Level getLevel() {
		return GameState.getLevel();
	}
	
}
