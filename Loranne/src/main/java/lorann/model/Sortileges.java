package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sortileges extends Mobile{
	int x,y;
	Image Sortileges;
	ImageIcon iSortileges = new ImageIcon("Images/fireball_1.png");
	
	public Sortileges(int Startx, int Starty){
		x = Startx;
		y = Starty;		
	}
	
	public Image getImage(){
		return Sortileges;
	}
}