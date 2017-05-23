package kr.co.library.exception;

public class UserNotFoundException extends Exception
{
	private String failId;
	public UserNotFoundException(){}
	public UserNotFoundException(String message)
	{
		super(message);
	}
	public UserNotFoundException(String message,String failId)
	{
		super(message);
		this.failId = failId;
	}
	public String getFailId()
	{
		return failId;
	}
}
