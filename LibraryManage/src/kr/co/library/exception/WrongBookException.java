package kr.co.library.exception;

public class WrongBookException extends Exception{

	public WrongBookException() {
	}

	public WrongBookException(String message) {
		super(message);
	}

	public WrongBookException(String message, String userId) {
		super(message);
	}

}
