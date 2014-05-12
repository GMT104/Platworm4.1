package worms.model.programs.parser;

public class NullExpression extends Expression {

	@Override
	public Object getValue(Worm activeWorm) {
		return null;
	}

}
