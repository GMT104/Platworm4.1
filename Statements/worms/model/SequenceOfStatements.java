package worms.model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
			subStatement.run(activeWorm, handler);
		}
		this.setHasBeenRunAlready(true);
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
	

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return null;
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return false;
	}

	@Override
	public Expression getInputExpression() {
		return null;
	}

}
