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

	public void testMonster1(){
		new Monster1(0, 0);
	}

	public void testMonster2(){
		new Monster2(0, 0);
	}
	public void testMonster3(){
		new Monster3(0, 0);
	}
	public void testMonster4(){
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
	public void testPurses(){
		new Purses(0, 0);
	}
	public void testCrystalBall(){
		new CrystalBall(0, 0);
	}
	public void testLorann(){
		new Lorann(0, 0);
	}
	public void testMobile(){
		new Mobile();
	}
	public void testWalls(){
		new Walls();
	}
	public void testNoCross(){
		new NoCross();
	}
	public void testOutDoor(){
		new OutDoor(0, 0);
	}
	public void testFireBall(){
		new FireBall(0, 0);
	}
	
}
