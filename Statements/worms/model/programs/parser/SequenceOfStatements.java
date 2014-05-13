package worms.model.programs.parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class SequenceOfStatements extends Statement {

	private List<Statement> sequenceOfStatements;
	
	public SequenceOfStatements(List<Statement> statements) {
		this.sequenceOfStatements = statements;

	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		for(Statement subStatement: this.sequenceOfStatements){
			subStatement.execute(activeWorm, handler);
		}
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		for(Statement statement: this.sequenceOfStatements){
		for(Statement subStatement: statement.getAllSubstatements()){
			set.add(subStatement);
		}
		}
		return set;
	}

}
