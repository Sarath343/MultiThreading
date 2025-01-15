package fizzbuzz;

public class FizzBuzzPrinter {
	public FizzBuzzPrinter(Integer maxNumber) {
		super();
		this.maxNumber = maxNumber;
	}

	Integer maxNumber;
	static boolean fizzFlag;
	static boolean buzzFlag;
	static boolean fbFlag;

	synchronized public void printFizz() {
		int i = 3;
		while (i < maxNumber) {
			while (!fizzFlag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Fizz");
			i += 3;
			fizzFlag = false;
			notifyAll();
		}

	}

	synchronized public void printBuzz() {
		int i = 5;
		while (i < maxNumber) {
			while (!buzzFlag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Buzz");
			i += 5;
			buzzFlag = false;
			notifyAll();
		}
	}

	synchronized public void printFizzBuzz() {
		int i = 15;
		while (i < maxNumber) {
			while (!fbFlag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("FizzBuzz");
			i += 15;
			fbFlag = false;
			notifyAll();
		}
	}

	synchronized public void printNumbers() {
		
		for (int i = 0; i < maxNumber; i++) {
			while (fbFlag || buzzFlag || fizzFlag) {
				
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (i % 5 == 0 && i % 3 == 0) {
				fbFlag = true;
			} else if (i % 5 == 0) {
				buzzFlag = true;
			} else if (i % 3 == 0) {
				fizzFlag = true;
			}else {
				System.out.println(i);
			}
			notifyAll();
		}
	}
}
