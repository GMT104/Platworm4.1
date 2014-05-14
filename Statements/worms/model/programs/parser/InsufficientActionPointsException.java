package worms.model.programs.parser;

@SuppressWarnings("serial")

public class InsufficientActionPointsException extends RuntimeException {
	public InsufficientActionPointsException(String message) {
		super(message);
	}

	public InsufficientActionPointsException(Throwable cause) {
		super(cause);
	}

	public InsufficientActionPointsException(String message, Throwable cause) {
		super(message, cause);
	}

}
