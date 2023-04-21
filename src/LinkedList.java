import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList {
	static private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Node head = null;
	private Node tail = null;
	public DynamicArray histories = new DynamicArray();
	public Node deletedNode = null;
	public int version = 1;
	public int length = 0;
	public boolean indentifier = true;

	public void addNode(int num) {
		Node newNode = new Node(num);

		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}

		length++;

		if (indentifier)
			histories.add(copyLinkedList());

	}

	public void deleteNode(int num) {
		if (num < 1 || num > length) {
			System.out.println("Invalid Position");
			return;
		}
		
		LinkedList pastll;
		Node cur = get(num);
		
		if (cur == head && cur == tail) {
			head = null;
			tail = null;
		} else if (cur == tail) {
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else if (cur == head) {
			head = head.getNext();
			head.setPrev(null);
		} else if (cur.getPrev() != null && cur.getNext() != null) {
			cur.getPrev().setNext(cur.getNext());
			cur.getNext().setPrev(cur.getPrev());
			setTail();
		}
		
		length--;
		
		pastll = copyLinkedList();
		pastll.deletedNode = cur;
		histories.add(pastll);
		
		System.out.println("The node was successfully deleted!");

	}

	public LinkedList copyLinkedList() {
		LinkedList ll = new LinkedList();
		ll.indentifier = false;
		Node cur = head;

		while (cur != null) {
			int newInt = cur.getData();
			ll.addNode(newInt);
			cur = cur.getNext();
		}

		ll.version = this.version++;

		return ll;

	}

	public void changeValue(int position, int num) throws IOException {
		if (position < 1 || position > length) {
			System.out.println("Invalid Position!");
			return;
		}

		Node cur = get(position);
		cur.setData(num);
		histories.add(copyLinkedList());

	}

	public void nodeHistory(int num) {
		if (num < 1 || num > length) {
			System.out.println("Invalid Position!");
			return;
		}
		
		Node cur = get(num);
		
		System.out.println("\nCurrent value of node " + num + " is " + cur.getData() + ".");
		
		cur = cur.history.getHead();
		if (cur == null) {
			System.out.println("This node has no previous values.");
		} else {
			System.out.print("Previous value of node " + num + " are ");
			while (cur != null) {
				System.out.print(cur.getData() + (cur.getNext() != null ? ", " : ".\n"));
				cur = cur.getNext();
			}
		}
	}

	public void listHistory() {
		Boolean haveDeletedNodes = false;

		display();

		System.out.println("Displaying recent values of the deleted nodes values...");
		for (int i = histories.getSize() - 1; i >= 0; i--) {
			Node temp = histories.get(i).deletedNode;

			if (temp != null) {
				System.out.print("State " + histories.get(i).version + " deleted node with the recent value of: "
						+ temp.getData() + ".\n");
				haveDeletedNodes = true;
			}

		}

		if (!haveDeletedNodes)
			System.out.println("No nodes were deleted.");

		System.out.println("-----------------------------------------------");

		System.out.println("States of the linkedlist: ");
		for (int i = histories.getSize() - 1; i >= 0; i--) {
			Node temp = histories.get(i).getHead();
			if(temp == null) {
				System.out.println("List is empty");
			}
			System.out.print("State " + histories.get(i).version + ": ");
			while (temp != null) {
				System.out.print(temp.getData() + (temp.getNext() != null ? ", " : ".\n"));
				temp = temp.getNext();
			}
		}

	}

	public void display() {
		Node cur = head;
		System.out.println("Displaying values of the existing nodes values...");
		if(head == null || tail == null) {
			System.out.println("Currently the list is empty.");
		}else {
			while (cur != null) {
				System.out.print(cur.getData() + (cur.getNext() != null ? ", " : "\n"));
				cur = cur.getNext();
			}
		}
	}

	public Node get(int position) {
		Node cur = head;
		int nodeCnt = 1;

		while (position != nodeCnt) {
			cur = cur.getNext();
			nodeCnt++;
		}

		return cur;
	}

	public void setTail() {
		Node temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		tail = temp;
	}

	public Node getHead() {
		return head;
	}
	public Node getTail() {
		return tail;
	}
}
