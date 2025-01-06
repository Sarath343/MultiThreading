package alternatereadwrite;

import java.util.Arrays;
import java.util.List;

public class ReadWriteMain {

	public static void main(String[] args) {
		List<String> lines = Arrays.asList("java" , "Python","elephant");
		SharedBoard board = new SharedBoard(lines);
		
		Thread read = new Thread(board::read);
		Thread write = new Thread(board::write);
		write.start();
		read.start();
	}

}
