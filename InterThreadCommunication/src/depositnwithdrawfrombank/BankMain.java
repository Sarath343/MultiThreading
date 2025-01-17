package depositnwithdrawfrombank;

public class BankMain {

	public static void main(String[] args) {
		BankAccount account = new BankAccount(2500);
		Thread deposit = new Thread(()->{
			for(int i =0 ; i<5 ; i++) {
				account.deposit(150);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"Depositor");
		
		Thread withDraw = new Thread(()->{
			for(int i =0 ; i<6 ; i++) {
				account.withDraw(100);
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		},"Withdrawer");
		
		deposit.start();
		withDraw.start();
		
		System.out.println("Final balance: " + account.getBalance());
		try {
			deposit.join();
			withDraw.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//the below will be executed after both threads are finished because of the join above
		System.out.println("Final balance: " + account.getBalance());

		
	}

}
