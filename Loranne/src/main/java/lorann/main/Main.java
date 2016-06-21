package lorann.main;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main {

	public static void main (String[] args){
		@SuppressWarnings("unused")
		lorann.view.ViewFrame frm = new lorann.view.ViewFrame();
		
		File Clap = new File("Music/SonLorann.wav");
		PlaySound(Clap);
	}
	
	static void PlaySound(File Sound){
		try{
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			//Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e){
			
		}
	}
}
