package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.ImageLoader;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.input.Keyboard;

public class MenuState extends State{

	private BufferedImage bg = ImageLoader.loadImage("/textures/GO_BG1.png");
	private String[] options = {"play", "help", "about"};
	private int selection = 0;
	
	public MenuState(Handler handler) {
		super(handler);
		Sound.kav.play(true);
	}

	public void update() {
		if(Keyboard.Pressed(KeyEvent.VK_DOWN) && selection < options.length) {
			Sound.choosing.play(false);
			selection++;
		}
		if(Keyboard.Pressed(KeyEvent.VK_UP) && selection < options.length) {
			Sound.choosing.play(false);
			selection--;
		}
		if(selection > 2) selection = 2;
		if(selection < 0) selection = 0;
		
		if(selection == 0) {
			options[selection] = ">" + "play" + "<";
			if(Keyboard.Pressed(KeyEvent.VK_ENTER)) {
				Sound.select.play(false);
				Sound.kav.stop();
				State.setState(new GameState(handler));
			}
		}else {
			options[0] = "play";
		}
		
		if(selection == 1) {
			options[selection] = ">" + "help" + "<";
			if(Keyboard.Pressed(KeyEvent.VK_ENTER)) {
				Sound.select.play(false);
				State.setState(new HelpState(handler));
			}
		}else {
			options[1] = "help";
		}
		
		if(selection == 2) {
			options[selection] = ">" + "about" + "<";
			if(Keyboard.Pressed(KeyEvent.VK_ENTER)) {
				Sound.select.play(false);
				State.setState(new AboutState(handler));
			}
		}else {
			options[2] = "about";
		}
		
	}

	public void render(Graphics g) {
		g.drawImage(bg, 0, 0, handler.getWidth(), handler.getHeight(), null);
		handler.renderText(g, " TREE DELIVERY", 20 + 4, 140 + 4, 80, 1, 0);	
		handler.renderText(g, " TREE DELIVERY", 20, 140, 80, 1, 0xffffff);
		handler.renderText(g, "A game by Vlassis.", 250 + 2, 188 + 2, 30, 1, 0);
		handler.renderText(g, "A game by Vlassis.", 250, 188, 30, 1, 0xffffff);
		for (int i = 0; i < options.length; i++) {
			handler.renderText(g, options[i], 300 + 3, 350 + i * 60 + 3, 50, 1, 0);
			handler.renderText(g, options[i], 300, 350 + i * 60, 50, 1, 0xffffff);
		}
	}

}