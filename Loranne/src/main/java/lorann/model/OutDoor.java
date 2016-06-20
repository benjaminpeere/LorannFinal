package lorann.model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class OutDoor {

	int x,y;

	Image Door;
	/**
	 * |######################################|
	 * |define the door's state and her image |
	 * |######################################| 
	 
	 */
	String State = "CLOSED";
	ImageIcon iDoor = new ImageIcon("Images/gate_closed.png");
	ImageIcon iDoorOpen = new ImageIcon("Images/gate_open.png");

	/**
	 * |#################|
	 * |constructor door |
	 * |@param Startx	 |
	 * |@param Starty	 |
	 * |#################| 
	 */
	public OutDoor (int Startx, int Starty){
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
		return State;
	}

	public void setEtat (String newState){
		this.State = newState;
	}
	/**
 * |##########################|
 * |switch door's Image       |
 * |@return Door		  	  |
 * |##########################|
	 */
	public Image getImage(){
		if(State == "CLOSED"){
			Door = iDoor.getImage();
		}
		else if (State == "OPEN"){
			Door = iDoorOpen.getImage();
		}
		return Door;

	}
}
