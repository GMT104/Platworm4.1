package worms.model.programs.parser;

public class BooleanLiteralExpression extends Expression {

	private MyBoolean value;
	
	public BooleanLiteralExpression(boolean b) {
		value = new MyBoolean(b);
	}
	
	@Override
	public MyObject getValue() {
		return value;
	}

}
