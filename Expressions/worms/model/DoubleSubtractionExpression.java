package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleSubtractionExpression extends BinaryExpression<MyDouble> {

	public DoubleSubtractionExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDouble.subtract((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}
	

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDouble.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyDouble.class;
	}

}
