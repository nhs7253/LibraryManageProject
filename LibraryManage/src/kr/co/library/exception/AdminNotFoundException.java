package kr.co.library.exception;

public class AdminNotFoundException extends Exception{
	private String failId;
	
	public AdminNotFoundException(){}
	public AdminNotFoundException(String message){
		super(message);
	}
	public AdminNotFoundException(String message, String failId){
		super(message);
		this.failId = failId;
	}
	public String getFailId(){
		return failId;
	}
}
