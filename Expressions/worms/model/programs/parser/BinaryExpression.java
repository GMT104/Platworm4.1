package worms.model.programs.parser;

public abstract class BinaryExpression extends Expression {

	
	private Expression leftExpression;
	private Expression rightExpression;
	
	public BinaryExpression(Expression e1, Expression e2) {
		this.setLeftExpression(e1);
		this.setRightExpression(e2);
	}
		
	@Override
	public abstract Object getValue();

	public Expression getLeftExpression() {
		return leftExpression;
	}

	public void setLeftExpression(Expression leftExpression) {
		this.leftExpression = leftExpression;
	}

	public Expression getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(Expression rightExpression) {
		this.rightExpression = rightExpression;
	}

}
