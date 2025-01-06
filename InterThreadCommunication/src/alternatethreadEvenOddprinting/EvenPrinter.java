package alternatethreadEvenOddprinting;

public class EvenPrinter extends Thread {
	CommonObject cmn;

	public EvenPrinter(CommonObject common) {
		this.cmn = common;
	}

	public void run() {
		cmn.evenPrint();
	}
}
