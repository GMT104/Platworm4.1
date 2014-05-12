package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Food;
import worms.model.GameObject;
import worms.model.Worm;
import worms.model.programs.ProgramFactory.ForeachType;


public  class ForEachStatement extends Statement{	
	
		private ForeachType type;
		private String variableName;
		private Statement body;
		
		public ForEachStatement(ForeachType type,
				String variableName, Statement body) {
			this.variableName = variableName;
			this.type = type;
			this.body = body;
		}
		
		public void execute(Worm activeWorm,IActionHandler handler) {
			if (this.type == ForeachType.WORM)
				for(Worm worm: getWorld().getAllWorms()){
					activeWorm.getProgram().changeVariable(variableName, worm);
					body.execute(activeWorm, handler);
				}
			else if (this.type == ForeachType.FOOD)
				for(Food food: getWorld().getAllFood()){
					activeWorm.getProgram().changeVariable(variableName, food);
					body.execute(activeWorm, handler);
				}
			else
				for(GameObject gameObject: getWorld().getGameObjects()){
					activeWorm.getProgram().changeVariable(variableName, gameObject);
					body.execute(activeWorm, handler);
				}
			activeWorm.getProgram().removeVariable(variableName);
		}

}