package poo.uri.factories;

import poo.uri.Uri;
import poo.uri.UriHttp;

public class HttpUriFactory implements IUriFactory {

	@Override
	public String getSchema() {
		return "http";
		
	}
	
	@Override
	public Uri getUri(String uriStr) {
		return new UriHttp(uriStr);
		
	}

}
