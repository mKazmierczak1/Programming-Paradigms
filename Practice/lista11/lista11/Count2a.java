public class Count2a extends Thread {
	
	private static IntCell n = new IntCell();
	
	@Override 
	public void run() {
		int temp;

		for (int i = 0; i < 200000; i++) {
			temp = n.getN();
			n.setN(temp + 1);
		}
			
	}
	
	public static void main(String[] args) {
		Count2a p = new Count2a();
		Count2a q = new Count2a();
		
		p.start();
		q.start();
		
		try { 
			p.join(); 
			q.join(); 
		}
		catch (InterruptedException e) {}
		
		System.out.println("The value of n is " + n.getN());
	}

}


class IntCell {
	private int n = 0;
	private boolean wasSet = true;
	
	public synchronized int getN() {
		while (!wasSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		wasSet = false;
		notifyAll();
		return n; 
	}
	
	public synchronized void setN(int n) {
		while (wasSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.n = n; 
		wasSet = true;
		notify();
	}
}

