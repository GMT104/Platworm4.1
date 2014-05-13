package worms.model.programs.parser;

import java.util.Set;
import java.util.TreeSet;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class WhileStatement extends StatementWithBody {

	private Expression condition;
	
	public WhileStatement(Expression condition, Statement body) {
		super(body);
		this.condition = condition;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		while ((boolean) condition.getValue(activeWorm)){
			getBodyStatement().execute(activeWorm,handler);
		}
	}

	


}
