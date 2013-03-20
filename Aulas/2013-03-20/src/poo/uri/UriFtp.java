package poo.uri;

public class UriFtp extends UriTcpIp {
	
	private String _type;


	
    public UriFtp(String uriStr) {
    	super(uriStr);
	}

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
   			getSegment("=");
   			_type = _uriStr;
   		
    	}
    	
    	_path = '/' + _path;
    	
    	// Done!!!
	}
	
	

	public String getSchema() {
		return _schema;
	}
	public String getHost() { return _host; }
    public int getPort() { return _port; }
    public String getPath() { return _path; }
    public String getType() { return _type;	}
    
    
    
    
    
	public static UriFtp createUri(String strUri) {
		UriFtp u = new UriFtp(strUri);
		
		String schema = u.parseSchema(":");
		
		
		if(schema.equals("ftp")) {
			u.parseUri();
			return u;
		}
		
		return u;
		
	}
}




