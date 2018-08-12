package vlas.ld42.gr.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.gfx.entities.creatures.Player;
import vlas.ld42.gr.gfx.level.Level;

public class ItemManager {

	public static ArrayList<Star> stars;
	
	private Handler handler;
	private Random r = new Random();
	
	public ItemManager(Handler handler) {
		this.handler = handler;
		stars = new ArrayList<Star>();
	}
	
	public static void pickStar() {
		for(int i = 0; i < stars.size(); i++) {
			Star s = stars.get(i);
			Player player = Level.getPlayer();
			Rectangle rS = new Rectangle((int)(s.getX()),(int) (s.y), s.width, s.height);
			Rectangle rP = new Rectangle((int)(player.getX() + player.bounds.x),(int) (player.getY() + player.bounds.y), player.bounds.width, player.bounds.height);
			if(rP.intersects(rS) && player.starCount < 2) {
				Sound.pick.play(false);
				removeStar(s);
				player.starCount ++;
				System.out.println(player.starCount);
			}
		}	
	}

	int anim = 0;
	public void generateStars() {
		anim++;
		if(anim % 600 == 300) {
			ItemManager.addStar(new Star(handler, r.nextInt(1024 - 384 - 64) + 384 + 64, r.nextInt(1864 - 1800) + 1800));
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < stars.size(); i++) {
			Star s = stars.get(i);
			s.render(g);
		}
	}
	
	public void update() {
		for(int i = 0; i < stars.size(); i++) {
			Star s = stars.get(i);
			s.update();
		}
		generateStars();
	}
	
	public static void addStar(Star s) {
		stars.add(s);
	}
	
	public static void removeStar(Star s) {
		stars.remove(s);
	}
	
}
