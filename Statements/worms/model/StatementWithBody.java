package worms.model;

import java.util.HashSet;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public  abstract class StatementWithBody extends Statement{

	private Statement bodyStatement;
	
	
	public StatementWithBody(Statement body) {
		this.bodyStatement = body;
	}
	
	public abstract void execute(Worm activeWorm,IActionHandler handler );
	public Statement getBodyStatement() {
		return bodyStatement;
	}
	
	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		for(Statement subStatement: getBodyStatement().getAllSubstatements()){
			set.add(subStatement);
		}
		return set;
	}
}