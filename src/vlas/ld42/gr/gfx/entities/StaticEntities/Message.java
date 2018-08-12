package vlas.ld42.gr.gfx.entities.StaticEntities;

import java.awt.Graphics;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;
import vlas.ld42.gr.gfx.entities.EntityManager;

public class Message extends StaticEntity{

	public Message(Handler handler, float x, float y) {
		super(handler, x, y, 448, 448);
	}

	public void render(Graphics g) {
		g.drawImage(Assets.deliver, (int)(x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width , height, null);	
	}

	int wait = 0;
	public void update() {
		wait ++;
		if(wait % 48 == 0) {
			EntityManager.removeMessage(this);
		}
		float gravity = 1f;
		int ya = 0;
		ya += gravity;
		y += ya;
	}

}
