package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Porte_sortie {

	int x,y;
	String Etat = "FERME";
	Image Porte;
	ImageIcon iGateClosed = new ImageIcon("Images/gate_closed.png");
	ImageIcon iGateOpen = new ImageIcon ("Image/gate_open.png");
	boolean porteouverte = false;

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
	
	public void setEtat (String newEtat){
		this.Etat = newEtat;
	}
	public Image getImage(){
		if (Etat == "FERME"){
			Porte = iGateClosed.getImage();
		}
		else if(Etat == "OUVERT"){
			Porte = iGateOpen.getImage();
		}
		return Porte;
	}
}
