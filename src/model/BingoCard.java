package model;

import java.util.ArrayList;

public class BingoCard {
	private int[][] cardNumbers = new int[5][5];
	
	public BingoCard() {
		ArrayList<Integer> used = new ArrayList<Integer>();
		for(int i = 0; i < cardNumbers.length; i++) {
			for(int j = 0; j < cardNumbers[i].length; j++) {
				if(i != 2 || j != 2) {
					while(true) {
						int number = (int)(Math.random() * 15) + 1 + i * 15;
						if(!used.contains(number)) {
							cardNumbers[j][i] = number;
							used.add(number);
							break;
						}
					}
				}else {
					cardNumbers[i][j] = 0;
				}
			}
		}
	}
	
	public int[][] getCardNumbers(){
		return cardNumbers;
	}
}
