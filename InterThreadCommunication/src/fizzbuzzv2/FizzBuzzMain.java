package fizzbuzzv2;

public class FizzBuzzMain {
	public static void main(String[] args) {
		int n = 151; // Range of numbers to print
		FizzBuzzPrinter fizzBuzz = new FizzBuzzPrinter(n);

		Thread fizzThread = new Thread(fizzBuzz::printFizz);

		Thread buzzThread = new Thread(fizzBuzz::printBuzz);

		Thread fizzBuzzThread = new Thread(fizzBuzz::printFizzBuzz);

		Thread numberThread = new Thread(fizzBuzz::printNumber);

		// Start all threads
		fizzThread.start();
		buzzThread.start();
		fizzBuzzThread.start();
		numberThread.start();

		// Wait for all threads to finish
		try {
			fizzThread.join();
			buzzThread.join();
			fizzBuzzThread.join();
			numberThread.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
