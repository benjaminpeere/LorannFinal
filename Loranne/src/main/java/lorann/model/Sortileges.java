package lorann.model;

import java.awt.Image;


import javax.swing.ImageIcon;

public class Sortileges extends Mobile{

	Image Sortileges;

	public Sortileges(int Startx, int Starty){
		x = Startx;
		y = Starty;

		ImageIcon iSortileges = new ImageIcon("Images/fireball_1.png");
		Sortileges = iSortileges.getImage();
	}

	public Image getImage(){
		return Sortileges;
	}
}