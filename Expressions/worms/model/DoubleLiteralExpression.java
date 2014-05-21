package worms.model;

import worms.model.Worm;

public class DoubleLiteralExpression extends Expression<MyDouble> {

	private MyDouble d;

	public DoubleLiteralExpression(double d) {
		this.d = new MyDouble(d);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return this.d;
	}

}
