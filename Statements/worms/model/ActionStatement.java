package worms.model;

import java.util.HashSet;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public abstract class ActionStatement extends Statement {

	@Override
	public void execute(Worm activeWorm, IActionHandler handler){
		this.act(activeWorm, handler);
		this.setHasBeenRunAlready(true);
		
	}
	
	public abstract void act(Worm activeWorm, IActionHandler handler);

	
	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}
}
