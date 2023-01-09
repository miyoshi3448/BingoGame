package model;

public class Status {
	private boolean[][] hitArrays = new boolean[5][5];
	private int reach;
	private int bingo;
	
	public Status() {
		hitArrays[2][2] = true;
	}
	
	public int getBingoCount(boolean[][] hit) {
		return 0;
	}
	
	/* ballNumberがbingoCardにある値ならhitArraysの対応する値をtrueにする
	 * 上記trueの場合reachとbingoのチェックを行う
	 */
	public void searchNumber(BingoCard bingoCard, int ballNumber) {
		for(int i = 0; i < bingoCard.getCardNumbers().length; i++) {
			for(int j = 0; j < bingoCard.getCardNumbers()[i].length; j++) {
				if(bingoCard.getCardNumbers()[i][j] == ballNumber) {
					hitArrays[i][j] = true;
					checkHit();
					return;
				}
			}
		}
	}
	
	private void checkHit() {
		reach = 0;
		bingo = 0;
		
		checkRow();
		checkColumn();
		checkDiagonal();
	}
	
	//横列のreachとbingoを数える
	private void checkRow() {
		for(boolean[] hitArray : hitArrays) {
			int count = 0;
			
			for(boolean hit : hitArray) {
				if(hit) {
					count++;
				}
			}
			
			if(count == 4){
				reach++;
			}else if(count == 5) {
				bingo++;
			}
		}
	}
	
	//楯列のreachとbingoを数える
	private void checkColumn() {
		for(int i = 0; i < hitArrays.length; i++) {
			int count = 0;
			
			for(int j = 0; j < hitArrays[i].length; j++) {
				if(hitArrays[j][i]) {
					count++;
				}
			}
			
			if(count == 4){
				reach++;
			}else if(count == 5) {
				bingo++;
			}
		}
	}
	
	//対角線のreachとbingoを数える
	private void checkDiagonal() {
		int count = 0;
		for(int i = 0; i < 5; i++) {
			if(hitArrays[i][i]) {
				count++;
			}
		}
		
		if(count == 4){
			reach++;
		}else if(count == 5) {
			bingo++;
		}
		
		count = 0;
		for(int i = 0; i < 5; i++) {
			if(hitArrays[i][4 - i]) {
				count++;
			}
		}
		
		if(count == 4){
			reach++;
		}else if(count == 5) {
			bingo++;
		}
	}
	
	public boolean[][] getHit() { 
		return hitArrays;
	}
	
	public int getReach() {
		return reach;
	}
	
	public int getBingo() {
		return bingo;
	}
}
