package poo;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;




public class PooArrayList<T> extends AbstractCollection<T> implements List<T> {
	private class PooArrayListIterator implements Iterator<T> {
		private int _currPos = 0;
		
		
		@Override
		public boolean hasNext() {
			return _currPos < size();
			
		}

		@Override
		public T next() {
			if(hasNext())
				return (T)_array[_currPos++];
			throw new NoSuchElementException();	
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
	
	private static final int DEFAULT_SIZE = 20;
	private Object[] _array; 
	private int _currIdx = 0;
	private int _sizeIncrement;
	
	
	private void removeAtIndex(int i) {
		for(; i < _currIdx -1; ++i) {
			_array[i] = _array[i+1];
		}
		_array[--_currIdx] = null;
	}

	private void createArray(int size) {
		_array = new Object[size];
		_sizeIncrement = size;
	}
	
	private void addAll(Iterator<T> iter) {
		while(iter.hasNext()) {
			add(iter.next());
		}
	}
	
	
	public PooArrayList() {
		createArray(DEFAULT_SIZE);
	}
	
	public PooArrayList(int size) {
		createArray(size);
	}
	
	
	public PooArrayList(Collection<T> coll) 
	{
		//this((T[])coll.toArray());
		createArray(coll.size()+DEFAULT_SIZE);
		addAll(coll.iterator());
	}
	
	public PooArrayList(T[] array) {
		createArray(array.length+DEFAULT_SIZE);
		addAll(new IteratorArray<T>(array));
	}



	@Override
	public boolean add(T elem) {
		if(_currIdx == _array.length) {
			Object []newArray = new Object[_array.length + _sizeIncrement];
			for(int i = 0; i < _array.length; ++i) {
				newArray[i] = _array[i];
			}
			
			_array = newArray;
		}
		
		_array[_currIdx++] = elem;
		return true;
	}
	
	@Override
	public boolean remove(Object elem) {
		for(int i = 0; i < _currIdx; ++i) {
			if(_array[i].equals(elem)) {
				removeAtIndex(i);
				return true;
			}
		}
		
		return false;
		
	}
	

	@Override
	public Iterator<T> iterator() {
		return new PooArrayListIterator();
	}

	@Override
	public int size() {
		return _currIdx;
	}

	public boolean contains(T elemeToFind, Comparator<T> comparator) {
		Iterator<T> iter = iterator();
		while(iter.hasNext()) {
			if(comparator.compare(iter.next(), elemeToFind) == 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void add(int arg0, T arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(int idx) {
		if(idx >= _currIdx) {
			throw new IndexOutOfBoundsException();
		}
		return (T)_array[idx];
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
