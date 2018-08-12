package vlas.ld42.gr.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private static boolean[] keys;
	private static boolean[] pressed;
	private static boolean[] cantPress;
	public static boolean jump, right, left, pick, set, down, enter;
	
	public Keyboard(){
		keys = new boolean[256];
		pressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public static boolean CantPress(int key) {
		return cantPress[key];
	}
	
	public static boolean Pressed(int key) {
		return pressed[key];
	}
	
	public void update(){
		for(int i = 0;i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i] = false;
			}else if(pressed[i]){
				cantPress[i] = true;
				pressed[i] = false;
			}
			if(!cantPress[i] && keys[i]){
				pressed[i] = true;
			}
		}
		
		jump = keys[KeyEvent.VK_UP];
		right = keys[KeyEvent.VK_RIGHT];
		left = keys[KeyEvent.VK_LEFT];
		pick = keys[KeyEvent.VK_Z];
		set = keys[KeyEvent.VK_X];
		down = keys[KeyEvent.VK_DOWN];
		enter = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
