package exception;

public class FailWaitException extends Exception {
	private String userId;

	public FailWaitException() {
	}

	public FailWaitException(String message) {
		super(message);
	}

	public FailWaitException(String message, String userId) {
		super(message);
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

}
