// CSE 205: 11333 | Tue/Thu 4:30 PM
// Assignment: Two Array List & Linked List
// Author: Joseph H Cottingham | 1216723703
// Description: Implementaion of MyList to create a duplication for the java util LinkList class

package LeaderBoard;

import java.nio.file.NotDirectoryException;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Object> {
	private Node head = null;
	private int size = 0;

	public void add(T o) {
		Node node = new Node();
		node.data = o;
		if (head != null) {
			Node tempNode = head;
			while (tempNode.next != null) tempNode = tempNode.next;
			tempNode.next = node;
		} else head = node;
		size++;
	}

	public void insert(int index, T o) {
		if (index == size) add(o);
		else if (index < size && index >= 0) {
			Node node = new Node();
			node.data = o;
			Node tempNodePrev = head;
			for (int x = 1; x < index; x++) tempNodePrev = tempNodePrev.next;
			if (index == 0) {
				node.next = tempNodePrev;
				head = node;
			} else {
				node.next = tempNodePrev.next;
				tempNodePrev.next = node;
			}
			size++;
		} else throw new NoSuchElementException();
	}

	public void remove(int index) {
		if (index < size && index >= 0) {
			Node tempNode = head;
			for (int x = 1; x < index; x++) {
				tempNode = tempNode.next;
			}
			if (index == 0) head = tempNode.next;
			else tempNode.next = tempNode.next.next;
			size--;
		} else throw new NoSuchElementException();
	}

	public T get(int index) {
		if (index < size && index >= 0) {
			Node tempNode = head;
			for (int x = 0; x < index; x++) {
				tempNode = tempNode.next;
			}
			return tempNode.data;
		} else throw new NoSuchElementException();
	}

	public int size() {
		return size;
	}

	// Do not alter the code below 

	public MyListIterator getIterator() {
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements MyListIterator {
		Node currentNode = null;

		@Override
		public Object next() {
			if (currentNode != null)
				currentNode = currentNode.next;
			else
				currentNode = head;

			return currentNode.data;
		}

		@Override
		public boolean hasNext() {
			if (currentNode != null)
				return currentNode.next != null;
			else
				return head != null;
		}
	}

	class Node {
		public T data = null;
		public Node next = null;
	}
}
