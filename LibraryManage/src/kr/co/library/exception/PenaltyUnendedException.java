package kr.co.library.exception;

/**
 * 패널티가 아직 끝나지 않은 경우
 */
public class PenaltyUnendedException extends Exception
{
	public PenaltyUnendedException(){}
	public PenaltyUnendedException(String message)
	{
		super(message);
	}
}
