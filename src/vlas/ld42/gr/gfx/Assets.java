package vlas.ld42.gr.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));
	private static SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet1.png"));
	private static SpriteSheet labelSheet = new SpriteSheet(ImageLoader.loadImage("/textures/labels.png"));
	
	public static BufferedImage[] playerRight, playerLeft, playerRightStar, playerLeftStar, playerRight2Star, playerLeft2Star, torch;
	public static BufferedImage rock, grass, dirt, star, void_t, tree, deliver, farmLabel, starsLabel, p1, p2, p3, fence, sky, skyBS, skySS, skyXSS;
	
	public static void init() {
		playerRight = new BufferedImage[2];
		playerRight[1] = player.crop(256, 0, 256, 128);
		playerRight[0] = player.crop(256, 128, 256, 128);
		
		playerRightStar = new BufferedImage[2];
		playerRightStar[1] = player.crop(256, 256, 256, 128);
		playerRightStar[0] = player.crop(256, 384, 256, 128);
		
		playerRight2Star = new BufferedImage[2];
		playerRight2Star[1] = player.crop(256, 512, 256, 128);
		playerRight2Star[0] = player.crop(256, 640, 256, 128);
		
		playerLeft = new BufferedImage[2];
		playerLeft[0] = player.crop(0, 0, 256, 128);
		playerLeft[1] = player.crop(0, 128, 256, 128);
		
		playerLeftStar = new BufferedImage[2];
		playerLeftStar[1] = player.crop(0, 256, 256, 128);
		playerLeftStar[0] = player.crop(0, 384, 256, 128);
		
		playerLeft2Star = new BufferedImage[2];
		playerLeft2Star[1] = player.crop(0, 512, 256, 128);
		playerLeft2Star[0] = player.crop(0, 640, 256, 128);
		
		grass = sheet.crop(0, 0, 128, 128);
		dirt = sheet.crop(128, 0, 128, 128);
		rock = sheet.crop(256, 0, 128, 128);
		star = sheet.crop(384, 0, 128, 128);
		void_t = sheet.crop(384 + 128, 0, 128, 128);
		fence = sheet.crop(384, 128, 256, 128);
		sky = sheet.crop(384, 256, 128, 128);
		skyBS = sheet.crop(512, 256, 128, 128);
		skySS = sheet.crop(384, 384, 128, 128);
		skyXSS = sheet.crop(512, 384, 128, 128);
		
		tree = ImageLoader.loadImage("/textures/tree.png");
		deliver = ImageLoader.loadImage("/textures/deliver.png");
		
		farmLabel = labelSheet.crop(384, 0, 384, 384);
		starsLabel = labelSheet.crop(0, 0, 384, 384);
		
		p1 = ImageLoader.loadImage("/storyPages/p1.png");
		p2 = ImageLoader.loadImage("/storyPages/p2.png");
		p3 = ImageLoader.loadImage("/storyPages/p3.png");
		
		torch = new BufferedImage[2];
		torch[0] = sheet.crop(128, 512, 128, 128);
		torch[1] = sheet.crop(256, 512, 128, 128);
	}
	
}
