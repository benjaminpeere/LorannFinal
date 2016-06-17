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

import javax.swing.JPanel;

public class GameBoard extends JPanel implements KeyListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	String Game[][] = new String [12][12];
	int level = 1;
	private static ArrayList<Murs> Murss;
	private static ArrayList<Bulle> Bulles;
	private static ArrayList<Bourses> Boursess;
	private static ArrayList<Demon1> Demons1;
	private static ArrayList<Demon2> Demons2;
	private static ArrayList<Demon3> Demons3;
	private static ArrayList<Demon4> Demons4;
	private static ArrayList<Porte_sortie> PorteSorties;
	private static ArrayList<PorteSortieOuverte>porteSortiesOuverte;

	Murs mur;
	Lorann lorann;
	Bulle bulle;
	Bourses bourses;
	Demon1 demon1;
	Demon2 demon2;
	Demon3 demon3;
	Demon4 demon4;
	Porte_sortie portesortie;
	PorteSortieOuverte portesortieouverte;
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

			Murss = new ArrayList<Murs>();
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
					mur = new Murs(x*32, y*32);
					Murss.add(mur);
				}
				else if (strImg == '1'){
					Game [x][y] = "LORANN";
					lorann = new Lorann (x*32, y*32);
				}
				else if (strImg == '2'){
					Game [x][y] = "BULLES";
					bulle = new Bulle (x*32, y*32);
					Bulles.add(bulle);
				}
				else if (strImg == '3'){
					Game [x][y] = "BOURSES";
					bourses = new Bourses (x*32, y*32);
					Boursess.add(bourses);
				}
				else if (strImg == '4'){
					Game [x][y] = "BOURSES";
					bourses = new Bourses (x*32, y*32);
					Boursess.add(bourses);
				}
				else if(strImg == '5'){
					Game[x][y] = "DEMON1";
					demon1 = new Demon1 (x*32,y*32);
					Demons1.add(demon1);
				}
				else if(strImg == '6'){
					Game[x][y] = "DEMON2";
					demon2 = new Demon2 (x*32,y*32);
					Demons2.add(demon2);
				}
				else if(strImg == '7'){
					Game[x][y] = "DEMON3";
					demon3 = new Demon3 (x*32,y*32);
					Demons3.add(demon3);
				}
				else if(strImg == '8'){
					Game[x][y] = "DEMON4";
					demon4 = new Demon4 (x*32,y*32);
					Demons4.add(demon4);
				}
				else if(strImg == '9'){
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
				if (x==11){
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
	
	public void PorteOuverte(){
		try{
			fr = new FileReader("Maps/level1.level");
			int x=0, y=0, i=0;
			porteSortiesOuverte = new ArrayList<PorteSortieOuverte>();
			
			while((i=fr.read()) != -1){
				char strImg = (char) i;
				if(strImg == '9'){
					Game[x][y] = "PORTESORTIEOUVERTE";
					portesortieouverte = new PorteSortieOuverte (x*32,y*32);
					porteSortiesOuverte.add(portesortieouverte);
				}
				else if (strImg == ' '){
					Game[x][y] = null;
				}
				else if (strImg == '\r' || strImg == '\n'){
					x--;
				}
				if (x==11){
					y++;
					x=0;
				}
				else {
					x++;
				}

			}
		}
		catch(Exception e){
			repaint();
		}
	}

	public void paint (Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		for(int i = 0; i< Murss.size(); i++){
			mur = (Murs) Murss.get(i);
			g2d.drawImage(mur.getImage(), mur.getX(), mur.getY(), null);
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
			g2d.drawImage(portesortieouverte.getImage(), portesortieouverte.getX(), portesortieouverte.getY(), null);

		}
		catch(Exception ex){
			g.setColor(Color.BLACK);
			g.setFont(levelFont);
			g.drawString("LEVEL : " + level,10, 25);
		}
		repaint();
	}

	public void keyPressed(KeyEvent arg0) {
		int Touche = arg0.getKeyCode();

		if (Touche == KeyEvent.VK_S || Touche == KeyEvent.VK_DOWN){
			if (! CheckCollision("BAS")){
				if (! MonsterEat(demon1)){
					if (! MonsterEat(demon2)){
						if (! MonsterEat(demon3)){
							if (! MonsterEat(demon4)){
								lorann.setDir("BAS");
								lorann.move();
								Objectif();
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
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
							}
						}
					}
				}
				pathToLorann1(demon1);
				pathToLorann1(demon2);
				pathToLorann1(demon3);
				pathToLorann1(demon4);
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
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
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
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
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
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
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
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
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
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
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
							}
						}
					}
				}
			}
			pathToLorann1(demon1);
			pathToLorann1(demon2);
			pathToLorann1(demon3);
			pathToLorann1(demon4);
		}
		else if (Touche == KeyEvent.VK_R){
			ChangerLevel();
		}
		repaint();
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

		for(int i=0;i<Murss.size();i++){
			mur = (Murs) Murss.get(i);
			Rectangle murRec = mur.getBounds();
			if(lorannRec.intersects(murRec)){
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
					break;

				case "HAUT" :
					Boursess.remove(i);
					break;
					
				case "GAUCHE":
					Boursess.remove(i);
					break;
					
				case "DROITE":
					Boursess.remove(i);
					break;
				
				case "HAUTDROITE" : 
					Boursess.remove(i);
					break;
				
				case "HAUTGAUCHE" :
					Boursess.remove(i);
					break;
				
				case "BASDROITE" : 
					Boursess.remove(i);
					break;
				
				case "BASGAUCHE" :
					Boursess.remove(i);
					break;
				
				default :
					break;
				}
			}
		}

		for (int i=0;i<Bulles.size();i++){
			bulle = (Bulle) Bulles.get(i);
			Rectangle objectifRec = bulle.getBounds();

			for (int j = 0; j < Bulles.size(); j++){
				bulle = (Bulle) Bulles.get(i);
				if (lorannRec.intersects(objectifRec)){
					Bulles.remove(i);
					PorteOuverte();
					
				}
			}
		}
		
		for(int i=0; i<porteSortiesOuverte.size(); i++){
			portesortieouverte =(PorteSortieOuverte) porteSortiesOuverte.get(i);
			Rectangle ouvertRec = portesortieouverte.getBounds();
			
			for(int j=0; j<porteSortiesOuverte.size(); j++){
				portesortieouverte =(PorteSortieOuverte) porteSortiesOuverte.get(i);
				if(lorannRec.intersects(ouvertRec)){
					ChangerLevel();
					porteSortiesOuverte.remove(i);
				}
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

		for(int i=0;i<Murss.size();i++){
			mur = (Murs) Murss.get(i);
			Rectangle murRec = mur.getBounds();
			if(mobileRec.intersects(murRec)){
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
		if(mobile.getX()<lorann.getX()){
			if (! MonsterCollision("DROITE", mobile)) {
				mobile.setDir("DROITE");
				mobile.move();
			}
			else if (mobile.getY()<=lorann.getY() && ! MonsterCollision("BAS",mobile)){
				mobile.setDir("BAS");
				mobile.move();
				if (! MonsterCollision("DROITE",mobile)) {
					mobile.setDir("DROITE");
					mobile.move();
				}
			}
			else if (mobile.getY()>=lorann.getY() && ! MonsterCollision("HAUT",mobile)){
				mobile.setDir("HAUT");
				mobile.move();
				if (! MonsterCollision("DROITE",mobile)) {
					mobile.setDir("DROITE");
					mobile.move();
				}
			}
			else if (! MonsterCollision("GAUCHE",mobile)){
				mobile.setDir("GAUCHE");
				mobile.move();
			}
		}
		else if(mobile.getX()>lorann.getX()){
			if (! MonsterCollision("GAUCHE",mobile)) {
				mobile.setDir("GAUCHE");
				mobile.move();
				}
				else if (mobile.getY()<=lorann.getY() && ! MonsterCollision("BAS",mobile)){
					mobile.setDir("BAS");
					mobile.move();
					if (! MonsterCollision("GAUCHE",mobile)) {
						mobile.setDir("GAUCHE");
						mobile.move();
					}
				}
				else if (mobile.getY()>=lorann.getY() && ! MonsterCollision("GAUCHE",mobile)){
					mobile.setDir("HAUT");
					mobile.move();
					if (! MonsterCollision("GAUCHE",mobile)) {
						mobile.setDir("GAUCHE");
						mobile.move();
					}
				}
				else if (! MonsterCollision("DROITE",mobile)){
					mobile.setDir("DROITE");
					mobile.move();
				}
		}
		else if(mobile.getY()<lorann.getY()){
			if (! MonsterCollision("BAS",mobile)) {
				mobile.setDir("BAS");
				mobile.move();
				}
				else if (mobile.getX()<=lorann.getX() && ! MonsterCollision("DROITE",mobile)){
					mobile.setDir("DROITE");
					mobile.move();
					if (! MonsterCollision("BAS",mobile)) {
						mobile.setDir("BAS");
						mobile.move();
					}
				}
				else if (mobile.getX()>=lorann.getX() && ! MonsterCollision("GAUCHE",mobile)){
					mobile.setDir("GAUCHE");
					mobile.move();
					if (! MonsterCollision("BAS",mobile)) {
						mobile.setDir("BAS");
						mobile.move();
					}
				}
				else if (! MonsterCollision("HAUT",mobile)){
					mobile.setDir("HAUT");
					mobile.move();
				}
		}
		else if(mobile.getY() > lorann.getY()){
			if (! MonsterCollision("HAUT",mobile)) {
				mobile.setDir("HAUT");
				mobile.move();
				}
				else if (mobile.getX()<=lorann.getX() && ! MonsterCollision("DROITE",mobile)){
					mobile.setDir("DROITE");
					mobile.move();
					if (! MonsterCollision("HAUT",mobile)) {
						mobile.setDir("HAUT");
						mobile.move();
					}
				}
				else if (mobile.getX()>=lorann.getX() && ! MonsterCollision("GAUCHE",mobile)){
					mobile.setDir("GAUCHE");
					mobile.move();
					if (! MonsterCollision("HAUT",mobile)) {
						mobile.setDir("HAUT");
						mobile.move();
					}
				}
				else if (! MonsterCollision("BAS",mobile)){
					mobile.setDir("BAS");
					mobile.move();
				}
		}
		repaint();
	}

	
	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}