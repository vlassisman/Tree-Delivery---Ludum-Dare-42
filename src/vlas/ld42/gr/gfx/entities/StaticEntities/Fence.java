package vlas.ld42.gr.gfx.entities.StaticEntities;

import java.awt.Graphics;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;

public class Fence extends StaticEntity{

	public Fence(Handler handler, float x, float y) {
		super(handler, x, y, 128 + 32, 64 + 32);
	}

	@Override
	protected void render(Graphics g) {
		g.drawImage(Assets.fence, (int)(x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width , height, null);			
	}

	@Override
	protected void update() {
		
	}

}
