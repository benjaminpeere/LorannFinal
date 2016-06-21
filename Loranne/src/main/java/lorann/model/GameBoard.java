package lorann.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String Game[][] = new String [24][24];
	int level = 1;
	int gold = 0;
	int lifes = 11;
	
	boolean shoot = false;
	boolean touch = false;
	boolean prisond1 = false;
	boolean prisond2 = false;
	boolean prisond3 = false;
	boolean prisond4 = false;

	private static ArrayList<Bone1> Bones1;
	private static ArrayList<Bone2> Bones2;
	private static ArrayList<Bone3> Bones3;
	private static ArrayList<CrystalBall> CrystalBalls;
	private static ArrayList<Purses> Pursess;
	private static ArrayList<Monster1> Monsters1;
	private static ArrayList<Monster2> Monsters2;
	private static ArrayList<Monster3> Monsters3;
	private static ArrayList<Monster4> Monsters4;
	private static ArrayList<OutDoor> OutDoors;
	private static ArrayList<FireBall> FireBalls;

	Bone1 bone1;
	Bone2 bone2;
	Bone3 bone3;
	Lorann lorann;
	CrystalBall crystalball;
	Purses purses;
	Monster1 monster1;
	Monster2 monster2;
	Monster3 monster3;
	Monster4 monster4;
	OutDoor outdoor;
	FireBall fireball;
	Font levelFont = new Font("SansSerif", Font.BOLD, 30);
	FileReader fr;

	public GameBoard (){
		this.setBackground(Color.BLACK);
		ChangeLevel();
		setFocusable(true);
		addKeyListener(this);
	}

	protected void ChangeLevel() {
		try{
			fr = new FileReader("Maps/level"+level+".level");
			int x=0, y=0, i=0;
			touch = false;
			shoot = false;
			prisond1 = false;
			prisond2 = false;
			prisond3 = false;
			prisond4 = false;


			Bones1 = new ArrayList<Bone1>();
			Bones2 = new ArrayList<Bone2>();
			Bones3 = new ArrayList<Bone3>();
			CrystalBalls = new ArrayList<CrystalBall>();
			Pursess = new ArrayList<Purses>();
			Monsters1 = new ArrayList<Monster1>();
			Monsters2 = new ArrayList<Monster2>();
			Monsters3 = new ArrayList<Monster3>();
			Monsters4 = new ArrayList<Monster4>();
			OutDoors = new ArrayList<OutDoor>();
			FireBalls = new ArrayList<FireBall>();


			while((i=fr.read()) != -1){
				char strImg = (char) i;

				if(strImg == '0'){
					Game [x][y] = "WALLS";
					bone1 = new Bone1(x*32, y*32);
					Bones1.add(bone1);
				}
				else if(strImg == '1'){
					Game [x][y] = "WALLS";
					bone2 = new Bone2(x*32, y*32);
					Bones2.add(bone2);
				}
				else if(strImg == '2'){
					Game [x][y] = "WALLS";
					bone3 = new Bone3(x*32, y*32);
					Bones3.add(bone3);
				}
				else if (strImg == '3'){
					Game [x][y] = "LORANN";
					lorann = new Lorann (x*32, y*32);
				}
				else if (strImg == '4'){
					Game [x][y] = "CRYSTALBALL";
					crystalball = new CrystalBall (x*32, y*32);
					CrystalBalls.add(crystalball);
				}
				else if (strImg == '5'){
					Game [x][y] = "PURSES";
					purses = new Purses (x*32, y*32);
					Pursess.add(purses);
				}
				else if(strImg == '6'){
					Game[x][y] = "MONSTER1";
					monster1 = new Monster1 (x*32,y*32);
					Monsters1.add(monster1);
				}
				else if(strImg == '7'){
					Game[x][y] = "MONSTER2";
					monster2 = new Monster2 (x*32,y*32);
					Monsters2.add(monster2);
				}
				else if(strImg == '8'){
					Game[x][y] = "MONSTER3";
					monster3 = new Monster3 (x*32,y*32);
					Monsters3.add(monster3);
				}
				else if(strImg == '9'){
					Game[x][y] = "MONSTER4";
					monster4 = new Monster4 (x*32,y*32);
					Monsters4.add(monster4);
				}
				else if(strImg == 'S'){
					Game[x][y] = "OUTDOOR";
					outdoor = new OutDoor (x*32,y*32);
					OutDoors.add(outdoor);
				}

				else if (strImg == ' '){
					Game[x][y] = null;
				}
				else if (strImg == '\r' || strImg == '\n'){
					x--;
				}
				if (x==23){
					y++;
					x=0;
				}
				else {
					x++;
				}

			}
		}
		catch(Exception ex){
			repaint();
		}
	}

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
		for(int i = 0; i< CrystalBalls.size(); i++){
			crystalball = (CrystalBall) CrystalBalls.get(i);
			g2d.drawImage(crystalball.getImage(), crystalball.getX(), crystalball.getY(), null);
		}
		for(int i = 0; i< Pursess.size(); i++){
			purses = (Purses) Pursess.get(i);
			g2d.drawImage(purses.getImage(), purses.getX(),purses.getY(), null);
		}
		for(int i = 0; i< Monsters1.size(); i++){
			monster1 = (Monster1) Monsters1.get(i);
			g2d.drawImage(monster1.getImage(), monster1.getX(),monster1.getY(), null);
		}
		for(int i = 0; i< Monsters2.size(); i++){
			monster2 = (Monster2) Monsters2.get(i);
			g2d.drawImage(monster2.getImage(), monster2.getX(),monster2.getY(), null);
		}
		for(int i = 0; i< Monsters3.size(); i++){
			monster3 = (Monster3) Monsters3.get(i);
			g2d.drawImage(monster3.getImage(), monster3.getX(),monster3.getY(), null);
		}
		for(int i = 0; i< Monsters4.size(); i++){
			monster4 = (Monster4) Monsters4.get(i);
			g2d.drawImage(monster4.getImage(), monster4.getX(),monster4.getY(), null);
		}
		for(int i = 0; i< FireBalls.size(); i++){
			fireball = (FireBall) FireBalls.get(i);
			g2d.drawImage(fireball.getImage(), fireball.getX(),fireball.getY(), null);
		}

		try{
			g2d.drawImage(lorann.getImage(), lorann.getX(), lorann.getY(), null);
			g2d.drawImage(outdoor.getImage(), outdoor.getX(), outdoor.getY(), null);
		}
		catch(Exception ex){}
		g.setColor(Color.RED);
		g.setFont(levelFont);
		g.drawString("LEVEL : " + level + " / Gold : " + gold + " / Lifes : " + lifes,240, 400);

		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		int Key = arg0.getKeyCode();
		int x=0;
		int y = 0;

		if (Key == KeyEvent.VK_S || Key == KeyEvent.VK_DOWN){
			if (! CheckCollision("DOWN")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("DOWN");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);

		}
		else if (Key == KeyEvent.VK_Z || Key == KeyEvent.VK_UP){
			if (! CheckCollision("UP")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("UP");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_D || Key == KeyEvent.VK_RIGHT){
			if (! CheckCollision("RIGHT")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("RIGHT");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_Q || Key == KeyEvent.VK_LEFT){
			if (! CheckCollision("LEFT")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("LEFT");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_A){
			if (! CheckCollision("UPLEFT")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("UPLEFT");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_E){
			if (! CheckCollision("UPRIGHT")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("UPRIGHT");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_W){
			if (! CheckCollision("DOWNLEFT")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("DONLEFT");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_X){
			if (! CheckCollision("DOWNRIGHT")){
				if (! MonsterEat(monster1)){
					if (! MonsterEat(monster2)){
						if (! MonsterEat(monster3)){
							if (! MonsterEat(monster4)){
								lorann.setDir("DOWNRIGHT");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			FollowShoot();
			if (! prisond1)
				pathToLorann1(monster1);
			if (! prisond2)
				pathToLorann2(monster2);
			if (! prisond3)
				pathToLorann3(monster3);
			if (! prisond4)
				pathToLorann4(monster4);
		}
		else if (Key == KeyEvent.VK_SPACE){

			if (shoot == false){
				shoot = true;
				fireball = new FireBall(x*32, y*32);
				FireBalls.add(fireball);
				Shoot();
			}
			else if (shoot == true){
				{
					FireBallRemove();
					touch = true;
				}
			}
		}
		else if (Key == KeyEvent.VK_R){
			ChangeLevel();
		}

		if (lifes == 0){
			if (JOptionPane.showConfirmDialog(this,"GAME OVER.\nTRY AG?","",JOptionPane.YES_NO_OPTION)  == JOptionPane.YES_OPTION) {
				gold = 0;
				lifes = 11;
				ChangeLevel();
			}
		}
		repaint();
	}

	public void Shoot(){

		if (shoot == true){
			if(lorann.getDir() == "DOWN"){
				fireball.setY(lorann.getY() - 32 );
				fireball.setX(lorann.getX());
				fireball.setDir("UP");
			}
			else if(lorann.getDir() == "UP"){
				fireball.setY(lorann.getY() + 32 );
				fireball.setX(lorann.getX());	
				fireball.setDir("DOWN");
			}
			else if(lorann.getDir() == "LEFT"){
				fireball.setY(lorann.getY());
				fireball.setX(lorann.getX() + 32);
				fireball.setDir("RIGHT");
			}
			else if(lorann.getDir() == "RIGHT"){
				fireball.setY(lorann.getY());
				fireball.setX(lorann.getX()- 32);	
				fireball.setDir("LEFT");
			}
			else if (lorann.getDir() == "DOWNRIGHT"){
				fireball.setY(lorann.getY() - 32 );
				fireball.setX(lorann.getX() - 32);	
				fireball.setDir("UPLEFT");
			}
			else if (lorann.getDir() == "DOWNLEFT"){
				fireball.setY(lorann.getY() - 32 );
				fireball.setX(lorann.getX() + 32);	
				fireball.setDir("UPRIGHT");
			}
			else if (lorann.getDir() == "UPRIGHT"){
				fireball.setY(lorann.getY() + 32 );
				fireball.setX(lorann.getX()- 32);	
				fireball.setDir("UPLEFT");
			}
			else if (lorann.getDir() == "UPLEFT"){
				fireball.setY(lorann.getY() + 32 );
				fireball.setX(lorann.getX() + 32);	
				fireball.setDir("DOWNRIGHT");
			}
		}

	}

	public void FollowShoot(){

		if (shoot == true){
			if (fireball.getDir() == "RIGHT"){
				if (CheckFireBall("RIGHT") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
			else if (fireball.getDir() == "LEFT"){

				if (CheckFireBall("LEFT") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
			else if (fireball.getDir() == "UP"){
				if (CheckFireBall("UP") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}

			}
			else if (fireball.getDir() == "DOWN"){
				if (CheckFireBall("DOWN") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
			else if (fireball.getDir() == "DOWNLEFT"){
				if (CheckFireBall("DOWNLEFT") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
			else if (fireball.getDir() == "DOWNRIGHT"){
				if (CheckFireBall("DOWNRIGHT") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
			else if (fireball.getDir() == "UPRIGHT"){
				if (CheckFireBall("UPRIGHT") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
			else if (fireball.getDir() == "UPLEFT"){
				if (CheckFireBall("UPLEFT") == false && touch == false){
					fireball.move();
				}
				else {
					touch = true;
				}

				if (touch == true){
					CheckFireBall(fireball.getDir());
					pathToLorann1(fireball);
					FireBallRemove();
				}
			}
		}
	}

	public boolean CheckCollision(String direction){
		Rectangle lorannRec;
		lorannRec = lorann.getBounds();
		if (direction == "RIGHT"){
			lorannRec.setBounds(lorannRec.x +32,lorannRec.y, lorannRec.width, lorannRec.height);
		}
		else if (direction == "LEFT"){
			lorannRec.setBounds(lorannRec.x -32,lorannRec.y, lorannRec.width, lorannRec.height);
		}
		else if (direction == "UP"){
			lorannRec.setBounds(lorannRec.x,lorannRec.y -32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "DOWN"){
			lorannRec.setBounds(lorannRec.x ,lorannRec.y +32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "DOWNLEFT"){
			lorannRec.setBounds(lorannRec.x - 32 ,lorannRec.y +32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "DOWNRIGHT"){
			lorannRec.setBounds(lorannRec.x + 32,lorannRec.y +32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "UPLEFT"){
			lorannRec.setBounds(lorannRec.x - 32,lorannRec.y - 32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "UPRIGHT"){
			lorannRec.setBounds(lorannRec.x + 32,lorannRec.y - 32, lorannRec.width, lorannRec.height);
		}

		for(int i=0;i<Bones1.size();i++){
			bone1 = (Bone1) Bones1.get(i);
			Rectangle bone1Rec = bone1.getBounds();
			if(lorannRec.intersects(bone1Rec)){
				return true;
			}
		}
		for(int i=0;i<Bones2.size();i++){
			bone2 = (Bone2) Bones2.get(i);
			Rectangle bone2Rec = bone2.getBounds();
			if(lorannRec.intersects(bone2Rec)){
				return true;
			}
		}
		for(int i=0;i<Bones3.size();i++){
			bone3 = (Bone3) Bones3.get(i);
			Rectangle bone3Rec = bone3.getBounds();
			if(lorannRec.intersects(bone3Rec)){
				return true;
			}
		}
		for (int i=0; i<FireBalls.size(); i++){
			fireball = (FireBall) FireBalls.get(i);
			Rectangle sortilegesRec = fireball.getBounds();
			if (lorannRec.intersects(sortilegesRec)){
				touch = false;
				shoot = false;
				fireball.setX(1000);
				fireball.setY(400);
			}
		}
		return false;
	}

	public boolean MonsterEat(Mobile mobile){
		Rectangle mobileRec;
		mobileRec = mobile.getBounds();
		if (mobile.getX()<lorann.getX()){
			mobileRec.setBounds(mobileRec.x +32,mobileRec.y, mobileRec.width, mobileRec.height);
		}
		else if (mobile.getX()>lorann.getX()){
			mobileRec.setBounds(mobileRec.x -32,mobileRec.y, mobileRec.width, mobileRec.height);
		}
		else if (mobile.getY()>lorann.getY()){
			mobileRec.setBounds(mobileRec.x,mobileRec.y -32, mobileRec.width, mobileRec.height);
		}
		else if (mobile.getY()<lorann.getY()){
			mobileRec.setBounds(mobileRec.x ,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}

		Rectangle lorannRec;
		lorannRec = lorann.getBounds();
		if(mobileRec.intersects(lorannRec)){
			lifes--;
			ChangeLevel();
			return true;
		}

		return false;
	}

	public boolean FireBallRemove(){
		Rectangle sortilegesRec;
		sortilegesRec = fireball.getBounds();
		if (fireball.getX()<lorann.getX()){
			sortilegesRec.setBounds(sortilegesRec.x +32,sortilegesRec.y, sortilegesRec.width, sortilegesRec.height);
		}
		else if (fireball.getX()>lorann.getX()){
			sortilegesRec.setBounds(sortilegesRec.x -32,sortilegesRec.y, sortilegesRec.width, sortilegesRec.height);
		}
		else if (fireball.getY()>lorann.getY()){
			sortilegesRec.setBounds(sortilegesRec.x,sortilegesRec.y -32, sortilegesRec.width, sortilegesRec.height);
		}
		else if (fireball.getY()<lorann.getY()){
			sortilegesRec.setBounds(sortilegesRec.x ,sortilegesRec.y +32, sortilegesRec.width, sortilegesRec.height);
		}

		Rectangle lorannRec;
		lorannRec = lorann.getBounds();
		if(sortilegesRec.intersects(lorannRec)){
			touch = false;
			shoot = false;
			fireball.setX(1000);
			fireball.setY(400);
			FireBalls.remove(0);
			return true;
		}
		return false;
	}

	public void Objectif(){
		Rectangle lorannRec;
		lorannRec = lorann.getBounds();
		for(int i=0;i<Pursess.size();i++){
			purses = (Purses) Pursess.get(i);
			Rectangle boursesRec = purses.getBounds();

			if(lorannRec.intersects(boursesRec)){
				Pursess.remove(i);
				gold = gold + 100;
				break;
			}
		}

		for (int i=0;i<CrystalBalls.size();i++){
			crystalball = (CrystalBall) CrystalBalls.get(i);
			Rectangle objectifRec = crystalball.getBounds();
			if (lorannRec.intersects(objectifRec)){
				CrystalBalls.remove(i);
				outdoor.setEtat("OPEN");
			}
		}

		for(int i=0; i<OutDoors.size(); i++){
			outdoor =(OutDoor) OutDoors.get(i);
			Rectangle ouvertRec = outdoor.getBounds();

			if(lorannRec.intersects(ouvertRec)){
				level++;
				if (outdoor.getEtat() == "CLOSED")
					lifes--;
				ChangeLevel();
			}
		}
	}

	public boolean MonsterCollision(String direction, Mobile mobile){
		Rectangle mobileRec;
		mobileRec = mobile.getBounds();


		if (direction == "RIGHT"){
			mobileRec.setBounds(mobileRec.x +32,mobileRec.y, mobileRec.width, mobileRec.height);
		}
		else if (direction == "LEFT"){
			mobileRec.setBounds(mobileRec.x -32, mobileRec.y, mobileRec.width, mobileRec.height);
		}
		else if (direction == "UP"){
			mobileRec.setBounds(mobileRec.x,mobileRec.y -32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "DOWN"){
			mobileRec.setBounds(mobileRec.x ,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "DOWNLEFT"){
			mobileRec.setBounds(mobileRec.x - 32 ,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "DOWNRIGHT"){
			mobileRec.setBounds(mobileRec.x + 32,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "UPLEFT"){
			mobileRec.setBounds(mobileRec.x - 32,mobileRec.y - 32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "UPRIGHT"){
			mobileRec.setBounds(mobileRec.x + 32,mobileRec.y - 32, mobileRec.width, mobileRec.height);
		}

		for(int i=0;i<Bones1.size();i++){
			bone1 = (Bone1) Bones1.get(i);
			Rectangle bone1Rec = bone1.getBounds();
			if(mobileRec.intersects(bone1Rec)){
				return true;
			}
		}
		for(int i=0;i<Bones2.size();i++){
			bone2 = (Bone2) Bones2.get(i);
			Rectangle bone2Rec = bone2.getBounds();
			if(mobileRec.intersects(bone2Rec)){
				return true;
			}
		}
		for(int i=0;i<Bones3.size();i++){
			bone3 = (Bone3) Bones3.get(i);
			Rectangle bone3Rec = bone3.getBounds();
			if(mobileRec.intersects(bone3Rec)){
				return true;
			}
		}
		for(int i=0;i<Monsters1.size();i++){
			monster1 = (Monster1) Monsters1.get(i);
			Rectangle monster1Rec = monster1.getBounds();
			if(mobileRec.intersects(monster1Rec)){
				return true;
			}
		}
		for(int i=0;i<Monsters2.size();i++){
			monster2 = (Monster2) Monsters2.get(i);
			Rectangle monster2Rec = monster2.getBounds();
			if(mobileRec.intersects(monster2Rec)){
				return true;
			}
		}
		for(int i=0;i<Monsters3.size();i++){
			monster3 = (Monster3) Monsters3.get(i);
			Rectangle monster3Rec = monster3.getBounds();
			if(mobileRec.intersects(monster3Rec)){
				return true;
			}
		}
		for(int i=0;i<Monsters4.size();i++){
			monster4 = (Monster4) Monsters4.get(i);
			Rectangle monster4Rec = monster4.getBounds();
			if(mobileRec.intersects(monster4Rec)){
				return true;
			}
		}


			if (mobile == monster1){
				for (int i=0; i<FireBalls.size(); i++){
					fireball = (FireBall) FireBalls.get(i);
					Rectangle sortilegesRec = fireball.getBounds();
					if (mobileRec.intersects(sortilegesRec)){
						touch = true;
						prisond1 = true;
						monster1.setX(33);
						monster1.setY(385);
						Monsters1.remove(0);
						return true;
					}
				}
			}

			else if (mobile == monster2){
				for (int i=0; i<FireBalls.size(); i++){
					fireball = (FireBall) FireBalls.get(i);
					Rectangle sortilegesRec = fireball.getBounds();
					if (mobileRec.intersects(sortilegesRec)){
						touch = true;
						prisond2 = true;
						monster2.setX(97);
						monster2.setY(385);
						Monsters2.remove(0);
						return true;
					}
				}
			}
			else if (mobile == monster3){
				for (int i=0; i<FireBalls.size(); i++){
					fireball = (FireBall) FireBalls.get(i);
					Rectangle sortilegesRec = fireball.getBounds();
					if (mobileRec.intersects(sortilegesRec)){
						touch = true;
						prisond3 = true;
						monster3.setX(161);
						monster3.setY(385);
						Monsters3.remove(0);
						return true;
					}
				}
			}
			else if (mobile == monster4){
				for (int i=0; i<FireBalls.size(); i++){
					fireball = (FireBall) FireBalls.get(i);
					Rectangle sortilegesRec = fireball.getBounds();
					if (mobileRec.intersects(sortilegesRec)){
						touch = true;
						prisond4 = true;
						monster4.setX(225);
						monster4.setY(385);
						Monsters4.remove(0);
						return true;
					}
				}
			}
		return false;
	}

	public boolean CheckFireBall(String direction){

		if (shoot == true){
			Rectangle sortilegesRec;
			sortilegesRec = fireball.getBounds();

			if (direction == "RIGHT"){
				sortilegesRec.setBounds(sortilegesRec.x +32,sortilegesRec.y, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "LEFT"){
				sortilegesRec.setBounds(sortilegesRec.x -32, sortilegesRec.y, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "UP"){
				sortilegesRec.setBounds(sortilegesRec.x,sortilegesRec.y -32, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "DOWN"){
				sortilegesRec.setBounds(sortilegesRec.x ,sortilegesRec.y +32, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "DOWNLEFT"){
				sortilegesRec.setBounds(sortilegesRec.x - 32 ,sortilegesRec.y +32, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "DOWNRIGHT"){
				sortilegesRec.setBounds(sortilegesRec.x + 32,sortilegesRec.y +32, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "UPLEFT"){
				sortilegesRec.setBounds(sortilegesRec.x - 32,sortilegesRec.y - 32, sortilegesRec.width, sortilegesRec.height);
			}
			else if (direction == "UPRIGHT"){
				sortilegesRec.setBounds(sortilegesRec.x + 32,sortilegesRec.y - 32, sortilegesRec.width, sortilegesRec.height);
			}

			for(int i=0;i<Bones1.size();i++){
				bone1 = (Bone1) Bones1.get(i);
				Rectangle bone1Rec = bone1.getBounds();
				if(sortilegesRec.intersects(bone1Rec)){
					return true;
				}
			}
			for(int i=0;i<Bones2.size();i++){
				bone2 = (Bone2) Bones2.get(i);
				Rectangle bone2Rec = bone2.getBounds();
				if(sortilegesRec.intersects(bone2Rec)){
					return true;
				}
			}
			for(int i=0;i<Bones3.size();i++){
				bone3 = (Bone3) Bones3.get(i);
				Rectangle bone3Rec = bone3.getBounds();
				if(sortilegesRec.intersects(bone3Rec)){
					return true;
				}
			}

				for(int i=0;i<Monsters1.size();i++){
					monster1 = (Monster1) Monsters1.get(i);
					Rectangle monster1Rec = monster1.getBounds();
					if(sortilegesRec.intersects(monster1Rec)){
						touch = true;
						prisond1 = true;
						monster1.setX(33);
						monster1.setY(385);
						Monsters1.remove(0);
						return true;
					}
				}

				for(int i=0;i<Monsters2.size();i++){
					monster2 = (Monster2) Monsters2.get(i);
					Rectangle monster2Rec = monster2.getBounds();
					if(sortilegesRec.intersects(monster2Rec)){
						touch = true;
						prisond2 = true;
						monster2.setX(97);
						monster2.setY(385);
						Monsters2.remove(0);
						return true;
					}
				}

				for(int i=0;i<Monsters3.size();i++){
					monster3 = (Monster3) Monsters3.get(i);
					Rectangle monster3Rec = monster3.getBounds();
					if(sortilegesRec.intersects(monster3Rec)){
						touch = true;
						prisond3 = true;
						monster3.setX(161);
						monster3.setY(385);
						Monsters3.remove(0);
						return true;
					}
				}
				for(int i=0;i<Monsters4.size();i++){
					monster4 = (Monster4) Monsters4.get(i);
					Rectangle monster4Rec = monster4.getBounds();
					if(sortilegesRec.intersects(monster4Rec)){
						touch = true;
						prisond4 = true;
						monster4.setX(225);
						monster4.setY(385);
						Monsters4.remove(0);
						return true;
					}
				}
			
		}
		return false;
	}

	public void pathToLorann1(Mobile mobile){

		int PlusRapide;
		PlusRapide = 1500;

		if (! MonsterCollision("UPLEFT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32))) /*&& ! MonsterCollision("UPLEFT",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("UPLEFT");
			}
		}
		if(! MonsterCollision("UPRIGHT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32))) /*&& ! MonsterCollision("UPRIGHT",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("UPRIGHT");
			}
		}
		if(! MonsterCollision("DOWNLEFT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32))) /*&& ! MonsterCollision("DOWNLEFT",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("DOWNLEFT");
			}
		}
		if(! MonsterCollision("DOWNRIGHT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32))) /*&& ! MonsterCollision("DOWNRIGHT",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("DOWNRIGHT");
			}
		}

		if (! MonsterCollision("DOWN",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()+32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("DOWN");
			}
		}

		if (! MonsterCollision("LEFT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+0)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+0)));
				mobile.setDir("LEFT");
			}
		}

		if (! MonsterCollision("UP",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()-32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("UP");
			}
		}

		if (! MonsterCollision("RIGHT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+0)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+0)));
				mobile.setDir("RIGHT");
			}
		}


		switch (mobile.getDir()){

		case "UPLEFT" :
			mobile.move();
			break;

		case "UPRIGHT" : 
			mobile.move();
			break;

		case "DOWNLEFT" : 
			mobile.move();
			break;

		case "DOWNRIGHT" : 
			mobile.move();
			break;

		case "DOWN" : 
			mobile.move();
			break;

		case "LEFT" : 
			mobile.move();
			break;

		case "UP" : 
			mobile.move();
			break;

		case "RIGHT" :
			mobile.move();
			break;

		default: 
			break;
		}
	}


	public void pathToLorann2(Mobile mobile){

		int PlusRapide;
		PlusRapide = 1500;

		if (! MonsterCollision("UPLEFT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("UPLEFT");
			}
		}
		if(! MonsterCollision("UPRIGHT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("UPRIGHT");
			}
		}
		if(! MonsterCollision("DOWNLEFT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("DOWNLEFT");
			}
		}
		if(! MonsterCollision("DOWNRIGHT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("DOWNRIGHT");
			}
		}

		switch (mobile.getDir()){

		case "UPLEFT" :
			mobile.move();
			break;

		case "UPRIGHT" : 
			mobile.move();
			break;

		case "DOWNLEFT" : 
			mobile.move();
			break;

		case "DOWNRIGHT" : 
			mobile.move();
			break;

		default: 
			break;
		}
	}

	public void pathToLorann3(Mobile mobile){
		if(mobile.getX()<lorann.getX()){
			if (! MonsterCollision("RIGHT", mobile)) {
				mobile.setDir("RIGHT");
				mobile.move();
			}
		}
		else if(mobile.getX()>lorann.getX()){
			if (! MonsterCollision("LEFT", mobile)) {
				mobile.setDir("LEFT");
				mobile.move();
			}
		}
		else if (mobile.getX() == lorann.getX()){
			if(mobile.getY()>lorann.getY()){
				if (! MonsterCollision("UP", mobile)) {
					mobile.setDir("UP");
					mobile.move();
				}
			}
			else if(mobile.getY()<lorann.getY()){
				if (! MonsterCollision("DOWN", mobile)) {
					mobile.setDir("DOWN");
					mobile.move();
				}
			}
		}
	}

	public void pathToLorann4(Mobile mobile){

		if(mobile.getY()<lorann.getY()){
			if (! MonsterCollision("DOWN", mobile)) {
				mobile.setDir("DOWN");
				mobile.move();
			}
		}
		else if(mobile.getY()>lorann.getY()){
			if (! MonsterCollision("UP", mobile)) {
				mobile.setDir("UP");
				mobile.move();
			}
		}
		else if (mobile.getY() == lorann.getY()){
			if(mobile.getX()>lorann.getX()){
				if (! MonsterCollision("LEFT", mobile)) {
					mobile.setDir("LEFT");
					mobile.move();
				}
			}
			else if(mobile.getY()<lorann.getY()){
				if (! MonsterCollision("RIGHT", mobile)) {
					mobile.setDir("RIGHT");
					mobile.move();
				}
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}