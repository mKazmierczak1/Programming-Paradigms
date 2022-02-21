package Lista8zad1;

public class CyclicArrayQueueTest {

	public static void main(String[] args) throws FullException, EmptyException {
		MyQueue<Integer> queue = new CyclicArrayQueue<Integer>(3); 
		
		queue.enqueue(1);    
		queue.enqueue(2);
		
		System.out.println(queue.isFull());  
		
		queue.enqueue(3);
		
		System.out.println(queue.isFull());  
		System.out.println(queue.first());   
		
		queue.dequeue();    
		queue.enqueue(4);
		
		System.out.println(queue.first());
		
		queue.dequeue();
		queue.enqueue(5);
		
		System.out.println(queue.first());
		
		queue.dequeue();
		queue.dequeue();
		 
		System.out.println(queue.isEmpty());
		System.out.println(queue.first());
		
		queue.dequeue();
		
		System.out.println(queue.isEmpty());

		
	}

}
