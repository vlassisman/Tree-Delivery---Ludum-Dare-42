package vlas.ld42.gr.gfx.entities.StaticEntities;

import java.awt.Graphics;
import java.awt.Rectangle;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.gfx.entities.creatures.Player;
import vlas.ld42.gr.gfx.level.Level;
import vlas.ld42.gr.input.Keyboard;

public class Tree extends StaticEntity{

	private boolean hasStar = false;
	
	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, 448, 448);
	}

	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int)(x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width , height, null);	
	}

	public void update() {
		Player player = Level.getPlayer();
		Rectangle rT = new Rectangle((int)x, (int)y, width , height);
		Rectangle rP = new Rectangle((int) (player.getX() + player.bounds.x), (int) (player.getY() + player.bounds.y), player.bounds.width, player.bounds.height);
		if (rP.intersects(rT) && player.starCount > 0 && !hasStar && Keyboard.set) {
			Sound.delivered.play(false);
			player.starCount--;
			hasStar = true;
		}
	}

	public boolean isHasStar() {
		return hasStar;
	}

	public void setHasStar(boolean hasStar) {
		this.hasStar = hasStar;
	}
}
