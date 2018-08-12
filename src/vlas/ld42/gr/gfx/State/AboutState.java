package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.ImageLoader;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.input.Keyboard;

public class AboutState extends State{

	private String option = ">" + "back" + "<";
	private boolean selected = false;
	private BufferedImage bg = ImageLoader.loadImage("/textures/GO_BG2.png");
	
	public AboutState(Handler handler) {
		super(handler);
		selected = true;
	}

	public void update() {
		if(Keyboard.Pressed(KeyEvent.VK_ENTER) && selected) {
			Sound.select.play(false);
			State.setState(new MenuState(handler));
		}
	}

	public void render(Graphics g) {
		String[] text = {
				"This is Christmas game created for Ludum",
				"Dare 42 in Summer(2018) ;P. LD42 was my",
				" first game jam and this game was my first",
				" completed game as well! In the beginning",
				"I thought that 48hrs is way too short time",
				"   to prepare a game! However, I managed",
				"    to finish it within the time limit.",
				"   ",
				"         For any question contact me at:",
				"                vlassisman@gmail.com"
		};
		
		g.drawImage(bg, 0, 0, handler.getWidth(), handler.getHeight(), null);
		for(int i = 0; i < text.length; i++) {
			handler.renderText(g, text[i], 20 + 3, 25 + i * 40 + 3, 30, 1, 0);
			handler.renderText(g, text[i], 20, 25 + i * 40, 30, 1, 0xffffff);
		}
		
		handler.renderText(g, option, 300 + 3, 500 + 1 * 60 + 3, 50, 1, 0);
		handler.renderText(g, option, 300, 500 + 1 * 60, 50, 1, 0xffffff);
	}

}