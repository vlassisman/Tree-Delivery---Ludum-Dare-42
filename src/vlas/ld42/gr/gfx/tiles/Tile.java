package vlas.ld42.gr.gfx.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Tile {

	public static Tile grassTile = new GrassTile();
	public static Tile dirtTile = new DirtTile();
	public static Tile rockTile = new  RockTile();
	public static Tile voidTile = new VoidTile();
	public static Tile torchTile = new Torch();
	
	public static Tile skyTile = new SkyTile();
	public static Tile skyBSTile = new SkyBSTile();
	public static Tile skySSTile = new SkySSTile();
	public static Tile skyXSSTile = new SkyXSSTile();
	
	public static final int TILEWIDTH = 128, TILEHEIGHT = 128;
	protected BufferedImage tile;
	
	public Tile(BufferedImage tile) {
		this.tile = tile;
	}
	
	public abstract void update();
	public abstract void render(Graphics g, int x, int y);
	public abstract boolean isSolid();
}