package poo;

class Xpto {
	private int x;
	String s;

	Xpto() {
		
	}
	
	Xpto(int x, String s) {
		this.x = x;
		this.s = s;
	}
	public void m1() {
		
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Xpto)) {
			return false;
		}
		
		Xpto that = (Xpto)o;
		return this.x == that.x && (this.s != null && this.s.equals(that.s));
	}
	
	@Override
	public int hashCode() {
		return x + (s != null ? s.hashCode() : 0);
	}
	
	@Override
	public String toString() {
		return "Xpto as as String " + super.toString();
	}
}

class Ypto extends Xpto {
	int y; 
	
	@Override
	public void m1() {
		
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Ypto)) {
			return false;
		}
		if(!super.equals(o)) {
			return false;
		}
		
		Ypto that = (Ypto)o;
		return this.y == that.y;
	}
}

public class App {
	
	public static void main(String[] args) {
		Xpto  x = new Xpto();
		Xpto  x1 = new Xpto(2, "abc");
		Xpto  x2 = new Xpto(2, "abc");
		
		System.out.println(x == x1);
		System.out.println(x.equals(x1));
		System.out.println(x1.equals(x2));
		
		System.out.println(x.hashCode());
		System.out.println(x1.hashCode());
		System.out.println(x2.hashCode());
		
		System.out.println(x1.equals("abc"));
		
		System.out.println(x);
	}
}


