package worms.model;

import worms.model.Worm;

public class EqualityExpression extends BinaryExpression<MyBoolean> {

	public EqualityExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDoubleType.equalTo((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
