package vlas.ld42.gr.items;

import java.awt.Graphics;
import java.awt.Rectangle;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.tiles.Tile;

public abstract class Item {

	protected float x;
	protected float y;
	protected int width, height;
	protected Handler handler;
	private Rectangle bounds;
	protected float xa, ya;

	public Item(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.setX(x);
		this.y = y;
		this.width = width;
		this.height = height;
		setBounds(new Rectangle((int) x, (int) y, width, height));
	}
	
	protected abstract void render(Graphics g);
	protected abstract void update();

	public void move(){
		moveX();
		moveY();
	}
	
	public void moveY(){
		if(ya < 0){//Up
			int ty = (int) (y + ya) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + width) / Tile.TILEWIDTH, ty)){
				y += ya;
			}else{
				ya = 0;
			}
			
		}else if(ya > 0){//Down
			int ty = (int) (y + ya + height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + width) / Tile.TILEWIDTH, ty)){
				y += ya;
			}else{
				y = ty * Tile.TILEHEIGHT - height - 2;
				x = ((int) (x + xa + width) / Tile.TILEWIDTH) * Tile.TILEWIDTH - width - 1;
				ya = 0;
				xa = 0;
			}
			
		}
	}
	
	public void moveX(){
		if(xa > 0){//Moving right
			int tx = (int) (x + xa + width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + height) / Tile.TILEHEIGHT)){
				x += xa;
			}else{
				x = tx * Tile.TILEWIDTH - width - 1;
			}
			
		}else if(xa < 0){//Moving left
			int tx = (int) (x + xa) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + height) / Tile.TILEHEIGHT)){
				x += xa;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH;
			}
			
		}
	}
	
	private boolean collisionWithTile(int x, int y){
		return handler.getLevel().getTile(x, y).isSolid();
	}
	
	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

}
