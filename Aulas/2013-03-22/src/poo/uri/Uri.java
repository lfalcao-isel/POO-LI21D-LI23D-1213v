package poo.uri;

import poo.uri.factories.FtpUriFactory;
import poo.uri.factories.HttpUriFactory;
import poo.uri.factories.IUriFactory;
import poo.uri.factories.MailtoUriFactory;


/**
 * Base class for all Uris
 * 
 * @author lfalcao
 */
public abstract class Uri {
	/**
	 * Array of Uri factories
	 */
	private final static IUriFactory[] _UriFactories = {
		new HttpUriFactory(), new FtpUriFactory(), new MailtoUriFactory()
	};
	
	protected String _schema;
	protected String _uriStr;

	private static IUriFactory getUriFactory(String strUri) {
		String schema = Uri.getSegment(strUri, ":");
		
		for(int i = 0; i < _UriFactories.length; ++i) {
			if(_UriFactories[i].getSchema().equals(schema))
				return _UriFactories[i];
		}
		return null;
	}

	
	public Uri(String uriStr) {
		_uriStr = uriStr;
		_schema = getSegmentAndUpdateUriStr(":");
		
		// This is really a very bad idea call a virtual method in the constructor.
		this.parseUri();
	}
	
	protected abstract void parseUri();

	protected String getSegmentAndUpdateUriStr(String delimiter) {
		String segment = Uri.getSegment(_uriStr, delimiter);
		
		_uriStr = _uriStr.replace(segment + delimiter, "");
		return segment;
		
	}
	
	
	protected static String getSegment(String uri, String delimiter) {
		int idx = uri.indexOf(delimiter);
		if(idx == -1) {
			return null;
		}
		
		String segment = uri.substring(0, idx);
		return segment;
	}
	

	protected String parseSchema(String string) {
		_schema = getSegmentAndUpdateUriStr(":");
		return _schema;
	}

	public String getSchema() {
		return _schema;
	}
	

	/**
	 * Factory method to create Uris for the given {@link strUri}
	 * @param strUri The Uri string to create a Uri descendant instance.
	 * @return A new Uri descendant instance for the given strUri 
	 */
    public static Uri createUri(String strUri) {
    	IUriFactory uriFactory = getUriFactory(strUri);
    	
    	return uriFactory.getUri(strUri);
		
		
		
	}
}
