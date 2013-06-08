
public class Car {
	private String _brand;
	private int _year;
	
	
	public Car(String brand, int year) {
		_brand = brand;
		_year = year;
		
	}
	
	public String getBrand() {
		return _brand;
	}
	public void setBrand(String _brand) {
		this._brand = _brand;
	}
	public int getYear() {
		return _year;
	}
	public void setYear(int _year) {
		this._year = _year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_brand == null) ? 0 : _brand.hashCode());
		result = prime * result + _year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (_brand == null) {
			if (other._brand != null)
				return false;
		} else if (!_brand.equals(other._brand))
			return false;
		if (_year != other._year)
			return false;
		return true;
	}
	
	
	
	
}
