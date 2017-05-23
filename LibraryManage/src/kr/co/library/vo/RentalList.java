package kr.co.library.vo;

import java.util.Date;

public class RentalList {
	private int rentalNo;
	private String userId;
	private String bookId;
	private Date rentalStart;
	private Date rentalEnd;

	private Book book;

	public RentalList() {
		super();
	}
	
	

	public RentalList(int rentalNo, String userId, String bookId, Date rentalStart, Date rentalEnd) {
		super();
		this.rentalNo = rentalNo;
		this.userId = userId;
		this.bookId = bookId;
		this.rentalStart = rentalStart;
		this.rentalEnd = rentalEnd;
	}



	public RentalList(int rentalNo, String userId, String bookId, Date rentalStart, Date rentalEnd, Book book) {
		super();
		this.rentalNo = rentalNo;
		this.userId = userId;
		this.bookId = bookId;
		this.rentalStart = rentalStart;
		this.rentalEnd = rentalEnd;
		this.book = book;
	}

	public int getRentalNo() {
		return rentalNo;
	}

	public void setRentalNo(int rentalNo) {
		this.rentalNo = rentalNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getRentalStart() {
		return rentalStart;
	}

	public void setRentalStart(Date rentalStart) {
		this.rentalStart = rentalStart;
	}

	public Date getRentalEnd() {
		return rentalEnd;
	}

	public void setRentalEnd(Date rentalEnd) {
		this.rentalEnd = rentalEnd;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((rentalEnd == null) ? 0 : rentalEnd.hashCode());
		result = prime * result + rentalNo;
		result = prime * result + ((rentalStart == null) ? 0 : rentalStart.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalList other = (RentalList) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (rentalEnd == null) {
			if (other.rentalEnd != null)
				return false;
		} else if (!rentalEnd.equals(other.rentalEnd))
			return false;
		if (rentalNo != other.rentalNo)
			return false;
		if (rentalStart == null) {
			if (other.rentalStart != null)
				return false;
		} else if (!rentalStart.equals(other.rentalStart))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RentalList [rentalNo=" + rentalNo + ", userId=" + userId + ", bookId=" + bookId + ", rentalStart="
				+ rentalStart + ", rentalEnd=" + rentalEnd + ", book=" + book + "]";
	}
	
	

}