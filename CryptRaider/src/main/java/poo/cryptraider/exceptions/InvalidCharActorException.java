package poo.cryptraider.exceptions;

public class InvalidCharActorException extends CryptRaiderException {
	public InvalidCharActorException() {
	}
	
	public InvalidCharActorException(String str) {
		super(str);
		
	}
	
	public InvalidCharActorException(String str, Throwable cause) {
		super(str, cause);
		
	}
	
	public InvalidCharActorException(Throwable cause) {
		super(cause);
		
	}

}
