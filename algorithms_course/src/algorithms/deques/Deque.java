package algorithms.deques;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	
	private int dequeSize = 0;
	
	private Node firstNode;
	private Node lastNode;
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	private class ListIterator implements Iterator<Item> {

		private Node current = firstNode;
		
		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public Item next() {
			if(current.next == null) {
				throw new java.util.NoSuchElementException();
			}
			
			Item item = current.item;
			current = current.next;
			return item;			
		}
		
		@Override
		public void remove() {
			throw new java.lang.UnsupportedOperationException();
		}
 		
	}
	
	public Deque() {                           
		// construct an empty deque	
	}

	public boolean isEmpty() {
		return dequeSize == 0;
	}

	public int size() {
		return dequeSize;
	}

	public void addFirst(Item item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		
		Node node = new Node();
		node.item = item;
		
		if(isEmpty()) {
			firstNode = node;
			lastNode = node;
		} else {
			Node oldFirst = firstNode;
			firstNode = node;
			firstNode.next = oldFirst;
		}
		dequeSize++;
	}

	public void addLast(Item item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		
		Node node = new Node();
		node.item = item;
		
		if(isEmpty()) {
			firstNode = node;
			lastNode = node;
		} else {
			Node oldLast = lastNode;
			lastNode = node;
			lastNode.previous = oldLast;
		}
		dequeSize++;
	}

	public Item removeFirst() {
		if(dequeSize == 0) {
			throw new java.util.NoSuchElementException();
		}
		
		Node node = firstNode;
		
		firstNode = new Node();
		firstNode = node.next;
		firstNode.previous = null;
		dequeSize--;
		
		return node.item;
	}

	public Item removeLast() {
		if(dequeSize == 0) {
			throw new java.util.NoSuchElementException();
		}
		
		Node node = lastNode;
		
		lastNode = new Node();
		lastNode = node.previous;
		lastNode.next = null;
		dequeSize--;
		
		return node.item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		System.out.println("Deque size: " + d.size());
		
		d.addFirst("Primeiro");
		System.out.println("Deque size: " + d.size());
		
		d.addFirst("Segundo");
		System.out.println("Deque size: " + d.size());
		
		d.addFirst("Terceiro");
		System.out.println("Deque size: " + d.size());
		
		d.addFirst("Quarto");
		System.out.println("Deque size: " + d.size());
		
		d.addFirst("Quinto");
		System.out.println("Deque size: " + d.size());
		
		d.addFirst("Sexto");
		System.out.println("Deque size: " + d.size());
		
		
		System.out.println("\nIterator:");
		Iterator<String> dIterator = d.iterator();
		
		while(dIterator.hasNext()) {
			System.out.println(dIterator.next());
		}
		
	}
}