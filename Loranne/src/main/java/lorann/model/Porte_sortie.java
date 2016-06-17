package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Porte_sortie {

	int x,y;
	
	Image Porte;
	
	

	public Porte_sortie (int Startx, int Starty){
		x = Startx;
		y = Starty; 
		
		ImageIcon iPorte = new ImageIcon("Images/gate_closed.png");
		Porte = iPorte.getImage();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
	public Image getImage(){
		
		return Porte;
	}
}
