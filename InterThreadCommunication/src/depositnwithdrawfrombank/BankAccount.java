package depositnwithdrawfrombank;

public class BankAccount {
	public BankAccount(int i) {
		this.balance = i;
	}

	Integer balance;

	public synchronized void deposit(int i) {
		balance = balance + i;
		System.out.println("deposit "+i+" by "+Thread.currentThread().getName()+" current balance "+balance);

	}

	public synchronized void withDraw(int i) {
		if (balance - i > 0) {
			balance = balance - i;
			System.out.println("Withdraw " + i +" by "+Thread.currentThread().getName()+ " current balance " + balance);

		} else {
			System.out.println("Withdraw " + i +" by "+Thread.currentThread().getName()+ " Insufficient balance ");
		}
	}

	public int getBalance() {
		return balance;
	}

}
