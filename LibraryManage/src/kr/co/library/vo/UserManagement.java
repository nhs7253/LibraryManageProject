package kr.co.library.vo;

import java.io.Serializable;

public class UserManagement implements Serializable{

	private String userId;
	private String password;
	private String userName;
	private String phoneNum;
	private String email;
	private char penaltyState;
	
	public UserManagement(){}

	public UserManagement(String userId, String password, String userName, String phoneNum, String email,
			char penaltyState) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.penaltyState = penaltyState;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getPenaltyState() {
		return penaltyState;
	}

	public void setPenaltyState(char penaltyState) {
		this.penaltyState = penaltyState;
	}

	@Override
	public String toString() {
		return "UserManagement [userId=" + userId + ", password=" + password + ", userName=" + userName + ", phoneNum="
				+ phoneNum + ", email=" + email + ", penaltyState=" + penaltyState + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + penaltyState;
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		UserManagement other = (UserManagement) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (penaltyState != other.penaltyState)
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	

}
