package poo.uri;

public class Uri {

	protected String _schema;
	protected String _uriStr;

	public Uri(String uriStr) {
		_uriStr = uriStr;
	}

	protected String getSegment(String delimiter) {
		int idx = _uriStr.indexOf(delimiter);
		if(idx == -1) {
			return null;
		}
		
		String segment = _uriStr.substring(0, idx);
		_uriStr = _uriStr.substring(idx + delimiter.length());
		return segment;
		
	}

	protected String parseSchema(String string) {
		_schema = getSegment(":");
		return _schema;
	}

	public String getSchema() {
		return _schema;
	}

}
