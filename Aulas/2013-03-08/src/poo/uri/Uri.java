package poo.uri;

public class Uri {
	private String _host;
	private int _port = -1;
	private String _path;
	private String _queryString = "";
	

    public Uri(String uriStr) {
    	
    	// Parse host
    	uriStr = uriStr.substring("http://".length());
    	int idx = uriStr.indexOf(':');
    	if(idx != -1) {
    		// Uri has port
    		_host = uriStr.substring(0, idx);
    		uriStr = uriStr.substring(idx+1);   // remove the host from uriStr
    		idx = uriStr.indexOf('/'); 
    		_port = Integer.parseInt(uriStr.substring(0, idx));
    		uriStr = uriStr.substring(idx);
    	} else {
    		// Uri has no port
    		idx = uriStr.indexOf('/');
    		_host = uriStr.substring(0, idx);
    		uriStr = uriStr.substring(idx);
    	}
    	
    	// Parse path
    	idx = uriStr.indexOf('?');
    	if(idx == -1) {
    		idx = uriStr.length();
    	}
    	
    	_path = uriStr.substring(0, idx);
    	
    	// Parse QueryString if exists
    	if(idx != uriStr.length()) {
    		_queryString = uriStr.substring(idx+1);
    	}
    	
    	// Done!!!
	}
    
	public String getHost() { return _host; }
    public int getPort() { return _port; }
    //public String getUsername() { return null; }
    //public String getPassword() { return null; }
    public String getPath() { return _path; }
    public String getQueryString() { return _queryString; }
    
    
    private String getSubstring(String actualString, char endChar) {
    	return null;
    }
    
    
	public static Uri createUri(String strUri) {
		Uri u = new Uri(strUri);
		return u;
	}
}