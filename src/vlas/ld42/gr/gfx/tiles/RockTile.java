package vlas.ld42.gr.gfx.tiles;

import java.awt.Graphics;

import vlas.ld42.gr.gfx.Assets;

public class RockTile extends Tile{

	public RockTile() {
		super(Assets.rock);
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
