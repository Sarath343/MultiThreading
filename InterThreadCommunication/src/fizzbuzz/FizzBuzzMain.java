package fizzbuzz;

public class FizzBuzzMain {

	public static void main(String[] args) {
		FizzBuzzPrinter printer = new FizzBuzzPrinter(154);
		Thread fizz = new Thread(printer::printFizz);
		Thread buzz = new Thread(printer::printBuzz);
		Thread fizzBuzz = new Thread(printer::printFizzBuzz);
		Thread numbers = new Thread(printer::printNumbers);

		fizz.start(); 
		buzz.start();
		fizzBuzz.start();
		numbers.start();
	}

}
