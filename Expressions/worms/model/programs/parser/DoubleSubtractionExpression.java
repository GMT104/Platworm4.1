package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleSubtractionExpression extends BinaryExpression {

	public DoubleSubtractionExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public MyObject getValue(Worm activeWorm) {
		// TODO Auto-generated method stub
		return null;
	}

}
