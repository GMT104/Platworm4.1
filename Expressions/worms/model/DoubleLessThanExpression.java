package worms.model;

import worms.model.Worm;

public class DoubleLessThanExpression extends BinaryExpression<MyBoolean> {

	public DoubleLessThanExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDoubleType.lessThan((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
