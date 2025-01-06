package alternatethreadEvenOddprinting;

public class InterThreadMain {

	public static void main(String[] args) {
		CommonObject common = new CommonObject(true);
//		Thread odd = new OddPrinter(common);
//		Thread even = new EvenPrinter(common);
//		
		Thread odd = new Thread(common::oddPrint);
		Thread even = new Thread(common::evenPrint);
		
		odd.start();
		even.start();
	}

}
