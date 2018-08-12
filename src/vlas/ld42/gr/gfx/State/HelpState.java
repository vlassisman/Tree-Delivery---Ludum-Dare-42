package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.ImageLoader;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.input.Keyboard;

public class HelpState extends State{

	private String option = ">" + "back" + "<";
	private boolean selected = false;
	private BufferedImage bg = ImageLoader.loadImage("/textures/GO_BG2.png");
	
	public HelpState(Handler handler) {
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
				"You are little Billy; Santas's son! Your mission",
				"is to decorate the christmas trees -in the tree",
				"   farm- with the magical falling stars! Once",
				"   decorated they will be magically devilered",
				"   to their owners! But be careful! The farm is",
				"   running out of space and the trees MUST be",
				"     delivered in two minutes! so, HURRY UP!",
				"  Navigate with the arrow keys | Pick stars by",
				" colliding with them | Decorate tress colliding",
				" AND clicking 'X' | Press ESC to escape return  ",
				 "               to main menu while in game"
		};
		
		g.drawImage(bg, 0, 0, handler.getWidth(), handler.getHeight(), null);
		for(int i = 0; i < text.length; i++) {
			handler.renderText(g, text[i], 10 + 3, 25 + i * 40 + 3, 30, 1, 0);
			handler.renderText(g, text[i], 10, 25 + i * 40, 30, 1, 0xffffff);
		}
		
		handler.renderText(g, option, 300 + 3, 500 + 1 * 60 + 3, 50, 1, 0);
		handler.renderText(g, option, 300, 500 + 1 * 60, 50, 1, 0xffffff);
	}

}
