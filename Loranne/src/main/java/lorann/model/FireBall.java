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
	int StateFireBall = 0;
	
	ImageIcon iFireBall1 = new ImageIcon("Images/fireball_1.png");
	ImageIcon iFireBall2 = new ImageIcon("Images/fireball_2.png");
	ImageIcon iFireBall3 = new ImageIcon("Images/fireball_3.png");
	ImageIcon iFireBall4 = new ImageIcon("Images/fireball_4.png");
	ImageIcon iFireBall5 = new ImageIcon("Images/fireball_5.png");

	public FireBall(int Startx, int Starty){
		x = Startx;
		y = Starty;

		ImageIcon iFireball = new ImageIcon("Images/fireball_1.png");
		Fireball = iFireball.getImage();
	}

	public Image getImage(){
		if (StateFireBall == 0){
			Fireball = iFireBall1.getImage();
		}
		else if (StateFireBall == 1){
			Fireball = iFireBall2.getImage();
		}
		else if (StateFireBall == 2){
			Fireball = iFireBall3.getImage();
		}
		else if (StateFireBall == 4){
			Fireball = iFireBall4.getImage();
		}
		else if (StateFireBall == 5){
			Fireball = iFireBall5.getImage();
		}
		return Fireball;
	}
}