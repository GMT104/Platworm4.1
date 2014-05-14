package worms.model;

import java.util.*;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public  abstract class Statement {

	public void run(Worm activeWorm,IActionHandler handler ){
		if (activeWorm.getStatus())
			this.execute(activeWorm, handler);
	}
	public abstract void execute(Worm activeWorm,IActionHandler handler );
	
	public abstract Set<Statement> getAllSubstatements();
}
	
