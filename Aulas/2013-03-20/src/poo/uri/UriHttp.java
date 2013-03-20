package poo.uri;

public class UriHttp extends UriTcpIp  {

	private String _queryString = "";
	
	
	
	private void parseUri() {
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
    		_queryString = _uriStr;
    	}
    	
    	_path = '/' + _path;
    	
    	// Done!!!
	}


    public UriHttp(String uriStr) {
    	super(uriStr);
    	
    	
    	
	}

		

    public String getQueryString() { return _queryString; }
    
   
    
	public static UriHttp createUri(String strUri) {
		UriHttp u = new UriHttp(strUri);
		
		String schema = u.parseSchema(":");
		
		if(schema.equals("http")) {
			u.parseUri();
			return u;
		}
		
		
		return u;
		
	}
	
}




