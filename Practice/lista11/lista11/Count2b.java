import java.util.concurrent.Semaphore;

public class Count2b extends Thread {
	
	private static IntCell n = new IntCell();
	private static Semaphore s = new Semaphore(1);

	@Override 
	public void run() {
		int temp;

		for (int i = 0; i < 200000; i++) {
			try {
				s.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			temp = n.getN();
			n.setN(temp + 1);
			
			s.release();
		}
			
	}
	
	public static void main(String[] args) {
		Count2b p = new Count2b();
		Count2b q = new Count2b();
		
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
	
	public int getN() { return n; }
	public void setN(int n) { this.n = n; }
}