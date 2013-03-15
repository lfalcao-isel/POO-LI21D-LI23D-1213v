package poo.uri.tests;

import poo.uri.Uri;

public class StaticOrNotStaticThatIsTheQuestionTests {
	
	public static void testIncrementInstance() {
		// Arrange 
		StaticOrNotStaticThatIsTheQuestion sns = new StaticOrNotStaticThatIsTheQuestion();
		StaticOrNotStaticThatIsTheQuestion sns1 = new StaticOrNotStaticThatIsTheQuestion();
		
		// Act
		sns.incrementInstance();
		sns1.incrementInstance();
		sns1.incrementInstance();
		
		
		// Assert
		assertEquals(sns.getCountInstance(), 1);
		assertEquals(sns1.getCountInstance(), 2);
		assertEquals(StaticOrNotStaticThatIsTheQuestion.getCountClass(), 3);
		
		
	}

	public static void testIncrementClass() {
		// Arrange 
		
		
		// Act
		StaticOrNotStaticThatIsTheQuestion.incrementClass();
		int countClass1 = StaticOrNotStaticThatIsTheQuestion.getCountClass();
		StaticOrNotStaticThatIsTheQuestion.incrementClass();
		int countClass2 = StaticOrNotStaticThatIsTheQuestion.getCountClass();
		
		
		// Assert
		assertEquals(countClass1, 1);
		assertEquals(countClass2, 2);
	}
	
	
	
	private static void assertEquals(String actual, String expected) {
		if(expected.equals(actual) == false) {
			System.out.println("Expected " + expected + " actual value is " + actual);
			assert(expected.equals(actual));
		}
		
	}
	
	private static void assertEquals(int actual, int expected) {
		if(expected != actual) {
			System.out.println("Expected " + expected + " actual value is " + actual);
			assert(expected == actual);
		}
		
	}


	public static void main(String[] args) {
		
		System.out.println("Begin Tests StaticOrNotStaticThatIsTheQuestion");
		
		testIncrementInstance();
		testIncrementClass();
		
		System.out.println("End Tests StaticOrNotStaticThatIsTheQuestion");
	}


}
