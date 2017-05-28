package kr.co.library.exception;

/**
 * 패널티가 없는 경우
 */
public class PenaltyNotException extends Exception
{
	public PenaltyNotException(){}
	public PenaltyNotException(String message)
	{
		super(message);
	}
}
