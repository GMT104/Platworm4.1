package worms.model.programs.parser;

public abstract class UnaryExpression extends Expression {

	private Expression expression;



	public UnaryExpression(Expression e) {
		this.setExpression(e); 
	}
	
	
	
	@Override
	public abstract Object getValue();



	public Expression getExpression() {
		return expression;
	}



	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
