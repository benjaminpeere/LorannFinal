package lorann.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Porte_sortie {

	int x,y;

	Image Porte;
	/**
	 * |######################################|
	 * |define the door's state and her image |
	 * |######################################| 
	 
	 */
	String Etat = "FERME";
	ImageIcon iPorte = new ImageIcon("Images/gate_closed.png");
	ImageIcon iPorteSortieOuverte = new ImageIcon("Images/gate_open.png");

	/**
	 * |#################|
	 * |constructor door |
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public Porte_sortie (int Startx, int Starty){
		x = Startx;
		y = Starty;

	}

	public int getX() {
		return x;
	}
	/**
	 * |##########################|
	 * |define position x and y   |
	 * |@return X and Y		  	  |
	 * |##########################| 
	 */
	public int getY() {
		return y;
	}
	/**
 * |##########################|
 * |define position hitbox    |
 * |@return box			  	  |
 * |##########################| 
 */
	public Rectangle getBounds() {
		Rectangle Box = new Rectangle(x,y,32,32);
		return Box;
	}
	/**
 * |####################################|
 * |define position state of the door   |
 * |@return state		  		  	    |
 * |####################################| 
	 * @return
	 */
	public String getEtat() {
		return Etat;
	}

	public void setEtat (String newEtat){
		this.Etat = newEtat;
	}
	/**
 * |##########################|
 * |switch door's Image       |
 * |@return Door		  	  |
 * |##########################|
	 */
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
