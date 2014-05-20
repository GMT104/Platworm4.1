package worms.model;

import java.util.Map;

public class BooleanLiteralExpression extends BooleanExpression {

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
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyBooleanType.class;
	}

}
