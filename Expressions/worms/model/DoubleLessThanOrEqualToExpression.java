package worms.model;

import worms.model.Worm;

public class DoubleLessThanOrEqualToExpression extends BooleanBinaryExpression {

	public DoubleLessThanOrEqualToExpression(DoubleExpression e1, DoubleExpression e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDoubleType.lessThanOrEqualTo((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
