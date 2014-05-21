package worms.model;

import worms.model.Worm;

public class DoubleDivisionExpression extends BinaryExpression<MyDouble> {

	public DoubleDivisionExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.divide((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
