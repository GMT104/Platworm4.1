package worms.model;

import worms.model.Worm;

public class InequalityExpression extends BinaryExpression {

	public InequalityExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDoubleType.notEqualTo((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}
}
