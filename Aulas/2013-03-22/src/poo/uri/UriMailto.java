package poo.uri;

public class UriMailto extends Uri {
	
	private String _email;
	
	public UriMailto(String str) {
		super(str);
	}
	
	public String getEmail() { return _email; }

	@Override
	protected void parseUri() {
		// TODO
	}

}
