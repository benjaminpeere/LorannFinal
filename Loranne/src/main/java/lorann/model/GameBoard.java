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
	String Game[][] = new String [24][12];
	int level = 1;
	int or = 0;
	int vies = 11;
	boolean shoot = false;
	
	private static ArrayList<Bone1> Bones1;
	private static ArrayList<Bone2> Bones2;
	private static ArrayList<Bone3> Bones3;
	private static ArrayList<Bulle> Bulles;
	private static ArrayList<Bourses> Boursess;
	private static ArrayList<Demon1> Demons1;
	private static ArrayList<Demon2> Demons2;
	private static ArrayList<Demon3> Demons3;
	private static ArrayList<Demon4> Demons4;
	private static ArrayList<Porte_sortie> PorteSorties;
	private static ArrayList<Sortileges> Sortilegess;

	Bone1 bone1;
	Bone2 bone2;
	Bone3 bone3;
	Lorann lorann;
	Bulle bulle;
	Bourses bourses;
	Demon1 demon1;
	Demon2 demon2;
	Demon3 demon3;
	Demon4 demon4;
	Porte_sortie portesortie;
	Sortileges sortileges;
	Font levelFont = new Font("SansSerif", Font.BOLD, 30);
	FileReader fr;

	public GameBoard (){
		this.setBackground(Color.BLACK);
		ChangerLevel();
		setFocusable(true);
		addKeyListener(this);
	}

	protected void ChangerLevel() {
		try{
			fr = new FileReader("Maps/level1.level");
			int x=0, y=0, i=0;

			Bones1 = new ArrayList<Bone1>();
			Bones2 = new ArrayList<Bone2>();
			Bones3 = new ArrayList<Bone3>();
			Bulles = new ArrayList<Bulle>();
			Boursess = new ArrayList<Bourses>();
			Demons1 = new ArrayList<Demon1>();
			Demons2 = new ArrayList<Demon2>();
			Demons3 = new ArrayList<Demon3>();
			Demons4 = new ArrayList<Demon4>();
			PorteSorties = new ArrayList<Porte_sortie>();


			while((i=fr.read()) != -1){
				char strImg = (char) i;

				if(strImg == '0'){
					Game [x][y] = "MURS";
					bone1 = new Bone1(x*32, y*32);
					Bones1.add(bone1);
				}
				else if(strImg == '1'){
					Game [x][y] = "MURS";
					bone2 = new Bone2(x*32, y*32);
					Bones2.add(bone2);
				}
				else if(strImg == '2'){
					Game [x][y] = "MURS";
					bone3 = new Bone3(x*32, y*32);
					Bones3.add(bone3);
				}
				else if (strImg == '3'){
					Game [x][y] = "LORANN";
					lorann = new Lorann (x*32, y*32);
				}
				else if (strImg == '4'){
					Game [x][y] = "BULLES";
					bulle = new Bulle (x*32, y*32);
					Bulles.add(bulle);
				}
				else if (strImg == '5'){
					Game [x][y] = "BOURSES";
					bourses = new Bourses (x*32, y*32);
					Boursess.add(bourses);
				}
				else if(strImg == '6'){
					Game[x][y] = "DEMON1";
					demon1 = new Demon1 (x*32,y*32);
					Demons1.add(demon1);
				}
				else if(strImg == '7'){
					Game[x][y] = "DEMON2";
					demon2 = new Demon2 (x*32,y*32);
					Demons2.add(demon2);
				}
				else if(strImg == '8'){
					Game[x][y] = "DEMON3";
					demon3 = new Demon3 (x*32,y*32);
					Demons3.add(demon3);
				}
				else if(strImg == '9'){
					Game[x][y] = "DEMON4";
					demon4 = new Demon4 (x*32,y*32);
					Demons4.add(demon4);
				}
				else if(strImg == 'S'){
					Game[x][y] = "PORTESORTIE";
					portesortie = new Porte_sortie (x*32,y*32);
					PorteSorties.add(portesortie);
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
			g2d.drawImage(sortileges.getImage(), sortileges.getX(), sortileges.getY(), null);
		}
		catch(Exception ex){}
		g.setColor(Color.RED);
		g.setFont(levelFont);
		g.drawString("LEVEL : " + level + " / Or : " + or + " / Vie : " + vies,200, 400);

		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		int Touche = arg0.getKeyCode();
		int x=0;
		int y = 0;
		Sortilegess = new ArrayList<Sortileges>();
		if (Touche == KeyEvent.VK_S || Touche == KeyEvent.VK_DOWN){
			if (! CheckCollision("BAS")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("BAS");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_Z || Touche == KeyEvent.VK_UP){
			if (! CheckCollision("HAUT")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("HAUT");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
				pathToLorann1(demon1);
				pathToLorann2(demon2);
				pathToLorann3(demon3);
				pathToLorann4(demon4);
			}
		}
		else if (Touche == KeyEvent.VK_D || Touche == KeyEvent.VK_RIGHT){
			if (! CheckCollision("DROITE")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("DROITE");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_Q || Touche == KeyEvent.VK_LEFT){
			if (! CheckCollision("GAUCHE")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("GAUCHE");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_A){
			if (! CheckCollision("HAUTGAUCHE")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("HAUTGAUCHE");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_E){
			if (! CheckCollision("HAUTDROITE")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("HAUTDROITE");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_W){
			if (! CheckCollision("BASGAUCHE")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("BASGAUCHE");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_X){
			if (! CheckCollision("BASDROITE")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("BASDROITE");
								lorann.move();
								Objectif();
								FollowShoot();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann2(demon2);
			pathToLorann3(demon3);
			pathToLorann4(demon4);
		}
		else if (Touche == KeyEvent.VK_SPACE){
			
			shoot = true;
			sortileges = new Sortileges(x*32, y*32);
			Sortilegess.add(sortileges);
			Shoot();
			

		}

		else if (Touche == KeyEvent.VK_R){
			ChangerLevel();
		}

		if (vies == 0){
			if (JOptionPane.showConfirmDialog(this,"GAME OVER.\nTRY AG?","",JOptionPane.YES_NO_OPTION)  == JOptionPane.YES_OPTION) {
				or = 0;
				vies = 11;
				ChangerLevel();
			}
		}
		repaint();
	}
	
	public boolean Shoot(){
		
		if (shoot == true){
		if(lorann.getDir() == "BAS"){
			sortileges.setY(lorann.getY() + 32 );
			sortileges.setX(lorann.getX());
			return true;
		}
		else if(lorann.getDir() == "HAUT"){
			sortileges.setY(lorann.getY()-32 );
			sortileges.setX(lorann.getX());
			return true;
			
		}
		else if(lorann.getDir() == "GAUCHE"){
			sortileges.setY(lorann.getY());
			sortileges.setX(lorann.getX()-32);
			return true;
		
		}
		else if(lorann.getDir() == "DROITE"){
			sortileges.setY(lorann.getY());
			sortileges.setX(lorann.getX()+32);	
			return true;
		}
		}
		return false;
		
	}
	
	public void FollowShoot(){

		if (shoot == true){

			if (lorann.getX() < sortileges.getX()){
				sortileges.setDir("DROITE");
				sortileges.move();
			}
			else if (lorann.getX() > sortileges.getX()){
				sortileges.setDir("GAUCHE");
				sortileges.move();

			}
			else if (lorann.getY() > sortileges.getY()){
				sortileges.setDir("HAUT");
				sortileges.move();

			}
			else if (lorann.getY() < sortileges.getY()){
				sortileges.setDir("BAS");
				sortileges.move();

			}
		}
	}

	public boolean CheckCollision(String direction){
		Rectangle lorannRec;
		lorannRec = lorann.getBounds();
		if (direction == "DROITE"){
			lorannRec.setBounds(lorannRec.x +32,lorannRec.y, lorannRec.width, lorannRec.height);
		}
		else if (direction == "GAUCHE"){
			lorannRec.setBounds(lorannRec.x -32,lorannRec.y, lorannRec.width, lorannRec.height);
		}
		else if (direction == "HAUT"){
			lorannRec.setBounds(lorannRec.x,lorannRec.y -32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "BAS"){
			lorannRec.setBounds(lorannRec.x ,lorannRec.y +32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "BASGAUCHE"){
			lorannRec.setBounds(lorannRec.x - 32 ,lorannRec.y +32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "BASDROITE"){
			lorannRec.setBounds(lorannRec.x + 32,lorannRec.y +32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "HAUTGAUCHE"){
			lorannRec.setBounds(lorannRec.x - 32,lorannRec.y - 32, lorannRec.width, lorannRec.height);
		}
		else if (direction == "HAUTDROITE"){
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
		return false;
	}

	public boolean MonsterEat( Mobile mobile){
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
			vies--;
			ChangerLevel();
			return true;
		}
		return false;
	}

	public void Objectif(){
		Rectangle lorannRec;
		lorannRec = lorann.getBounds();
		for(int i=0;i<Boursess.size();i++){
			bourses = (Bourses) Boursess.get(i);
			Rectangle boursesRec = bourses.getBounds();

			if(lorannRec.intersects(boursesRec)){
				switch (lorann.getDir()){

				case "BAS":
					Boursess.remove(i);
					or = or + 100;
					break;

				case "HAUT" :
					Boursess.remove(i);
					or = or + 100;
					break;

				case "GAUCHE":
					Boursess.remove(i);
					or = or + 100;
					break;

				case "DROITE":
					Boursess.remove(i);
					or = or + 100;
					break;

				case "HAUTDROITE" : 
					Boursess.remove(i);
					or = or + 100;
					break;

				case "HAUTGAUCHE" :
					Boursess.remove(i);
					or = or + 100;
					break;

				case "BASDROITE" : 
					Boursess.remove(i);
					or = or + 100;
					break;

				case "BASGAUCHE" :
					Boursess.remove(i);
					or = or + 100;
					break;

				default :
					break;
				}
			}
		}

		for (int i=0;i<Bulles.size();i++){
			bulle = (Bulle) Bulles.get(i);
			Rectangle objectifRec = bulle.getBounds();


			bulle = (Bulle) Bulles.get(i);
			if (lorannRec.intersects(objectifRec)){
				Bulles.remove(i);
				portesortie.setEtat("OUVERT");
			}

		}

		for(int i=0; i<PorteSorties.size(); i++){
			portesortie =(Porte_sortie) PorteSorties.get(i);
			Rectangle ouvertRec = portesortie.getBounds();

			if(lorannRec.intersects(ouvertRec)){
				if (portesortie.getEtat() == "FERME")
					vies--;
				ChangerLevel();
			}
		}
	}

	public boolean MonsterCollision(String direction, Mobile mobile){
		Rectangle mobileRec;
		mobileRec = mobile.getBounds();


		if (direction == "DROITE"){
			mobileRec.setBounds(mobileRec.x +32,mobileRec.y, mobileRec.width, mobileRec.height);
		}
		else if (direction == "GAUCHE"){
			mobileRec.setBounds(mobileRec.x -32, mobileRec.y, mobileRec.width, mobileRec.height);
		}
		else if (direction == "HAUT"){
			mobileRec.setBounds(mobileRec.x,mobileRec.y -32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "BAS"){
			mobileRec.setBounds(mobileRec.x ,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "BASGAUCHE"){
			mobileRec.setBounds(mobileRec.x - 32 ,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "BASDROITE"){
			mobileRec.setBounds(mobileRec.x + 32,mobileRec.y +32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "HAUTGAUCHE"){
			mobileRec.setBounds(mobileRec.x - 32,mobileRec.y - 32, mobileRec.width, mobileRec.height);
		}
		else if (direction == "HAUTDROITE"){
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
		for(int i=0;i<Demons1.size();i++){
			demon1 = (Demon1) Demons1.get(i);
			Rectangle demon1Rec = demon1.getBounds();
			if(mobileRec.intersects(demon1Rec)){
				return true;
			}
		}
		for(int i=0;i<Demons2.size();i++){
			demon2 = (Demon2) Demons2.get(i);
			Rectangle demon2Rec = demon2.getBounds();
			if(mobileRec.intersects(demon2Rec)){
				return true;
			}
		}for(int i=0;i<Demons3.size();i++){
			demon3 = (Demon3) Demons3.get(i);
			Rectangle demon3Rec = demon3.getBounds();
			if(mobileRec.intersects(demon3Rec)){
				return true;
			}
		}for(int i=0;i<Demons4.size();i++){
			demon4 = (Demon4) Demons4.get(i);
			Rectangle demon4Rec = demon4.getBounds();
			if(mobileRec.intersects(demon4Rec)){
				return true;
			}
		}
		return false;
	}

	public void pathToLorann1(Mobile mobile){

		int PlusRapide;
		PlusRapide = 1500;

		if (! MonsterCollision("HAUTGAUCHE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32))) /*&& ! MonsterCollision("HAUTGAUCHE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("HAUTGAUCHE");
			}
		}
		if(! MonsterCollision("HAUTDROITE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32))) /*&& ! MonsterCollision("HAUTDROITE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("HAUTDROITE");
			}
		}
		if(! MonsterCollision("BASGAUCHE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32))) /*&& ! MonsterCollision("BASGAUCHE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("BASGAUCHE");
			}
		}
		if(! MonsterCollision("BASDROITE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32))) /*&& ! MonsterCollision("BASDROITE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("BASDROITE");
			}
		}

		if (! MonsterCollision("BAS",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()+32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("BAS");
			}
		}

		if (! MonsterCollision("GAUCHE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+0)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+0)));
				mobile.setDir("GAUCHE");
			}
		}

		if (! MonsterCollision("HAUT",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()-32)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+0)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("HAUT");
			}
		}

		if (! MonsterCollision("DROITE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+0)))){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+0)));
				mobile.setDir("DROITE");
			}
		}


		switch (mobile.getDir()){

		case "HAUTGAUCHE" :
			mobile.move();
			break;

		case "HAUTDROITE" : 
			mobile.move();
			break;

		case "BASGAUCHE" : 
			mobile.move();
			break;

		case "BASDROITE" : 
			mobile.move();
			break;

		case "BAS" : 
			mobile.move();
			break;

		case "GAUCHE" : 
			mobile.move();
			break;

		case "HAUT" : 
			mobile.move();
			break;

		case "DROITE" :
			mobile.move();
			break;

		default: 
			break;
		}
	}


	public void pathToLorann2(Mobile mobile){

		int PlusRapide;
		PlusRapide = 1500;

		if (! MonsterCollision("HAUTGAUCHE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32))) /*&& ! MonsterCollision("HAUTGAUCHE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("HAUTGAUCHE");
			}
		}
		if(! MonsterCollision("HAUTDROITE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32))) /*&& ! MonsterCollision("HAUTDROITE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()-32)));
				mobile.setDir("HAUTDROITE");
			}
		}
		if(! MonsterCollision("BASGAUCHE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32))) /*&& ! MonsterCollision("BASGAUCHE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()-32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("BASGAUCHE");
			}
		}
		if(! MonsterCollision("BASDROITE",mobile)){
			if (PlusRapide > Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32))) /*&& ! MonsterCollision("BASDROITE",mobile)*/){
				PlusRapide = Math.abs((lorann.getX()-(mobile.getX()+32)))+Math.abs((lorann.getY()-(mobile.getY()+32)));
				mobile.setDir("BASDROITE");
			}
		}

		switch (mobile.getDir()){

		case "HAUTGAUCHE" :
			mobile.move();
			break;

		case "HAUTDROITE" : 
			mobile.move();
			break;

		case "BASGAUCHE" : 
			mobile.move();
			break;

		case "BASDROITE" : 
			mobile.move();
			break;

		default: 
			break;
		}
	}

	public void pathToLorann3(Mobile mobile){
		if(mobile.getX()<lorann.getX()){
			if (! MonsterCollision("DROITE", mobile)) {
				mobile.setDir("DROITE");
				mobile.move();
			}
		}
		else if(mobile.getX()>lorann.getX()){
			if (! MonsterCollision("GAUCHE", mobile)) {
				mobile.setDir("GAUCHE");
				mobile.move();
			}
		}
		else if (mobile.getX() == lorann.getX()){
			if(mobile.getY()>lorann.getY()){
				if (! MonsterCollision("HAUT", mobile)) {
					mobile.setDir("HAUT");
					mobile.move();
				}
			}
			else if(mobile.getY()<lorann.getY()){
				if (! MonsterCollision("BAS", mobile)) {
					mobile.setDir("BAS");
					mobile.move();
				}
			}
		}
	}

	public void pathToLorann4(Mobile mobile){

		if(mobile.getY()>lorann.getY()){
			if (! MonsterCollision("HAUT", mobile)) {
				mobile.setDir("HAUT");
				mobile.move();
			}
		
			
		else if(mobile.getY()<lorann.getY()){
			if (! MonsterCollision("BAS", mobile)) {
				mobile.setDir("BAS");
				mobile.move();
			}
		}
		else if (mobile.getY() == lorann.getY()){
			if(mobile.getX()<lorann.getX()){
				if (! MonsterCollision("DROITE", mobile)) {
					mobile.setDir("DROITE");
					mobile.move();
				}
			}
			else if(mobile.getX()>lorann.getX()){
				if (! MonsterCollision("GAUCHE", mobile)) {
					mobile.setDir("GAUCHE");
					mobile.move();
				}
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