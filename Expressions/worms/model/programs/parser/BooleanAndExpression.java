package worms.model.programs.parser;

public class BooleanAndExpression extends Expression {

	
	private Expression leftExpression;
	private Expression rightExpression;
	
	public BooleanAndExpression(Expression e1, Expression e2) {
		this.leftExpression = e1;
		this.rightExpression = e2;
	}

	@Override
	public boolean getValue() {
		return this.leftExpression.getValue() && this.rightExpression.getValue();
	}

}
