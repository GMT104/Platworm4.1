package worms.model.programs.parser;

import java.util.List;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class SequenceOfStatements extends Statement {

	private List<Statement> sequenceOfStatements;
	
	public SequenceOfStatements(List<Statement> statements) {
		this.sequenceOfStatements = statements;

	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		this.sequenceOfStatements.get(0).execute(activeWorm, handler);
		this.sequenceOfStatements.get(1).execute(activeWorm, handler);
	}

}
