package worms.model.programs.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class TurnStatement extends ActionStatement {

	private Expression angle;
	
	public TurnStatement(Expression angle) {
		this.angle = angle;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		handler.turn(activeWorm, (double) angle.getValue(activeWorm));
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}


}
