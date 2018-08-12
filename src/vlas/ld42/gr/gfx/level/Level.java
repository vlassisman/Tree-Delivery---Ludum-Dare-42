package vlas.ld42.gr.gfx.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.Sound.Sound;
import vlas.ld42.gr.gfx.State.GameOverState;
import vlas.ld42.gr.gfx.State.State;
import vlas.ld42.gr.gfx.entities.EntityManager;
import vlas.ld42.gr.gfx.entities.StaticEntities.FarmLabel;
import vlas.ld42.gr.gfx.entities.StaticEntities.Fence;
import vlas.ld42.gr.gfx.entities.StaticEntities.StarsLabel;
import vlas.ld42.gr.gfx.entities.creatures.Player;
import vlas.ld42.gr.gfx.tiles.Tile;
import vlas.ld42.gr.items.ItemManager;

public class Level {
	
	private int[] levelPixels;
	private static int width;
	private static int height;
	private Handler handler;
	private EntityManager entityManager;
	private ItemManager itemManager;
	private String timerString = "";
	private int timerm = 2;
	private int timers = 0;
	public static Player player;
	

	public Level(String path, Handler handler) {
		this.handler = handler;
		player = new Player(handler, 2200, 2100);
		player.init(this);
		entityManager = new EntityManager(handler, player);
		EntityManager.addStaticEntity(new StarsLabel(handler, 1024 + 128, 2128));
		EntityManager.addStaticEntity(new FarmLabel(handler, 1068 * 2 - 128, 2128));
		EntityManager.addStaticEntity(new Fence(handler, 1068 * 2 + 256, 2128 + 64 + 32));
		EntityManager.addStaticEntity(new Fence(handler, 1068 * 2 + 512, 2128 + 64 + 32));
		EntityManager.addStaticEntity(new Fence(handler, 1068 * 2 + 512 + 256, 2128 + 64 + 32));
		itemManager = new ItemManager(handler);
		loadLevel(path);
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILEWIDTH - 1);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		// int yStart = (int) Math.max(0, handler.getCamera().getyOffset() /
		// Tile.TILEHEIGHT);
		// int yEnd = (int) Math.min(height, handler.getCamera().getyOffset() +
		// handler.getHeight() / Tile.TILEHEIGHT);
		for (int y = 0; y < height; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getCamera().getyOffset()));
			}
		}
		entityManager.render(g);
		itemManager.render(g);
		renderTimer(g);
		handler.renderText(g, "ESC", 732 + 3, 30 + 3, 30, 1, 0);
		handler.renderText(g, "ESC", 732, 30, 30, 1, 0xffffff);
	}
	
	int timer = 0;
	public void update() {
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILEWIDTH - 1);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		//int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILEHEIGHT);
		// int yEnd = (int) Math.min(height, handler.getCamera().getyOffset() +
		// handler.getHeight() / Tile.TILEHEIGHT);
		for (int y = 0; y < height; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).update();
			}
		}
		timer++;
		entityManager.update();
		itemManager.update();
		if(timer % 60 == 0) updateTimer();
	}

	private void loadLevel(String path) {
		try {
			BufferedImage level = ImageIO.read(Level.class.getResource(path));
			int w = width = level.getWidth();
			int h = height = level.getHeight();
			levelPixels = new int[w * h];
			level.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR : level file not found");
		}
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.dirtTile;
		if (levelPixels[x + y * width] == 0xFF00FF00)
			return Tile.grassTile;
		if (levelPixels[x + y * width] == 0xFF404040)
			return Tile.rockTile;
		if (levelPixels[x + y * width] == 0xFFFF0000)
			return Tile.dirtTile;
		if (levelPixels[x + y * width] == 0xFFFFFFFF)
			return Tile.voidTile;
		if (levelPixels[x + y * width] == 0xFFFFFF00)
			return Tile.torchTile;
		
		if (levelPixels[x + y * width] == 0xFF000000)
			return Tile.skyTile;
		if (levelPixels[x + y * width] == 0xFF000042)
			return Tile.skyBSTile;
		if (levelPixels[x + y * width] == 0xFF00009F)
			return Tile.skySSTile;
		if (levelPixels[x + y * width] == 0xFF69699E)
			return Tile.skyXSSTile;
		
		return Tile.voidTile;
	}

	private void updateTimer() {
		timerString = timerm + ":" + timers;
		if (timers == 0 && timerm != 0)
			timerString = timerm + ":" + 0 + "0";
		if (timers < 10)
			timerString = timerm + ":" + "0" + timers;
		if (timers <= 0 && timerm != 0) {
			timers = 60;
			timerm--;
		}

		timers--;
		if (timers <= 0 && timerm <= 0) {
			Sound.walking.stop();
			Sound.elato.stop();
			State.setState(new GameOverState(handler));
		}
	}

	public void renderTimer(Graphics g) {
		int col = 0xffffff;
		handler.renderText(g, timerString, 364, 564, 30, 0, col);
	}

	public static float getWidth() {
		return width;
	}
	
	public static float getHeight() {
		return height;
	}

	public static Player getPlayer() {
		return player;
	}
}
