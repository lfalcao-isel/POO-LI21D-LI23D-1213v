package poo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray<T> implements Iterator<T> {

	private T[] _array;
	int _idx = 0;

	public IteratorArray(T[] array) {
		_array = array;
		
	}

	@Override
	public boolean hasNext() {
		return _idx < _array.length;
	}

	@Override
	public T next() {
		if(hasNext())
			return _array[_idx++];
		throw new NoSuchElementException();	
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
