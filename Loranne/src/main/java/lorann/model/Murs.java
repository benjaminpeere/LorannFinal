package lorann.model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Murs extends NonMobile{

	Image Bone;
	ImageIcon iMur = new ImageIcon("Images/bone.png");
	ImageIcon iMurHorizon = new ImageIcon("Images/horizontal_bone.png");
	ImageIcon iMurVerti = new ImageIcon("Images/vertical_bone.png");


	public Murs(int Startx, int Starty){

		this.x = Startx;
		this.y = Starty;
	}

	public Image getImage(){
			Bone = iMurVerti.getImage();
			Bone = iMurHorizon.getImage();
			Bone = iMur.getImage();
		
		return Bone;
	}

}


