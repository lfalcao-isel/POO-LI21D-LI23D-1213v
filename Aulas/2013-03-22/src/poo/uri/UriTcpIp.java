package poo.uri;

/**
 * Base class for all TCP/IP Uri schemes
 * 
 * @author lfalcao
 *
 */
public abstract class UriTcpIp extends Uri {
	protected String _host;
	protected int _port;
	protected String _path;
	
	public UriTcpIp(String uriStr) {
    	super(uriStr);
	}

	
	protected void parseUri() {
		
	}
	/**
	 * The Uri host
	 * @return The Uri host
	 */
	public String getHost() { return _host; }
	
	
	/**
	 * The Uri port
	 * @return The Uri port
	 */
    public int getPort() { return _port; }
    
    /**
	 * The Uri path
	 * @return The Uri path
	 */
    public String getPath() { return _path; }
}
