package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.ImageLoader;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.gfx.entities.EntityManager;
import vlas.ld42.gr.input.Keyboard;

public class GameOverState extends State{

	private BufferedImage bg = ImageLoader.loadImage("/textures/GO_BG.png");
	private String[] options = {"retry", "menu"};
	private int selection = 0;
	private String[] message;
	
	public GameOverState(Handler handler) {
		super(handler);
		message = new String[2];
	}
	
	private void checkStars() {
		if(EntityManager.trees.size() == 0) {
			message[0] = "   YOU WON! All ";
			message[1] = "trees were delivered";
		}else {
			message[0] = "You lost... not all";
			message[1] = "trees were delivered";
		}
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
		if(selection > 1) selection = 1;
		if(selection < 0) selection = 0;
		
		if(selection == 0) {
			options[selection] = ">" + "retry" + "<";
			if(Keyboard.Pressed(KeyEvent.VK_ENTER)) {
				Sound.select.play(false);
				State.setState(new GameState(handler));
			}
		}else {
			options[0] = "retry";
		}
		
		if(selection == 1) {
			options[selection] = ">" + "menu" + "<";
			if(Keyboard.Pressed(KeyEvent.VK_ENTER)) {
				Sound.select.play(false);
				State.setState(new MenuState(handler));
			}
		}else {
			options[1] = "menu";
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(bg ,0, 0, handler.getWidth(), handler.getHeight(), null);
		checkStars();
		for(int i = 0; i < message.length; i++) {
			handler.renderText(g, message[i], 170 + 2, 50 + i * 50 + 2, 50, 0, 0);
			handler.renderText(g, message[i], 170, 50 + i * 50, 50, 0, 0xffffff);
		}
		for (int i = 0; i < options.length; i++) {
			handler.renderText(g, options[i], 300 + 3, 350 + i * 60 + 3, 50, 1, 0);
			handler.renderText(g, options[i], 300, 350 + i * 60, 50, 1, 0xffffff);
		}
	}

}