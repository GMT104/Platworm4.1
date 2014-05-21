package worms.model;

import java.util.*;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public  abstract class Statement {

	private boolean hasBeenRunAlready;

	public void run(Worm activeWorm,IActionHandler handler ){
		if (activeWorm.getProgram().getCounter() >= 1000)
			throw new MaximumAmountOfStatementsException("reached 1000 statements");
		if (activeWorm.getStatus() && !this.hasBeenRunAlready){
			this.execute(activeWorm, handler);
			activeWorm.getProgram().count();
		}
	}
	public abstract void execute(Worm activeWorm,IActionHandler handler );
	
	public abstract Set<Statement> getAllSubstatements();
	
	public void setHasBeenRunAlready(boolean b) {
		this.hasBeenRunAlready = b;
	}

}
	
