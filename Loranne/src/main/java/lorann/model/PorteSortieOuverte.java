package lorann.model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class PorteSortieOuverte extends NonMobileFranchissable{

	Image PorteSortieOuverte;
	
	public PorteSortieOuverte(int Startx, int Starty){
		x = Startx;
		y = Starty; 
		
		ImageIcon iPorteSortieOuverte = new ImageIcon("Images/gate_open.png");
		PorteSortieOuverte = iPorteSortieOuverte.getImage();
	}

	public Image getImage(){
		
		return PorteSortieOuverte;
	}

}
