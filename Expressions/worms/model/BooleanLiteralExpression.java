package worms.model;

public class BooleanLiteralExpression extends Expression {

	private MyBoolean value;
	
	public BooleanLiteralExpression(boolean b) {
		value = new MyBoolean(b);
	}
	
	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return value;
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType() {
		return MyBooleanType.class;
	}

}
