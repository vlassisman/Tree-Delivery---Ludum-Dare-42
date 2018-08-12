package vlas.ld42.gr.gfx.tiles;

import java.awt.Graphics;

import vlas.ld42.gr.gfx.Assets;

public class DirtTile extends Tile{

	public DirtTile() {
		super(Assets.dirt);
	}

	public void update() {
		
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(tile, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid() {
		return true;
	}

}
