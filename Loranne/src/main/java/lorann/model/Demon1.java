package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Demon1 extends Mobile {

	Image Demon1;

	public Demon1(int Startx, int Starty){
		x = Startx;
		y = Starty;
		
		ImageIcon iDemon1 = new ImageIcon("Images/monster_1.png");
		Demon1 = iDemon1.getImage();
	}


	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage(){
		return Demon1;
	}
}
