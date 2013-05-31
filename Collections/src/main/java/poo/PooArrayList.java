package poo;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class PooArrayList<T> extends AbstractCollection<T> {
	private class PooArrayListIterator<T> implements Iterator<T> {
		private int _currPos = 0;
		
		
		@Override
		public boolean hasNext() {
			return _currPos < size();
			
		}

		@Override
		public T next() {
			if(hasNext())
				return (T)_array[_currPos];
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
		// TODO
		
		--_currIdx;
	}

	
	
	public PooArrayList() {
		_array = new Object[DEFAULT_SIZE];
		_sizeIncrement = DEFAULT_SIZE;
	}
	
	public PooArrayList(int size) {
		_array = new Object[size];
		_sizeIncrement = size;
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
		return new PooArrayListIterator<T>();
	}

	@Override
	public int size() {
		return _currIdx;
	}

}
