package worms.model;

import worms.model.Worm;

public class DoubleLiteralExpression extends Expression {

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
	public Class<? extends Type> getReturnType() {
		return MyDoubleType.class;
	}


}
