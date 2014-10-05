package laddergame;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	Game game;
	HashMap<Integer, ArrayList<Integer>> map;
	@Before
	public void setup() {
		game = new Game();
//		map = new HashMap<Integer, ArrayList<Integer>>();
		game.gameSetting(5);
	}
	
	@Test
	public void 사다리크기정하기() {
		game.setLadderSize(10);
	}
	
	@Test
	public void 다리놓기() {		
		System.out.println(game.drawLadderLine(5));
		System.out.println(game.drawLadderLine(4));
		System.out.println(game.drawLadderLine(3));
		System.out.println(game.drawLadderLine(2));
		System.out.println(game.drawLadderLine(1));
	}
	
	@Test
	public void 사다리만나면() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		int a = game.goNext(4, list);
		assertThat(a, is(3));
	}
	
	@Test
	public void 사다리게임() {
		System.out.println(game.gameStart(2));
		System.out.println(game.gameStart(1));
		System.out.println(game.gameStart(0));
		System.out.println(game.gameStart(3));
		System.out.println(game.gameStart(4));
	}
	
}
