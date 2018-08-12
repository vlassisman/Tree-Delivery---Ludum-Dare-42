package vlas.ld42.gr.gfx.State;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.input.Keyboard;

public class StoryState extends State{

	private BufferedImage page;
	private int selection = 0;
	
	public StoryState(Handler handler) {
		super(handler);
		Sound.holyN.play(true);
	}

	public void update() {
		if(Keyboard.Pressed(KeyEvent.VK_ENTER) && selection < 3) {
			Sound.page.play(false);
			selection ++ ;
		}
		if(selection > 3) selection = 3;
		
		if(selection == 0) setPage(Assets.p1);
		if(selection == 1) setPage(Assets.p2);
		if(selection == 2) setPage(Assets.p3);
		if(selection == 3) {
			Sound.holyN.stop();
			State.setState(new MenuState(handler));
		}
	}

	public void render(Graphics g) {
		g.drawImage(page, 0, 0, handler.getWidth(), handler.getHeight(), null);
	}

	public BufferedImage getPage() {
		return page;
	}

	public void setPage(BufferedImage page) {
		this.page = page;
	}
	
}
