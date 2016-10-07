package algorithms.deques;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int queueSize;
	private int head;
	private int tail;
	private Item[] queue;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		queueSize = 0;
		head = 0;
		tail = head + 1;
		queue = (Item[]) new Object[10];
	}

	public boolean isEmpty() {
		return queueSize == 0;
	}

	public int size() {
		return queueSize;
	}

	public void enqueue(Item item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		
		if(queueSize > (queue.length - 1)) {
			resize();
		}
		
		queue[tail] = item;
		tail++;
		queueSize++;
	}

	public Item dequeue() {
		if(isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		
		Item temp = queue[head];
		queueSize--;
		head++;
		
		if(head > (queue.length - 1)) {
			head = 0;
		}
		
		return temp;
	}

	public Item sample() {
		if(isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
		
		return queue[head];
	}
	
	private void resize() {
		@SuppressWarnings("unchecked")
		Item[] newQueue = (Item[]) new Object[queue.length * 2];
		
		int headTemp = head;
		
		for(int i = 0; i < queue.length; i++) {
			newQueue[i] = queue[headTemp];
			headTemp++;
			if(headTemp > queue.length) {
				headTemp = 0;
			}
		}
		
		head = 0;
		tail = queue.length + 1;
		queue = newQueue;		
	}

	@Override
	public Iterator<Item> iterator() {
		return null;
	}

	public static void main(String[] args) {
		
	}
}
