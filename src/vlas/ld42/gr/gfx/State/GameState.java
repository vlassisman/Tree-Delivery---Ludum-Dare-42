package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.gfx.level.Level;
import vlas.ld42.gr.input.Keyboard;

public class GameState extends State{

	private static Level level;
	
	public GameState(Handler handler) {
		super(handler);
		level = new Level("/levels/level.png", handler);
		Sound.elato.play(true);
	}

	public void update() {
		level.update();
		if(Keyboard.Pressed(KeyEvent.VK_ESCAPE)) { 
			Sound.elato.stop();
			State.setState(new MenuState(handler));
		}
	}

	public void render(Graphics g) {
		level.render(g);
	}
	
	public static Level getLevel() {
		return level;
	}

}