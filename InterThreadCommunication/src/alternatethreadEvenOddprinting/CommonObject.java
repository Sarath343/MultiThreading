package alternatethreadEvenOddprinting;

public class CommonObject {
	boolean flag;

	public CommonObject(boolean b) {
		this.flag = b;
	}

	synchronized public void oddPrint() {
		int i = 1;
		while (i < 200) {
			while (flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			i += 2;
			flag = true;
			notify();
		}
	}

	synchronized public void evenPrint() {
		int i = 0;
		while (i < 200) {
			while (!flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			i += 2;
			flag = false;
			notify();
		}
	}
}
