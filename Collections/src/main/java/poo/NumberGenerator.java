package poo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NumberGenerator implements Iterable<Integer>  {
	private class NumberGeneratorIterator implements Iterator<Integer> {
		private int _current = 0;
		
		NumberGeneratorIterator(int max) {
			_max = max;
		}
		
		@Override
		public boolean hasNext() {
			return _current < _max;
		}

		@Override
		public Integer next() {
			if(hasNext())
				return _current++;
			throw new NoSuchElementException();		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private int _max;
	private int _current = 0;

	public NumberGenerator(int max) {
		this._max = max;
	}
	
	public Iterator<Integer> iterator() {
		return new NumberGeneratorIterator(_max);
	}
	
	public boolean hasNext() {
		return _current < _max;
	}
	
	public int next() {
		if(hasNext())
			return _current++;
		throw new NoSuchElementException();
	}
}
