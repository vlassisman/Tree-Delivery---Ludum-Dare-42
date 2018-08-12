package vlas.ld42.gr.gfx.entities.creatures;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.entities.Entity;
import vlas.ld42.gr.gfx.tiles.Tile;

public abstract class Creature extends Entity{

	protected static final int DEFAULT_CRATURE_WIDTH = 256, DEFAULT_CRATURE_HEIGHT = 128;
	public float xa;
	protected float ya;
	protected float speed;

	public Creature(Handler handler, float x, float y, int width, int height, float speed) {
		super(handler, x, y, DEFAULT_CRATURE_WIDTH, DEFAULT_CRATURE_HEIGHT);
		this.speed = speed;
		xa = 0;
		ya = 0;
	}

	protected abstract void getInput();
	
	public void move(){
		moveY();
		moveX();
	}
	
	public void move1(){
		if(!collision(0, ya)) y += ya;
		if(!collision(xa, 0)) x += xa;
	}
	
	private boolean collision(float xa, float ya) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			int tx = (int) (((x + xa) + c % 2 * 2 - 1) / 128);
			int ty = (int) (((y + ya) + c / 2 * 20 + 100) / 128);
			if(handler.getLevel().getTile(tx, ty).isSolid()) {
				solid = true;
				Player.jumping = false;
			}else {
				solid = false;
				Player.jumping = true;
			}
		}
		return solid;
	}
	
	public void moveY(){
		if(ya < 0){//Up
			int ty = (int) (y + ya + bounds.y) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += ya;
			}else{
				//y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
				ya = 0;
			}
			
		}else if(ya > 0){//Down
			int ty = (int) (y + ya + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += ya;
				Player.jumping = false;
			}else{
				//y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
				ya = 0;
				Player.jumping = true;
			}
			
		}
	}
	
	public void moveX(){
		if(xa > 0){//Moving right
			int tx = (int) (x + xa + bounds.x + bounds.width + 40) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xa;
			}else{
				xa = 0;
			}
			
		}else if(xa < 0){//Moving left
			int tx = (int) (x + xa + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xa;
			}else{
				xa = 0;
			}
			
		}
	}
	
	private boolean collisionWithTile(int x, int y){
		return level.getTile(x, y).isSolid();
	}

	// getters and setters

	public float getXa() {
		return xa;
	}

	public float getYa() {
		return ya;
	}

	public float getSpeed() {
		return speed;
	}

	public void setXa(float xa) {
		this.xa = xa;
	}

	public void setYa(float ya) {
		this.ya = ya;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public static int getDefaultCratureWidth() {
		return DEFAULT_CRATURE_WIDTH;
	}

	public static int getDefaultCratureHeight() {
		return DEFAULT_CRATURE_HEIGHT;
	}

	
}
