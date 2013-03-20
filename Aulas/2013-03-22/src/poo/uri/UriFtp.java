package poo.uri;

/**
 * Class that represents the ftp Uri scheme.
 * 
 * @author lfalcao
 */
public class UriFtp extends UriTcpIp {
	
	private String _type;

    public UriFtp(String uriStr) {
    	super(uriStr);
	}

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
    	} else {
   			getSegmentAndUpdateUriStr("=");
   			_type = _uriStr;
   		
    	}
    	
    	_path = '/' + _path;
    	
    	// Done!!!
	}
	
	
	/**
	 * The ftp Uri file type 
	 * @return The ftp Uri file type
	 */
    public String getType() { return _type;	}
}




