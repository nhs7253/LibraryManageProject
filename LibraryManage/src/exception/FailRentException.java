package exception;

public class FailRentException extends Exception {
	private String userId;
	private String bookId;

	public FailRentException() {
	}

	public FailRentException(String message) {
		super(message);
	}

	public FailRentException(String message, String userId, String bookId) {
		super(message);
		this.userId = userId;
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public String getBookId() {
		return bookId;
	}
}
