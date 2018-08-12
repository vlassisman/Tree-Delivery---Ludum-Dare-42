package vlas.ld42.gr.gfx.entities.StaticEntities;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	
}
