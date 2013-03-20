package poo.uri;

public class UriHttp extends UriTcpIp  {

	private String _queryString;
	
	
	@Override
	protected void parseUri() {
		
		getSegmentAndUpdateUriStr("//");
		
		// Parse host
				
		_host = getSegmentAndUpdateUriStr(":");
		if(_host == null) {
			_host = getSegmentAndUpdateUriStr("/");
			_port = -1;
		} else {
			_port = Integer.parseInt(getSegmentAndUpdateUriStr("/"));
		}

		
    	
    	// Parse path
    	_path = getSegmentAndUpdateUriStr("?");
    	if(_path == null) {
    		_path = _uriStr;
    		_queryString = "";
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
}




