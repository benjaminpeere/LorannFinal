package lorann.model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bone3 extends Murs{
	
	Image bone3;
	
	public Bone3(int Startx, int Starty){

		this.x = Startx;
		this.y = Starty;
		
		ImageIcon ibone3Img = new ImageIcon("Images/vertical_bone.png");
		bone3= ibone3Img.getImage();
	}
	
	public Image getImage(){
		return bone3;
	}
}
