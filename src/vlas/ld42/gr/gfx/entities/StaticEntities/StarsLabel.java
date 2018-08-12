package vlas.ld42.gr.gfx.entities.StaticEntities;

import java.awt.Graphics;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;

public class StarsLabel extends StaticEntity{

	public StarsLabel(Handler handler, float x, float y) {
		super(handler, x, y, 128 + 64, 128 + 64);
	}

	protected void render(Graphics g) {
		g.drawImage(Assets.starsLabel, (int)(x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width , height, null);	
	}

	protected void update() {
		
	}

}
