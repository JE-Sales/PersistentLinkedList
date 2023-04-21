class Node {
	public LinkedList history = new LinkedList();
	private int data;
	private Node next;
	private Node prev;
	private boolean saved = false;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		if (saved == false) {
			history.addNode(this.data);
			saved = true;
		}
		history.addNode(data);
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}
