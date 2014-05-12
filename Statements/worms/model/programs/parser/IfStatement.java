package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class IfStatement extends Statement {
	
	private Expression condition;
	private Statement then;
	private Statement otherwise;
	
	
	public IfStatement(Expression condition, Statement then, Statement otherwise) {
		this.condition = condition;
		this.then = then;
		this.otherwise = otherwise;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		if ((boolean) this.condition.getValue(activeWorm))
			this.then.execute(activeWorm, handler);
		else
			this.otherwise.execute(activeWorm, handler);
	}



}
