package worms.model.programs.parser;

import java.util.*;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public  abstract class Statement {

	
	public abstract void execute(Worm activeWorm,IActionHandler handler );
	
	public abstract Set<Statement> getAllSubstatements();
}
	
