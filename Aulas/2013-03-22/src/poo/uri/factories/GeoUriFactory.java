package poo.uri.factories;

import poo.uri.Uri;
import poo.uri.UriGeo;
import poo.uri.UriMailto;

public class GeoUriFactory implements IUriFactory {

	@Override
	public Uri getUri(String uriStr) {
		return new UriGeo(uriStr);
		
	}

	@Override
	public String getSchema() {
		return "geo";
	}

}
