package worms.model;

import worms.model.Worm;

public class DoubleSinusExpression extends DoubleUnaryExpression {

	public DoubleSinusExpression(DoubleExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.sine((MyDouble) this.getExpression().getValue(activeWorm));
	}


}
