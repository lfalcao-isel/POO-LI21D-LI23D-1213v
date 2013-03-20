package poo.uri;

public class UriGeo extends Uri {
	private float _latitude;
	private float _longitude;
	

	public UriGeo(String uriStr) {
		super(uriStr);
	}

	@Override
	protected void parseUri() {
		// TODO

	}

	public float getLatitude() {
		return _latitude;
	}
	
	public float getLongitude() {
		return _longitude;
	}


}
