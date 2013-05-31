import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Test;

import poo.NumberGenerator;


public class NumberGeneratorTests {

	//
	// Private auxiliary methods
	//
	private void iterateThroughIterator(Iterator<Integer> iter, int numIters) {
		for(int i = 0; i < numIters; ++i) {
			Assert.assertTrue(iter.hasNext());
			Assert.assertEquals((int)iter.next(), i);
		}
		
		Assert.assertFalse(iter.hasNext());
	}

	
	
	//
	// Tests for self iteration
	//
	
	@Test
	public void nextShouldReturn3Values() {
		// Arrange
		NumberGenerator gen = new NumberGenerator(3);
		
		// Act and Assert
		Assert.assertTrue(gen.hasNext());
		Assert.assertEquals(gen.next(), 0);
		
		Assert.assertTrue(gen.hasNext());
		Assert.assertEquals(gen.next(), 1);
		
		Assert.assertTrue(gen.hasNext());
		Assert.assertEquals(gen.next(), 2);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void nextShouldThrowNoSuchElementException() {
		// Arrange
		NumberGenerator gen = new NumberGenerator(0);
		
		// Act and Assert
		gen.next();
	}
	
	
	//
	// Tests for iteration through iterators
	//
	@Test
	public void shouldReturnAValidIterator() {
		// Arrange
		NumberGenerator gen  = new NumberGenerator(0);
		
		
		// Act
		Iterator<Integer> iter = gen.iterator();
		
		// Assert
		Assert.assertNotNull(iter);
	}
	
	
	@Test
	public void shouldIterateThroughIterator() {
		// Arrange
		NumberGenerator gen  = new NumberGenerator(2);
		
		
		Iterator<Integer> iter = gen.iterator();
		
		// Act and Assert
		iterateThroughIterator(iter, 2);
	}

	@Test
	public void shouldIterateThroughTwoIterators() {
		// Arrange
		NumberGenerator gen  = new NumberGenerator(2);
		Iterator<Integer> iter1 = gen.iterator();
		Iterator<Integer> iter2 = gen.iterator();

		// Act and Assert
		iterateThroughIterator(iter1, 2);
		iterateThroughIterator(iter2, 2);
	}

}
