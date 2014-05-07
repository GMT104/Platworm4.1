package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Food;
import worms.model.GameObject;
import worms.model.Worm;
import worms.model.programs.ProgramFactory.ForeachType;

//Ik dacht zo met anonymous classes te werken voor alle gevallen van statements, geen idee of dat werkt of wenselijk is
	// Ik heb dit geschreven als voorbeeld zodat je begrijpt wat ik bedoel.
public  class ForEachStatement extends Statement{	
		private ForeachType type;
		public ForEachStatement(
				worms.model.programs.ProgramFactory.ForeachType type2,
				String variableName, Statement body) {
			// TODO Auto-generated constructor stub
		}
		public void execute(Worm activeWorm,IActionHandler handler) {
			if (this.type == ForeachType.WORM)
				for(Worm worm: getWorld().getAllWorms()){
					//TODO assign worm to the given name 
					for(Statement subStatement: getSubStatements()){
						subStatement.execute(worm, handler);
					}
				}
			else if (this.type == ForeachType.FOOD)
				for(Food food: getWorld().getAllFood()){
					//TODO assign food to the given name
					for(Statement subStatement: getSubStatements()){
						subStatement.execute(activeWorm, handler);
					}
				}
			else
				for(GameObject gameObject: getWorld().getGameObjects()){
					//TODO assign gameObject to the given name
					for(Statement subStatement: getSubStatements()){
						subStatement.execute(activeWorm, handler);
					}
				}
			
		}

}