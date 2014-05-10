package worms.model.programs.parser;

public class DoubleCosinusExpression extends UnaryExpression {

	public DoubleCosinusExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue() {
		return Math.cos((Double) getExpression().getValue());
	}

}
