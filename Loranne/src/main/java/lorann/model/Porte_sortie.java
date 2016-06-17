package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Porte_sortie extends NonMobile {
	
	Image Porte;

	public Porte_sortie (int Startx, int Starty){
		x = Startx;
		y = Starty; 
		
		ImageIcon iPorte = new ImageIcon("Images/gate_closed.png");
		Porte = iPorte.getImage();
	}
	
	public Image getImage(){
		
		return Porte;
	}
}
