package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Lorann extends Mobile {
	public static Object lorann;

	
	Image LorannImg;
	ImageIcon iLorannBas = new ImageIcon("Images/lorann_b.png");
	ImageIcon iLorannBasGauche = new ImageIcon("Images/lorann_bl.png");
	ImageIcon iLorannBasDroite = new ImageIcon("Images/lorann_br.png");
	ImageIcon iLorannDroite = new ImageIcon("Images/lorann_r.png");
	ImageIcon iLorannGauche = new ImageIcon("Images/lorann_l.png");
	ImageIcon iLorannHaut = new ImageIcon("Images/lorann_u.png");
	ImageIcon iLorannHautGauche = new ImageIcon("Images/lorann_ul.png");
	ImageIcon iLorannHautDroite = new ImageIcon("Images/lorann_ur.png");
	

	public Lorann(int Startx,int Starty){
		this.x = Startx;
		this.y = Starty;
		
		ImageIcon iLorannImg = new ImageIcon("Images/lorann_b.png");
		LorannImg = iLorannImg.getImage();
	}
	
	public Image getImage(){
		if(this.getDir() == "BAS"){ //on fait ça pour donner la bonne image de lorann en fonction du déplacement
			LorannImg = iLorannBas.getImage();
		}
		else if (this.getDir() == "BASGAUCHE"){
			LorannImg = iLorannBasGauche.getImage();
		}
		else if (this.getDir() == "BASDROITE"){
			LorannImg = iLorannBasDroite.getImage();
		}
		else if (this.getDir() == "DROITE"){
			LorannImg = iLorannDroite.getImage();
		}
		else if (this.getDir() == "GAUCHE"){
			LorannImg = iLorannGauche.getImage();
		}
		else if (this.getDir() == "HAUT"){
			LorannImg = iLorannHaut.getImage();
		}
		else if (this.getDir() == "HAUTGAUCHE"){
			LorannImg = iLorannHautGauche.getImage();
		}
		else if (this.getDir() == "HAUTDROITE"){
			LorannImg = iLorannHautDroite.getImage();
		}
		return LorannImg;
	}
	
}
