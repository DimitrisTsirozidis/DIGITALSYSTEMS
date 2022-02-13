package exception;

public class NewsAPIException extends Exception{

	public NewsAPIException() {
		super();
		
	}
	public NewsAPIException(String message) {
		super(message);
		
	}
	public NewsAPIException(String message, Throwable couse) {
		super(message,couse);
		
	}
	public NewsAPIException(Throwable couse) {
		super(couse);
		
	}
	protected NewsAPIException(String message, Throwable couse, boolean enableSuppression, boolean writableStackTrace) {
		super(message, couse, enableSuppression, writableStackTrace);
		
	}

	
	
}
