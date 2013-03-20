package poo.uri.factories;

import poo.uri.Uri;

/**
 * Interface for Uri factories
 * 
 * @author lfalcao
 *
 */
public interface IUriFactory {
	/**
	 * The Uri's schema this factory knows to create  
	 * @return The Uri's schema this factory knows to create
	 */
	public String getSchema();
	
	/**
	 * returns a new {@link Uri} descendant for the current scheme. 
	 * @param uriStr
	 * @return
	 */
	public Uri getUri(String uriStr);

}
