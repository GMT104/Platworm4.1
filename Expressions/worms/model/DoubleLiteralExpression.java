package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleLiteralExpression extends DoubleExpression {

	private MyDouble d;

	public DoubleLiteralExpression(double d) {
		this.d = new MyDouble(d);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return this.d;
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDoubleType.class;
	}


}
