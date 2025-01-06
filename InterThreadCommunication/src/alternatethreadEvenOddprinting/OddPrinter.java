package alternatethreadEvenOddprinting;

public class OddPrinter extends Thread{
	CommonObject cmn ; 
	
	 public OddPrinter(CommonObject common) {
		 this.cmn = common ; 
	}

	public void run() {
		 cmn.oddPrint();
	 }
}
