import java.util.Iterator;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Test;

import poo.NumberGenerator;
import poo.PooArrayList;


public class PooArrayListTests {

	//
	// Private auxiliary methods
	//
	

	
	
	//
	// Tests for self iteration
	//
	
	@Test
	public void shouldRemoveAtTheFirstPosition() {
		removeElement("aaa");
	}
	
	@Test
	public void shouldRemoveAtLastPosition() {
		// Arrange Act and Assert
		removeElement("ccc");
	}
	
	@Test
	public void shouldRemoveAtMiddlePosition() {
		// Arrange Act and Assert
		removeElement("bbb");
	}

	private void removeElement(String toRemove) {
		String []arrayStr = new String[] { "aaa", "bbb", "ccc" };
		PooArrayList<String> list = new PooArrayList<String>( arrayStr );
		
		
		// Act
		list.remove(toRemove);
		
		
		// Assert
		Assert.assertEquals(2, list.size());
		Assert.assertFalse(list.contains(toRemove));
	}
	

}
