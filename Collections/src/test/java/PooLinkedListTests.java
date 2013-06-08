import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


import poo.PooArrayList;
import poo.PooLinkedList;


public class PooLinkedListTests {
	
	private static final String STR = "aaa";



	private PooLinkedList<Car> createCarList() {
		PooLinkedList<Car> list = new PooLinkedList<Car>();
		
		list.add(new Car("Ferrari", 2013));
		list.add(new Car("Porshe", 2012));
		list.add(new Car("Smart", 2010));
		
		return list;
		
	}
	
	//
	// Private auxiliary methods
	//
	private void removeElement(String toRemove, boolean expectedResult, int listSize) {
		String []arrayStr = new String[] { STR, "bbb", "ccc" };
		PooLinkedList<String> list = new PooLinkedList<String>(null);
		
		
		// Act
		boolean result = list.remove(toRemove);
		
		// Assert
		Assert.assertEquals(expectedResult, result);
		Assert.assertEquals(listSize, list.size());
		Assert.assertFalse(list.contains(toRemove));
	}
	
	private void removeElement(String toRemove) {
		removeElement(toRemove, true, 2);
	}
	

	//
	// Tests for add
	//
	
	@Test
	public void shouldAddForAnEmptyCollection() {
		// Arrange
		List<String> coll = new PooLinkedList<String>();
		
		// Act
		coll.add(STR);
		
		// Assert
		Assert.assertEquals(1, coll.size());
		Assert.assertEquals(1, coll.contains(STR));
		Assert.assertEquals(STR, coll.get(0));
	}

	
	//
	// Tests for remove
	//
	
	@Test
	public void shouldRemoveAtTheFirstPosition() {
		removeElement(STR);
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
	
	@Test
	public void shouldNotRemoveANonExistantElement() {
		// Arrange Act and Assert
		removeElement("ddd", false, 3);
	}
	
	// Tests for an ArrayList with Car objects
	@Test
	public void shouldContainAPorshe() {
		// Arrange
		PooLinkedList<Car> list = createCarList();
		Car porshe = new Car("Porshe", 11);
				
		// Act
		
		// Inner class usage
//		Comparator<Car> myComparator = 	new Comparator<Car>() {
//			@Override
//			public int compare(Car car1, Car car2) {
//				return car1.getBrand().compareTo(car2.getBrand());
//			}
//		};
		boolean res = list.contains(porshe);
		
		// Assert
		Assert.assertTrue(res);
	}
	
	

	
}
