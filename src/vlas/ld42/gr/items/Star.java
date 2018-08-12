package vlas.ld42.gr.items;

import java.awt.Graphics;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;

public class Star extends Item{

	public Star(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
	}

	protected void render(Graphics g) {
		g.drawImage(Assets.star, (int) (getX() - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
	}

	protected void update() {
		float gravity = 0.3f;
		float curve = 0.3f;
		curve -= 0.1;
		xa += curve;
		ya += gravity;
		move();
	}

}
