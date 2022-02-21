package Lista8zad1;

import java.util.ArrayList;

public class CyclicArrayQueue<E> implements MyQueue<E> {

	private ArrayList<E> a;
	private int f, r;
	
	public CyclicArrayQueue(int Size) {
		a = new ArrayList<E>(Size + 1);
		f = 0;
		r = 0;
		
		for (int i = 0; i <= Size; i++)
			a.add(null);
	}
	
	@Override
	public void enqueue(E x) throws FullException {
		if (isFull()) throw new FullException("CyclicArrayQueue<E>: enqueue");
		
		a.set(r, x);
		r = (r + 1) % a.size();
	}

	@Override
	public void dequeue() {
		if (!isEmpty()) {
			f = (f + 1) % a.size();
		}
	}

	@Override
	public E first() throws EmptyException {
		if (isEmpty()) throw new EmptyException("CyclicArrayQueue<E>: first");
		
		return a.get(f);
	}

	@Override
	public boolean isEmpty() {
		return f == r;
	}

	@Override
	public boolean isFull() {
		return (a.size() - 1 == r - f || f - r == 1);
	}

}
