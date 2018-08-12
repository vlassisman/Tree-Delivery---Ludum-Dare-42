package vlas.ld42.gr.gfx.Sound;

import java.applet.Applet;
import java.applet.AudioClip;


public class Sound {

public static final Sound choosing = new Sound("/audio/choosing.wav");
public static final Sound select = new Sound("/audio/select.wav");
public static final Sound jump = new Sound("/audio/jump.wav");
public static final Sound delivered = new Sound("/audio/delivered.wav");
public static final Sound page = new Sound("/audio/page.wav");
public static final Sound walking = new Sound("/audio/walking.wav");
public static final Sound pick = new Sound("/audio/pick.wav");
public static final Sound holyN = new Sound("/audio/holyN.wav");
public static final Sound elato = new Sound("/audio/elato.wav");
public static final Sound kav = new Sound("/audio/kav.wav");
	
	private AudioClip sound;
	
	private Sound(String path) {
		sound = Applet.newAudioClip(Sound.class.getResource(path));
	}
	
	public void play(boolean loop) {
		if(loop) {
			sound.loop();
		}else {
			sound.play();
		}
	}
	
	public void stop() {
		sound.stop();
	}
	
}
