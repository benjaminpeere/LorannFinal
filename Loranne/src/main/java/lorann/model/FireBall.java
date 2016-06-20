package lorann.model;
/**
 * |######################################|
 * |the Fireball is the Lorann's weapon	  |
 * |she can kill the differents demons	  |
 * |######################################| 
 */
import java.awt.Image;


import javax.swing.ImageIcon;

public class FireBall extends Mobile{

	Image Fireball;

	public FireBall(int Startx, int Starty){
		x = Startx;
		y = Starty;

		ImageIcon iFireball = new ImageIcon("Images/fireball_1.png");
		Fireball = iFireball.getImage();
	}

	public Image getImage(){
		return Fireball;
	}
}