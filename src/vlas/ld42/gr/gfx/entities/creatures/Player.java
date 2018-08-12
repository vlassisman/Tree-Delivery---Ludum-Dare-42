package vlas.ld42.gr.gfx.entities.creatures;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Assets;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.input.Keyboard;
import vlas.ld42.gr.items.ItemManager;

public class Player extends Creature{

	private static float playerSpeed = 3.0f;
	public static boolean jumping = false;
	private float gravity = 0.0f;
	private BufferedImage frame;
	public int starCount = 0;
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CRATURE_WIDTH, Creature.DEFAULT_CRATURE_HEIGHT, playerSpeed);
		bounds.x = 16; bounds.width = 176;
		bounds.y = 0; bounds.height = 120;
	}
	
	int anim = 0;
	private void getAnimFrame() {
		anim ++;
		if(xa > 0 ) {
			if(anim % 12 > 6 && starCount == 1) {
				frame = Assets.playerRightStar[0];
			}else if(anim % 12 <= 6 && starCount == 1) {
				frame = Assets.playerRightStar[1];
			}
			
			if(anim % 12 > 6 && starCount == 2) {
				frame = Assets.playerRight2Star[0];
			}else if(anim % 12 <= 6 && starCount == 2) {
				frame = Assets.playerRight2Star[1];
			}
			
			if(anim % 12 > 6 && starCount == 0) {
				frame = Assets.playerRight[0];
			}else if(anim % 12 <= 6 && starCount == 0) {
				frame = Assets.playerRight[1];
			}
		}
		
		
		if(xa < 0 ) {
			if(anim % 12 > 6 && starCount == 1) {
				frame = Assets.playerLeftStar[0];
			}else if(anim % 12 <= 6 && starCount == 1) {
				frame = Assets.playerLeftStar[1];
			}
			
			if(anim % 12 > 6 && starCount == 2) {
				frame = Assets.playerLeft2Star[0];
			}else if(anim % 12 <= 6 && starCount == 2) {
				frame = Assets.playerLeft2Star[1];
			}
			
			if(anim % 12 > 6 && starCount == 0) {
				frame = Assets.playerLeft[0];
			}else if(anim % 12 <= 6 && starCount == 0) {
				frame = Assets.playerLeft[1];
			}
		}	
	}
	
	private void getWalkingSound() {
		if(xa != 0 && (Keyboard.Pressed(KeyEvent.VK_RIGHT) || Keyboard.Pressed(KeyEvent.VK_LEFT))) {
			Sound.walking.play(true);
		}else if(xa == 0 && (!(Keyboard.Pressed(KeyEvent.VK_RIGHT)) && !(Keyboard.Pressed(KeyEvent.VK_LEFT)))){
			Sound.walking.stop();
		}
	}
	
	protected void getInput() {
		xa = 0;
		ya = 0;
	
		if(Keyboard.right) {
			xa = playerSpeed;
		}
		if(Keyboard.left) {
			xa = -playerSpeed;
		}
		if(Keyboard.jump) {
			if(jumping) {
				Sound.jump.play(false);
				gravity = -4.5f;
				ya += gravity;
				jumping = false;
			}
			else if(!jumping) {
				gravity += 0.3f;
				ya = gravity;
			}
		} else {
			if (!Keyboard.jump || !jumping ) {
					gravity += 0.3f;
					ya = gravity;
			}
		}
		if(Keyboard.pick) {
			
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(frame, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
	}
	
	public void update() {
		getInput();
		move();
		getWalkingSound();
		getAnimFrame();
		handler.getCamera().centerOnEntity(this);
		ItemManager.pickStar();
	}

	//getters and setters
	public static float getPlayerSpeed() {
		return playerSpeed;
	}

	public static void setPlayerSpeed(float playerSpeed) {
		Player.playerSpeed = playerSpeed;
	}
	
}
