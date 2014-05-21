package worms.model;

import worms.model.Worm;

public class DoubleMultiplyExpression extends BinaryExpression<MyDouble> {

	public DoubleMultiplyExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.multiply((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}

}
