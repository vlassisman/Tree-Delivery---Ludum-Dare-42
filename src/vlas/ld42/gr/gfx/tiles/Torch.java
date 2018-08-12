package vlas.ld42.gr.gfx.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.gfx.Assets;

public class Torch extends Tile{

	private static BufferedImage T_tile;
	
	public Torch() {
		super(T_tile);
	}

	int timer = 0;
	int s = 1;
	public void update() {
		timer++;
		if(timer % 48 == 0) s *= -1;
		if(s == 1) T_tile = Assets.torch[0];
		if(s == -1) T_tile = Assets.torch[1];
	}

	@Override
	public void render(Graphics g, int x, int y) {
		g.drawImage(T_tile, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	@Override
	public boolean isSolid() {
		return false;
	}

	
	
}
