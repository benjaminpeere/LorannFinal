package lorann.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Porte_sortie {

	int x,y;

	Image Porte;

	String Etat = "FERME";
	ImageIcon iPorte = new ImageIcon("Images/gate_closed.png");
	ImageIcon iPorteSortieOuverte = new ImageIcon("Images/gate_open.png");


	public Porte_sortie (int Startx, int Starty){
		x = Startx;
		y = Starty;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public Rectangle getBounds() {
		Rectangle Box = new Rectangle(x,y,32,32);
		return Box;
	}
	public void setEtat (String newEtat){
		this.Etat = newEtat;
	}
	public Image getImage(){
		if(Etat == "FERME"){
			Porte = iPorte.getImage();
		}
		else if (Etat == "OUVERT"){
			Porte = iPorteSortieOuverte.getImage();
		}
		return Porte;

	}
}
