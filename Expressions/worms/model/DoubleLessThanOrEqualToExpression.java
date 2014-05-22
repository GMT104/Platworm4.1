package worms.model;

import worms.model.Worm;

public class DoubleLessThanOrEqualToExpression extends BinaryExpression<MyBoolean> {

	public DoubleLessThanOrEqualToExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDouble.lessThanOrEqualTo((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
