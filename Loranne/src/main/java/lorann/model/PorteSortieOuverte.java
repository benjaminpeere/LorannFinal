package lorann.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PorteSortieOuverte {

	int x,y;

	Image PorteSortieOuverte;
	
	

	public PorteSortieOuverte(int Startx, int Starty){
		x = Startx;
		y = Starty; 
		
		ImageIcon iPorteSortieOuverte = new ImageIcon("Images/gate_open.png");
		PorteSortieOuverte = iPorteSortieOuverte.getImage();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public Image getImage(){
		
		return PorteSortieOuverte;
	}

	public Rectangle getBounds() {
		Rectangle Box = new Rectangle(x,y,32,32);
		return Box;
		
	}
}
