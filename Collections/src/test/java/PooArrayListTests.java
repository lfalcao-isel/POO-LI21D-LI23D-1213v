import java.util.Comparator;

import junit.framework.Assert;

import org.junit.Test;

import poo.CollectionUtils;
import poo.PooArrayList;


public class PooArrayListTests {
	
	private PooArrayList<Car> createCarList() {
		PooArrayList<Car> list = new PooArrayList<>();
		list.add(new Car("Ferrari", 2013));
		list.add(new Car("Porshe", 2012));
		list.add(new Car("Smart", 2010));
		
		return list;
		
	}
	
	//
	// Private auxiliary methods
	//
	private void removeElement(String toRemove, boolean expectedResult, int listSize) {
		String []arrayStr = new String[] { "aaa", "bbb", "ccc" };
		PooArrayList<String> list = new PooArrayList<String>( arrayStr );
		
		
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
	// Tests for 
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
	
	@Test
	public void shouldNotRemoveANonExistantElement() {
		// Arrange Act and Assert
		removeElement("ddd", false, 3);
	}
	
	// Tests for an ArrayList with Car objects
	@Test
	public void shouldContainAPorshe() {
		// Arrange
		PooArrayList<Car> list = createCarList();
		Car porshe = new Car("Porshe", 11);
				
		// Act
		
		// Inner class usage
//		Comparator<Car> myComparator = 	new Comparator<Car>() {
//			@Override
//			public int compare(Car car1, Car car2) {
//				return car1.getBrand().compareTo(car2.getBrand());
//			}
//		};
		
		Comparator<Car> myComparator = 	new MyCarComparator();

		boolean res = list.contains(porshe, myComparator);
		
		// Assert
		Assert.assertTrue(res);
		
		new CollectionUtils().max(list, null);
	}
	
	
	
	
	

	private class MyCarComparator implements Comparator<Car> {
		@Override
		public int compare(Car car1, Car car2) {
			return car1.getBrand().compareTo(car2.getBrand());
		}
	
	}
}
