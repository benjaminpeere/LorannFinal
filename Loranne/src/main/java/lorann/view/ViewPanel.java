/*package lorann.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import lorann.model.GameBoard;

public class ViewPanel extends JPanel{
	public void paint (Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		for(int i = 0; i< Bones1.size(); i++){
			bone1 = (Bone1) Bones1.get(i);
			g2d.drawImage(bone1.getImage(), bone1.getX(), bone1.getY(), null);
		}
		for(int i = 0; i< Bones2.size(); i++){
			bone2 = (Bone2) Bones2.get(i);
			g2d.drawImage(bone2.getImage(), bone2.getX(), bone2.getY(), null);
		}
		for(int i = 0; i< Bones3.size(); i++){
			bone3 = (Bone3) Bones3.get(i);
			g2d.drawImage(bone3.getImage(), bone3.getX(), bone3.getY(), null);
		}
		for(int i = 0; i< Bulles.size(); i++){
			bulle = (Bulle) Bulles.get(i);
			g2d.drawImage(bulle.getImage(), bulle.getX(), bulle.getY(), null);
		}
		for(int i = 0; i< Boursess.size(); i++){
			bourses = (Bourses) Boursess.get(i);
			g2d.drawImage(bourses.getImage(), bourses.getX(),bourses.getY(), null);
		}
		try{
			g2d.drawImage(lorann.getImage(), lorann.getX(), lorann.getY(), null);
			g2d.drawImage(demon1.getImage(), demon1.getX(), demon1.getY(), null);
			g2d.drawImage(demon2.getImage(), demon2.getX(), demon2.getY(), null);
			g2d.drawImage(demon3.getImage(), demon3.getX(), demon3.getY(), null);
			g2d.drawImage(demon4.getImage(), demon4.getX(), demon4.getY(), null);
			g2d.drawImage(portesortie.getImage(), portesortie.getX(), portesortie.getY(), null);
		}
		catch(Exception ex){
			g.setColor(Color.BLACK);
			g.setFont(levelFont);
			g.drawString("LEVEL : " + level,10, 25);
		}
		repaint();
	}
}
*/