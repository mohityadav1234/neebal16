
import java.util.StringJoiner;

public class LLTest {

	public static void main(String[] args) {
		LinkedList<Integer> x = new LinkedList<>();
		x.add(10);
		x.add(20);
		x.add(50);
		x.add(30);
		x.add(40);
		System.out.println("Given Linked List Set: " + x); 
		int m = x.max();
		System.out.println("Maximum number in list: " + m); 
		x.delete(50);
		System.out.println("Delete 50 number: " + x); 
		x.delete(10);
		System.out.println("Delete 10 number: " + x); 
		x.addBeg(15);
		System.out.println("Add begining link list: " + x); 
		x.addBeg1(5);
		System.out.println("Add begining link list: " + x); 
		int n = x.count();
		System.out.println("No. of Nodes: " + n); 
		x.insertAt(25, 4);
		System.out.println("Insert new Node: " + x); 
		x.insertAt(2, 1);
		System.out.println("Insert New Node: " + x); 
		x.deleteAt(3);
		System.out.println("Delete node 3: " + x); 
		x.deleteAt(1);
		System.out.println("Delete node 1: " + x); 
		x.insertOrder(27);
		System.out.println("InsertOrder 27: " + x); 
		x.insertOrder(35);
		System.out.println("InsertOrder 35: " + x); 
		x.insertOrder(3);
		System.out.println("InsertOrder 3: " + x); 

	}

}

class LinkedList<T> {
	private Node<T> First;

	public static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	// add a new node
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (First == null) {
			First = newNode;
		} else {
			Node<T> c = First;
			while (c.next != null) {
				c = c.next;
			}
			c.next = newNode;
		}
	}

	// find the maximum value.
	public T max() {
		T max = First.data;
		Node<T> c = First.next;

		while (c != null) {
			if (((Integer) c.data).compareTo((Integer) max) > 0) {
				max = c.data;
			}
			c = c.next;
		}
		return max;
	}
	// delete a node
	public void delete(T value) {
		if (First == null) {
			return;
		}
		if (First.data.equals(value)) {
			First = First.next;
			return;
		}
		Node<T> c = First;
		while (c.next != null && !c.next.data.equals(value)) {
			c = c.next;
		}
		if (c.next != null) {
			c.next = c.next.next;
		}
	}

	// add a node at the beginning
	public void addBeg(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = First;
		First = newNode;
	}

	public void addBeg1(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next = First;
		First = newNode;
	}

	// count the number of nodes
	public int count() {
		int count = 0;
		Node<T> c = First;

		while (c != null) {
			count++;
			c = c.next;
		}

		return count;
	}

	// insert a node
	public void insertAt(T data, int position) {

		Node<T> newNode = new Node<>(data);
		if (position == 1) {
			newNode.next = First;
			First = newNode;
			return;
		}

		Node<T> c = First;
		for (int i = 1; i < position - 1; i++) {
			c = c.next;
		}

		newNode.next = c.next;
		c.next = newNode;
	}
	// delete a node
	public void deleteAt(int position) {

		if (position == 1) {
			First = First.next;
			return;
		}

		Node<T> c = First;
		for (int i = 1; i < position - 1; i++) {
			c = c.next;
		}
		c.next = c.next.next;
	}
	// insert a node
	public void insertOrder(T data) {
		Node<T> newNode = new Node<>(data);

		if (First == null || (((Integer) First.data).compareTo((Integer) data) > 0)) {
			newNode.next = First;
			First = newNode;
			return;
		}
		Node<T> c = First;
		while (c.next != null && (((Integer) c.next.data).compareTo((Integer) data) < 0)) {
			c = c.next;
		}
		newNode.next = c.next;
		c.next = newNode;
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		Node<T> c = First;

		while (c != null) {
			joiner.add(String.valueOf(c.data));
			c = c.next;
		}

		return joiner.toString();
	}
}