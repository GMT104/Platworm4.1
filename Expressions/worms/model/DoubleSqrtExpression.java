package worms.model;

import worms.model.Worm;

public class DoubleSqrtExpression extends UnaryExpression {

	public DoubleSqrtExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.squareRoot((MyDouble) this.getExpression().getValue(activeWorm));
	}

}
