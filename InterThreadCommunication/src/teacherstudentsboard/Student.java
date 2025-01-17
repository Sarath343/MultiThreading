package teacherstudentsboard;

public class Student extends Thread {
	private String name;
	private Board board;

	public Student(String string, Board board2) {
		this.name = string;
		this.board = board2;
	}
	public synchronized  void run() {
		while(true) {
			if(board.getCount() !=0) {
				copy() ; 
				if(board.getCount() ==3)
					board.setCount(0);
				else
				board.setCount(board.getCount()+1);
				notifyAll();
			}
			else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
	}
	public  void copy() {
		System.out.println(name + " copied message " + board.getMsg());
	}
}
