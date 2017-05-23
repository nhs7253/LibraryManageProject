package exception;

public class BookNotFoundException extends Exception {
	private String bookId;

	public BookNotFoundException() {
	}

	public BookNotFoundException(String message) {
		super(message);
	}

	public BookNotFoundException(String message, String bookId) {
		super(message);
		this.bookId = bookId;
	}

	public String getbookId() {
		return bookId;
	}

}
