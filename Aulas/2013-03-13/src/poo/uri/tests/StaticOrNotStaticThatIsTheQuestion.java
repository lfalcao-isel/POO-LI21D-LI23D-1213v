package poo.uri.tests;

public class StaticOrNotStaticThatIsTheQuestion {
	private static int _Count = 0;
	
	private int _count = 0;
	
	public void incrementInstance() {
		++this._count;
		++_Count;
	}
	
	public static void incrementClass() {
		++_Count;
	}

	public static int getCountClass() {
		return _Count;
	}
	
	public int getCountInstance() {
		return _count;
	}

	
	

}
