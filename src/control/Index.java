package control;

import java.util.ArrayList;

import model.BingoCard;
import model.LotteryMachine;
import model.Status;
import view.View;

public class Index {
	public static void main(String[] args) {
		BingoCard bingoCard = new BingoCard();
		LotteryMachine lotteryMachine = new LotteryMachine();
		Status status = new Status();
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
		View view = new View();
		
		do {
			int drawingNumber = lotteryMachine.drawing();
			usedNumbers.add(drawingNumber);
			status.searchNumber(bingoCard, drawingNumber);
			view.showResult(bingoCard, status, usedNumbers.size(), drawingNumber);
		}while(!lotteryMachine.isEmpty());
	}
}
