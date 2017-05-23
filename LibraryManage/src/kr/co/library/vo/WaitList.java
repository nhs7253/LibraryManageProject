package kr.co.library.vo;

import java.io.Serializable;

public class WaitList implements Serializable
{
	private String bookId;
	private String waitUser;
	private int waitRanking;
	
 	private Book book;
 	private UserManagement userManagement;

 	public WaitList() {}

	public WaitList(String bookId, String waitUser, int waitRanking) {
		super();
		this.bookId = bookId;
		this.waitUser = waitUser;
		this.waitRanking = waitRanking;
	}
	
	public WaitList(String bookId, String waitUser, int waitRanking, Book book, UserManagement userManagement) {
		super();
		this.bookId = bookId;
		this.waitUser = waitUser;
		this.waitRanking = waitRanking;
		this.book = book;
		this.userManagement = userManagement;
	}

	@Override
	public String toString() {
		return "WaitList [bookId=" + bookId + ", waitUser=" + waitUser + ", waitRanking=" + waitRanking + ", book="
				+ book + ", userManagement=" + userManagement + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((userManagement == null) ? 0 : userManagement.hashCode());
		result = prime * result + waitRanking;
		result = prime * result + ((waitUser == null) ? 0 : waitUser.hashCode());
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
		WaitList other = (WaitList) obj;
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
		if (userManagement == null) {
			if (other.userManagement != null)
				return false;
		} else if (!userManagement.equals(other.userManagement))
			return false;
		if (waitRanking != other.waitRanking)
			return false;
		if (waitUser == null) {
			if (other.waitUser != null)
				return false;
		} else if (!waitUser.equals(other.waitUser))
			return false;
		return true;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getWaitUser() {
		return waitUser;
	}

	public void setWaitUser(String waitUser) {
		this.waitUser = waitUser;
	}

	public int getWaitRanking() {
		return waitRanking;
	}

	public void setWaitRanking(int waitRanking) {
		this.waitRanking = waitRanking;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public UserManagement getUserManagement() {
		return userManagement;
	}

	public void setUserManagement(UserManagement userManagement) {
		this.userManagement = userManagement;
	}
 	

 	
}
 
  

