package worms.model;

import java.util.Map;

import worms.model.Worm;

public class EqualityExpression extends BinaryExpression<MyBoolean> {

	public EqualityExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDouble.equalTo((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyBoolean.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyDouble.class;
	}

}
