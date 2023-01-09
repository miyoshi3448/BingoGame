package view;

import model.BingoCard;
import model.Status;

public class View {
	public void showResult(BingoCard bingoCard, Status status, int usedCount, int ballNumber) {
		showBingoBall(usedCount, ballNumber);
		showCard(bingoCard, status.getHit());
		System.out.println("REACH: " + status.getReach() + "\nBINGO: " + status.getBingo());
		
		System.out.println("--------------------");
	}
	
	/* bingoCardの値をhitArraysの値がtrueなら()で囲みfalseならスペースで囲み表示する
	 * 真ん中はFREEと表示する
	 */
	private void showCard(BingoCard bingoCard, boolean[][] hitArrays) {
		for(int i = 0; i < bingoCard.getCardNumbers().length; i++) {
			for(int j = 0; j < bingoCard.getCardNumbers()[i].length; j++) {
				if(i != 2 || j != 2) {
					System.out.printf("%s%02d%s", hitArrays[i][j]? "(" : " ", bingoCard.getCardNumbers()[i][j], hitArrays[i][j]? ")" : " ");
				}else {
					System.out.print("FREE");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	private void showBingoBall(int usedCount, int ballNumber) {
		System.out.println("ball[" + usedCount + "]:" + ballNumber);
	}
}
