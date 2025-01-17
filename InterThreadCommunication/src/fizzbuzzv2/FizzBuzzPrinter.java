package fizzbuzzv2;

class FizzBuzzPrinter {
	private int n;
	private int current = 1;

	public FizzBuzzPrinter(int n) {
		this.n = n;
	}

	// Print "Fizz"
	public synchronized void printFizz() {
		while (current <= n) {
			if (current % 3 == 0 && current % 5 != 0) {
				System.out.println("Fizz");
				current++;
				notifyAll(); // Notify waiting threads
			} else {

				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Wait for the right condition
			}
		}
	}

	// Print "Buzz"
	public synchronized void printBuzz() {
		while (current <= n) {
			if (current % 5 == 0 && current % 3 != 0) {
				System.out.println("Buzz");
				current++;
				notifyAll(); // Notify waiting threads
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Wait for the right condition
			}
		}
	}

	// Print "FizzBuzz"
	public synchronized void printFizzBuzz() {
		while (current <= n) {
			if (current % 3 == 0 && current % 5 == 0) {
				System.out.println("FizzBuzz");
				current++;
				notifyAll(); // Notify waiting threads
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Wait for the right condition
			}
		}
	}

	// Print numbers
	public synchronized void printNumber() {
		while (current <= n) {
			if (current % 3 != 0 && current % 5 != 0) {
				System.out.println(current);
				current++;
				notifyAll(); // Notify waiting threads
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Wait for the right condition
			}
		}
	}
}
