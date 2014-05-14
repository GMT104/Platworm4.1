package worms.model.programs.parser;

import java.util.HashSet;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public abstract class ActionStatement extends Statement {

	@Override
	public abstract void execute(Worm activeWorm, IActionHandler handler);

	
	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}
}
