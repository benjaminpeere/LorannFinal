package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * |##################################################|
 * |Lorann is the hero,he should across 101 level to  |
 * |liberate the world of nova-Ann to Nekron!!!		  |
 * |Lorann can use a fireball to kill demons		  |
 * |##################################################|
 */
public class Lorann extends Mobile {
	public static Object lorann;
	/**
	 * |########################################|
	 * | define the different images of lorann	|
	 * |########################################|
	 */
	Image LorannImg;
	ImageIcon iLorannDown = new ImageIcon("Images/lorann_b.png");
	ImageIcon iLorannDownLeft = new ImageIcon("Images/lorann_bl.png");
	ImageIcon iLorannDownRight = new ImageIcon("Images/lorann_br.png");
	ImageIcon iLorannRight = new ImageIcon("Images/lorann_r.png");
	ImageIcon iLorannLeft = new ImageIcon("Images/lorann_l.png");
	ImageIcon iLorannUp = new ImageIcon("Images/lorann_u.png");
	ImageIcon iLorannUpLeft = new ImageIcon("Images/lorann_ul.png");
	ImageIcon iLorannUpRight = new ImageIcon("Images/lorann_ur.png");
	/**
	 * |##################|
	 * |constructor Lorann|
	 * |@param Startx	  |
	 * |@param Starty	  |
	 * |##################|
	 */
	public Lorann(int Startx,int Starty){
		this.x = Startx;
		this.y = Starty;
		
		ImageIcon iLorannImg = new ImageIcon("Images/lorann_b.png");
		LorannImg = iLorannImg.getImage();
	}
	/**
	 * |########################################################|
	 * |define an image for Lorann in function of his movements |
	 * |@return LorannImg										|
	 * |########################################################| 
	 */	
	public Image getImage(){
		if(this.getDir() == "DOWN"){ //on fait ça pour donner la bonne image de lorann en fonction du déplacement
			LorannImg = iLorannDown.getImage();
		}
		else if (this.getDir() == "DOWNLEFT"){
			LorannImg = iLorannDownLeft.getImage();
		}
		else if (this.getDir() == "DOWNRIGHT"){
			LorannImg = iLorannDownRight.getImage();
		}
		else if (this.getDir() == "RIGHT"){
			LorannImg = iLorannRight.getImage();
		}
		else if (this.getDir() == "LEFT"){
			LorannImg = iLorannLeft.getImage();
		}
		else if (this.getDir() == "UP"){
			LorannImg = iLorannUp.getImage();
		}
		else if (this.getDir() == "UPLEFT"){
			LorannImg = iLorannUpLeft.getImage();
		}
		else if (this.getDir() == "UPRIGHT"){
			LorannImg = iLorannUpRight.getImage();
		}
		return LorannImg;
	}
	
}
