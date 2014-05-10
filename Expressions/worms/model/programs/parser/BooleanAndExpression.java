package worms.model.programs.parser;

public class BooleanAndExpression extends BinaryExpression {



	public BooleanAndExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Boolean getValue() {
		return ((Boolean) getLeftExpression().getValue() && (Boolean) getRightExpression().getValue());
	}

}
