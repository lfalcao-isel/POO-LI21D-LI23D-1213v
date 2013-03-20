package poo.uri.factories;

import poo.uri.Uri;
import poo.uri.UriMailto;

public class MailtoUriFactory implements IUriFactory {

	@Override
	public Uri getUri(String uriStr) {
		return new UriMailto(uriStr);
		
	}

	@Override
	public String getSchema() {
		return "mailto";
	}

}
