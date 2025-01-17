package teacherstudentsboard;

import java.util.Arrays;
import java.util.List;

public class TeacherStudentMain {

	public static void main(String[] args) {
		List<String> values = Arrays.asList("A","B","C","Z");
		Board board = new Board(values,3);
		
		Thread teacher = new Thread(board::write) ; 
		Thread student1 = new Student("Ravi",  board);
		Thread student2 = new Student("Sobha",  board);
		Thread student3 =new Student("Joseph",  board);
		
		teacher.start();
		student1.start();
		student2.start();student3.start();
	}

}
