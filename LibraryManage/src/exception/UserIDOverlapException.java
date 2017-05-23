package exception;

public class UserIDOverlapException extends Exception{
public UserIDOverlapException(){}
public UserIDOverlapException(String message){
	super(message);
}
}
