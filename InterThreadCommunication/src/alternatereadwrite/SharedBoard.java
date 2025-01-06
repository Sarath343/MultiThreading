package alternatereadwrite;

import java.util.List;

public class SharedBoard {
	List<String> lines;
	String txt;
	boolean flag;

	public SharedBoard(List<String> lines2) {
		this.lines = lines2;
	}

	synchronized public void read() {
		while (true) {
			while (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("read " + txt);
			flag = false;
			notify();
		}
	}

	synchronized public void write() {
		for (String line : lines) {
			while (flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.txt = line;
			System.out.println("Written " + line);
			flag = true;
			notify();
		}
	}
}
