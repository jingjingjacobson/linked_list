/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
 */
package LinkedList_A1;


public class LinkedListImpl implements LIST_Interface {
	Node sentinel; //this will be the entry point to your linked list (the head)
	private int numElts;

	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
		this.numElts = 0;
	}

	//implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		if(index < 0 || index > this.size()) {
			return false;
		}
		else if(index == 0 && this.size() == 0) {
//			sentinel.next = sentinel;
//			sentinel.prev = sentinel;
			Node n = new Node(elt);
			sentinel.next = n;
			sentinel.prev = n;
			n.next = sentinel;
			n.prev = sentinel;
			numElts += 1;
			return true;
		}
		else {
			Node curr = this.sentinel.next;
			Node pre = this.sentinel;
			
			for(int i = 0; i < index; i++) {
				pre = curr;
				curr = curr.next;
			}
			Node n = new Node(elt);
			pre.next = n;
			n.prev = pre;
			n.next = curr;
			curr.prev = n;
			numElts += 1;
			return true;
		}
	}

	@Override
	public boolean remove(int index) {

		if(index < 0 || index > this.size()) {
			return false;
		}
		else {
			Node curr = this.sentinel.next;
			for(int i = 0; i < index; i++) {
				curr = curr.next;
			}
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			numElts -= 1;
			return true;
		}
	}

	@Override
	public double get(int index) {
		if(index < 0 || index > this.size() || this.size() == 0) {
			return Double.NaN; 
		}
		else {
			Node curr = this.sentinel.next;
			for(int i = 0; i < index; i++) {
				curr = curr.next;
			}
			return curr.data;
		}
	}

	@Override
	public int size() {
		return numElts;
	}

	@Override
	public boolean isEmpty() {
		if(this.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void clear() {
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		numElts = 0;


	}
}