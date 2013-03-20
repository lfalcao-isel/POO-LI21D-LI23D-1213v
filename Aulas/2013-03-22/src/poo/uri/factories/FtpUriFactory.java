package poo.uri.factories;

import poo.uri.Uri;
import poo.uri.UriFtp;

public class FtpUriFactory implements IUriFactory {

	@Override
	public Uri getUri(String uriStr) {
		return new UriFtp(uriStr);
		
	}

	@Override
	public String getSchema() {
		return "ftp";
	}

}
