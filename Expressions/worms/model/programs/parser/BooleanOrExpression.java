package worms.model.programs.parser;

public class BooleanOrExpression extends BinaryExpression {



	public BooleanOrExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Boolean getValue() {
		return ((Boolean) getLeftExpression().getValue() || (Boolean) getRightExpression().getValue());
	}

}
