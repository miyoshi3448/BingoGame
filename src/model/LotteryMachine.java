package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {
	private ArrayList<Integer> bingoBall;
	
	public LotteryMachine() {
		bingoBall = new ArrayList<Integer>(IntStream.rangeClosed(1,75).boxed().collect(Collectors.toList()));
	}
	
	//整数配列をシャッフルして１つ引き、引いたものを配列から削除して引いた値を返す
	public int drawing() {
		Collections.shuffle(bingoBall);
		int drawingBall = bingoBall.get(0);
		bingoBall.remove(0);
		
		return drawingBall;
	}
	
	public boolean isEmpty() {
		return bingoBall.size() == 0;
	}
}
