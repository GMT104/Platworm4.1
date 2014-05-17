package worms.model;

@SuppressWarnings("serial")

public class MaximumAmountOfStatementsException extends RuntimeException {
	public MaximumAmountOfStatementsException(String message) {
		super(message);
	}

	public MaximumAmountOfStatementsException(Throwable cause) {
		super(cause);
	}

	public MaximumAmountOfStatementsException(String message, Throwable cause) {
		super(message, cause);
	}

}
