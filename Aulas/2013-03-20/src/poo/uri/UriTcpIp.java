package poo.uri;

/**
 * @author lfalcao
 *
 */
public class UriTcpIp extends Uri {
	protected String _host;
	protected int _port = -1;
	protected String _path;
	
	public UriTcpIp(String uriStr) {
    	super(uriStr);
	}

	public String getHost() { return _host; }
    public int getPort() { return _port; }
    public String getPath() { return _path; }
    
    
    
    
	/*
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
	*/	
}




