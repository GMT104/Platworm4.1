package worms.model.programs.parser;

import worms.model.Worm;

public class BooleanAndExpression extends BinaryExpression {



	public BooleanAndExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ((Boolean) getLeftExpression().getValue(activeWorm) 
				&& (Boolean) getRightExpression().getValue(activeWorm));
	}

}
