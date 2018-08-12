package vlas.ld42.gr.gfx.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import vlas.ld42.gr.Handler;
import vlas.ld42.gr.gfx.entities.StaticEntities.Message;
import vlas.ld42.gr.gfx.entities.StaticEntities.StaticEntity;
import vlas.ld42.gr.gfx.entities.StaticEntities.Tree;
import vlas.ld42.gr.gfx.entities.creatures.Player;

public class EntityManager {

	public static ArrayList<Tree> trees;
	public static ArrayList<Message> messages;
	public static ArrayList<StaticEntity> staticEntities;
	
	private Random r = new Random();
	private Handler handler;
	private Player player;
	
	public EntityManager(Handler handler, Player player) {
		this.setHandler(handler);
		this.player = player;
		trees = new ArrayList<Tree>();
		messages = new ArrayList<Message>();
		staticEntities = new ArrayList<StaticEntity>();
	}
	
	int timer = 0;
	private void generateTrees() {
		timer ++;
		if(timer % 800 == 400) {
			handler.getLevel();
			addTree(new Tree(handler, r.nextInt((int) ((2494) - 1068 * 2)) + 1068 * 2 , 1864));
		}
	}
	
	private void removeTrees() {
		for(int i = 0; i < trees.size(); i++) {
			Tree e = trees.get(i);
			if(e.isHasStar()) {
				removeTree(e);
				Message m = new Message(handler, e.x, e.y);
				addMessage(m);
			}
		}	
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < trees.size(); i++) {
			Tree e = trees.get(i);
			e.render(g);
		}
		for(int n = 0; n < messages.size(); n++) {
			Message s = messages.get(n);
			s.render(g);
		}
		player.render(g);
		for(int d = 0; d < staticEntities.size(); d++) {
			StaticEntity s = staticEntities.get(d);
			s.render(g);
		}
	}
	
	public void update() {
		for(int i = 0; i < trees.size(); i++) {
			Tree e = trees.get(i);
			e.update();
		}
		for(int n = 0; n < messages.size(); n++) {
			Message s = messages.get(n);
			s.update();
		}
		player.update();
		for(int d = 0; d < staticEntities.size(); d++) {
			StaticEntity s = staticEntities.get(d);
			s.update();
		}
		generateTrees();
		removeTrees();
	}
	
	public static void addMessage(Message s) {
		messages.add(s);
	}
	
	public static void removeMessage(Message s) {
		messages.remove(s);
	}
	
	public static void addTree(Tree e) {
		trees.add(e);
	}
	
	public void removeTree(Tree e) {
		trees.remove(e);
	}
	
	public static void addStaticEntity(StaticEntity e) {
		staticEntities.add(e);
	}
	
	public void removeStaticEntity(StaticEntity e) {
		staticEntities.remove(e);
	}
	
	//---------------- useless getters and setters --------------

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
