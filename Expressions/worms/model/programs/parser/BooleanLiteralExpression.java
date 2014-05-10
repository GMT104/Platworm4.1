package worms.model.programs.parser;

public class BooleanLiteralExpression extends Expression {

	private Boolean value;
	
	public BooleanLiteralExpression(boolean b) {
		value = b;
	}
	
	@Override
	public Boolean getValue() {
		return value;
	}

}
