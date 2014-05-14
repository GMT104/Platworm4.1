package worms.model.programs.parser;

import java.util.HashSet;
import java.util.Set;
import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class PrintStatement extends Statement {

	private Expression expression;
	
	public PrintStatement(Expression e) {
		this.expression = e;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
			System.out.println(expression.getValue(activeWorm));
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}

}
