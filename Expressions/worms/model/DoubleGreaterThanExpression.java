package worms.model;

import worms.model.Worm;

public class DoubleGreaterThanExpression extends BinaryExpression<MyBoolean> {

	public DoubleGreaterThanExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDouble.greaterThan((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
