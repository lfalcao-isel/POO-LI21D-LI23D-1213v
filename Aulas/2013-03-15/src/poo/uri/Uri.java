package poo.uri;

public class Uri {
	private String _schema;
	private String _host;
	private int _port = -1;
	private String _path;
	private String _queryString = "";
	private String _type;
	private String _email;
	
	private String _uriStr;
	
	
	

    public Uri(String uriStr) {
    	_uriStr = uriStr;
	}

	private void parseUriHttp() {
		getSegment("//");
		
		// Parse host
				
		_host = getSegment(":");
		if(_host == null) {
			_host = getSegment("/");
		} else {
			_port = Integer.parseInt(getSegment("/"));
		}

		
    	
    	// Parse path
    	_path = getSegment("?");
    	if(_path == null) {
    		_path = _uriStr;
    	} else {
    		if(_schema.equals("http")) {
    			_queryString = _uriStr;
    		} else {
    			getSegment("=");
    			_type = _uriStr;
    		}
    		
    	}
    	
    	_path = '/' + _path;
    	
    	// Done!!!
	}
	
	private void parseUriFtp() {
		
	}
	
	private void parseUriMailto() {
		
	}
	
	private void parseUriGeo() {
		
	}

	public String getSchema() {
		return _schema;
	}
	public String getHost() { return _host; }
    public int getPort() { return _port; }
    //public String getUsername() { return null; }
    //public String getPassword() { return null; }
    public String getPath() { return _path; }
    public String getQueryString() { return _queryString; }
    public String getType() { return _type;	}
    
    
    /*
     * Gets a segment from the @actualString delimited by @delimiter
     * not including the @endChar
     * If delimiter is not found returns null
     */
    private String getSegment(String delimiter) {
    	int idx = _uriStr.indexOf(delimiter);
    	if(idx == -1) {
    		return null;
    	}
    	
    	String segment = _uriStr.substring(0, idx);
    	_uriStr = _uriStr.substring(idx + delimiter.length());
    	return segment;
    	
    }
    
    
	public static Uri createUri(String strUri) {
		Uri u = new Uri(strUri);
		
		String schema = u.ParseSchema(":");
		
		if(schema.equals("http")) {
			u.parseUriHttp();
			return u;
		}
		
		if(schema.equals("ftp")) {
			u.parseUriFtp();
			return u;
		}
		
		if(schema.equals("mailto")) {
			u.parseUriMailto();
			return u;
		}
		
		if(schema.equals("geo")) {
			u.parseUriGeo();
			return u;
		}
		
		return u;
		
	}

	private String ParseSchema(String string) {
		_schema = getSegment(":");
		return _schema;
	}

	public String getEmail() {
		return _email;
	}

	

	
	
	
	// How to support different schemas, namely:
	// ftp://<host>[:<port>]/path/?type=[a|b]
	// mailto:<emailAddress>(<name>=<value>&)*
	
	
	
}




