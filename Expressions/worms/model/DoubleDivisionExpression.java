package worms.model;

import worms.model.Worm;

public class DoubleDivisionExpression extends BinaryExpression {

	public DoubleDivisionExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.divide((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}

}
