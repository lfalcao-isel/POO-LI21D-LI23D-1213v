package poo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class PooLinkedList<T> implements List<T> {
	private class Node {
		public T data;
		public Node next;

		public Node(T e, Node next) {
			data = e;
			this.next = next;
			
		}
	}
	
	
	
	//Node _head = new Node(null, null);
	Node _head = null;
	int _count = 0;
	
	public PooLinkedList() {
	}
	
	public PooLinkedList(Collection<? extends T> arrayStr) {
		addAll(arrayStr);
	}


	private Node getNodeAtIndex(int i) {
		Node curr = _head;
		while(--i > 0) {
			curr = curr.next;
		}
		return curr;

	}
	
	
	@Override
	public boolean add(T e) {
		// Without sentinel
		Node n = new Node(e, null);
		if(_head == null) {
			_head = n;
		}
		
		Node curr = getNodeAtIndex(_count-1);
		curr.next = n;
		++_count;
		return true;
	}
	
//	@Override
//	public boolean add(T e) {
//		// With sentinel
//		
//		Node curr = _head;
//		while(curr.next != null) {
//			curr = curr.next;
//		}
//		curr.next = new Node(e, null);
//		return true;
//	}

	@Override
	public void add(int index, T e) {
		if(index < 0 || index > _count) {
			throw new IndexOutOfBoundsException();
		}
		
		++_count;
		if(_head == null || index == 0) {
			_head = new Node(e, _head);
			return;
		}
		
		Node prev = getNodeAtIndex(index-1);
		prev.next = new Node(e, prev.next);
	}

	

	@Override
	public boolean addAll(Collection<? extends T> c) {
		Node curr = getNodeAtIndex(_count-1);
		int initialCount = _count;
		Iterator<?> iter = c.iterator();
		while(iter.hasNext()) {
			curr = curr.next = new Node((T)iter.next(), null);
			++_count;
		}
		return initialCount != _count;
		
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return _count;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
