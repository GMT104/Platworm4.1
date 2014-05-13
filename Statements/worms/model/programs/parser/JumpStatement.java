package worms.model.programs.parser;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class JumpStatement extends ActionStatement {

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		handler.jump(activeWorm);
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}


}
