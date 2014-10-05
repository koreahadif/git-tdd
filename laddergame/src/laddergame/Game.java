package laddergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {
	public static int COLUMN = 10;
	public int PLAYER = 5;
	HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	public int setLadderSize(int i) {
		 return i;
	}

	public HashMap<Integer, ArrayList<Integer>> drawLadderLine(int i) {
		Random rand = new Random();
		HashMap<Integer, ArrayList<Integer>> drawMap = new HashMap<Integer, ArrayList<Integer>>();
		if (rand.nextBoolean()) {
			int lineNumber = rand.nextInt(PLAYER -1);
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(lineNumber);
			list.add(lineNumber + 1);
			drawMap.put(i,list);
		}
		return drawMap;
	}
	
	public void gameSetting(int player) {		
		PLAYER = setLadderSize(player);
		
		for (int i = 0; i < COLUMN; i++) {
			map.putAll(drawLadderLine(i));
		}
		for (int i = 0; i < PLAYER; i++) {
			System.out.print(i+1 + "\t");
		}
		System.out.println("");
	}
	
	public int gameStart(int num) {
		int present = 0;
		while(present != COLUMN) {
			ArrayList<Integer> list = map.get(present);
			num = goNext(num, list);
			present++;
		}
		return num;
	}
	
	public int goNext(int num, ArrayList<Integer> list) {
		if (list == null) {
			printLadder(num, "0");
			return num;
		}
		if (list.contains(num) && list.contains(num + 1)) {
			printLadder(num, "1");
			return num + 1;
		}
		if (list.contains(num) && !list.contains(num + 1)) {
			printLadder(num, "-1");
			return num - 1;
		}
		printLadder(num, "0");
		return num;
	}

	public void printLadder(int num, String string) {
		for(int i = 0; i < PLAYER; i++) {
			if (i != num) {
				System.out.print("-\t");
			} 
			if (i == num){
				System.out.print(string + "\t");
			}
		}
		System.out.println("");
	}

}
