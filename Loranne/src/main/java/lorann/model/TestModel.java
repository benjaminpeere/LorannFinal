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
		new Monster1(0, 0);
	}

	public void testDemon2(){
		new Monster2(0, 0);
	}
	public void testDemon3(){
		new Monster3(0, 0);
	}
	public void testDemon4(){
		new Monster4(0, 0);
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
		new Purses(0, 0);
	}
	public void testBulles(){
		new CrystalBall(0, 0);
	}
	public void testLorann(){
		new Lorann(0, 0);
	}
	public void testMobile(){
		new Mobile();
	}
	public void testMur(){
		new Walls();
	}
	public void testNonMobileFranchissable(){
		new NoCross();
	}
	public void testPorte_Sortie(){
		new OutDoor(0, 0);
	}
	public void testSortileges(){
		new FireBall(0, 0);
	}
	
}
