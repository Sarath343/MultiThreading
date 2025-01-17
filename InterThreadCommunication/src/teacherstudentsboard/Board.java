package teacherstudentsboard;

import java.util.List;
import java.util.Queue;

public class Board {
	public Board(List<String> values, int cnt) {
		this.lecture = values;
		this.count = cnt;
	}

	private List<String> lecture;
	private String msg;

	private String whoseTurn;

	private int count;

	synchronized void write() {
		int i =1 ; 
		while (i<=4) {
			while (count != 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  
				msg = lecture.get(i);
				System.out.println("Teacher wrote " + msg);
				count++;
				notifyAll();
				
			 
		}
	}

	public String getTurn() {
		return whoseTurn;
	}

	public void setTurn(String turn) {
		this.whoseTurn = turn;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
