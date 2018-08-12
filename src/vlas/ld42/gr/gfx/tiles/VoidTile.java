package vlas.ld42.gr.gfx.tiles;

import java.awt.Graphics;

import vlas.ld42.gr.gfx.Assets;

public class VoidTile extends Tile{

	public VoidTile() {
		super(Assets.void_t);
	}

	public void update() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(tile, x, y, TILEWIDTH, TILEHEIGHT, null);		
	}

	public boolean isSolid() {
		return false;
	}

}
