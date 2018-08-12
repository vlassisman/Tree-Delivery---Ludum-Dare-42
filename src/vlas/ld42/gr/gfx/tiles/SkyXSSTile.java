package vlas.ld42.gr.gfx.tiles;

import java.awt.Graphics;

import vlas.ld42.gr.gfx.Assets;

public class SkyXSSTile extends Tile{

	public SkyXSSTile() {
		super(Assets.skyXSS);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(tile, x, y, TILEWIDTH, TILEHEIGHT, null);	
	}

	@Override
	public boolean isSolid() {
		return false;
	}

}
