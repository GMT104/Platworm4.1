package worms.model;

import worms.model.Worm;

public class DoubleGreaterThanExpression extends BooleanBinaryExpression {

	public DoubleGreaterThanExpression(DoubleExpression e1, DoubleExpression e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDoubleType.greaterThan((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
