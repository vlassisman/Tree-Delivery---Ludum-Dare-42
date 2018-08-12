package vlas.ld42.gr;

import java.applet.Applet;
import java.awt.BorderLayout;

public class GameApplet extends Applet{

	private static final long serialVersionUID = 1L;

	Game game = new Game(800, 600);
	
	public void init() {
		setLayout(new BorderLayout());
		add(game);
	}

	public void start() {
		game.start();
	}

	public void stop() {
		game.stop();
	}

	
}
