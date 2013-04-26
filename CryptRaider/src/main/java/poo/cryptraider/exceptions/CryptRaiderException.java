package poo.cryptraider.exceptions;

public class CryptRaiderException extends Exception {
	public CryptRaiderException() {
	}
	
	public CryptRaiderException(String str) {
		super(str);
		
	}
	
	public CryptRaiderException(String str, Throwable cause) {
		super(str, cause);
		
	}
	
	public CryptRaiderException(Throwable cause) {
		super(cause);
		
	}

}
