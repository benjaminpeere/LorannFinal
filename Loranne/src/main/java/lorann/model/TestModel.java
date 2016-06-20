package lorann.model;
/**
 * |##################################|
 * |unit test of the different class  |
 * |##################################| 
 */
import org.junit.Test;

import junit.framework.TestCase;

public class TestModel extends TestCase {

	private GameBoard gameboard ;
	
	public TestModel(){
		super();
	}
	@Test
	public void testGameBoard() {
		new GameBoard();
	}
	protected void setUp() throws Exception{
		super.setUp();
		gameboard = new GameBoard();
	}

	public void testDemon1(){
		new Demon1(0, 0);
	}

	public void testDemon2(){
		new Demon2(0, 0);
	}
	public void testDemon3(){
		new Demon3(0, 0);
	}
	public void testDemon4(){
		new Demon4(0, 0);
	}
	public void testBone1(){
		new Bone1(0, 0);
	}
	public void testBone2(){
		new Bone2(0, 0);
	}
	public void testBone3(){
		new Bone3(0, 0);
	}
	public void testBourses(){
		new Bourses(0, 0);
	}
	public void testBulles(){
		new Bulle(0, 0);
	}
	public void testLorann(){
		new Lorann(0, 0);
	}
	public void testMobile(){
		new Mobile();
	}
	public void testMur(){
		new Murs();
	}
	public void testNonMobileFranchissable(){
		new NonMobileFranchissable();
	}
	public void testPorte_Sortie(){
		new Porte_sortie(0, 0);
	}
	public void testSortileges(){
		new Sortileges(0, 0);
	}
	
}
