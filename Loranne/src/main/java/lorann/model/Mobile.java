package lorann.model;

import java.awt.Rectangle;

public class Mobile {


	public int x,y;
	public String direction = "BAS";

	public Rectangle getBounds(){ //pour les collision
		Rectangle Box = new Rectangle(x,y,32,32);
		return Box;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDir() {
		return direction;
	}

	public void setDir(String direction) {
		this.direction = direction;
	}

	public void move() {
		switch (this.getDir()) {
			case "HAUT":
				this.moveUp();
				break;
			case "DROITE":
				this.moveRight();
				break;
			case "BAS":
				this.moveDown();
				break;
			case "GAUCHE":
				this.moveLeft();
				break;
			default:
				break;
		}
	}
	

	void moveUp() {
		this.setY(getY() - 32 );
	}

	void moveRight() {
		this.setX(getX() + 32);
	}

	void moveDown() {
		this.setY(getY() + 32 );
	}

	void moveLeft() {
		this.setX(getX() - 32 );
	}
	
	void moveUpRight() {
		this.setY(getY() - 32 );
		this.setX(getX() + 32);
	}

	void moveDownRight() {
		this.setX(getX() + 32);
		this.setY(getY() + 32 );
	}

	void moveDownLeft() {
		this.setY(getY() + 32 );
		this.setX(getX() - 32 );
	}

	void moveUpLeft() {
		this.setY(getY() - 32 );
		this.setX(getX() - 32 );
	}
}
