package kr.co.library.exception;

public class FailReturnException extends Exception{
	
	private String userId;

	public FailReturnException() {
	}

	public FailReturnException(String message) {
		super(message);
	}

	public FailReturnException(String message, String userId) {
		super(message);
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}
