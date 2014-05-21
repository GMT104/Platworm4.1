package worms.model;

public class BooleanLiteralExpression extends BooleanExpression {

	private MyBoolean value;
	
	public BooleanLiteralExpression(boolean b) {
		value = new MyBoolean(b);
	}
	
	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return value;
	}

}
