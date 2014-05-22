package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Food;
import worms.model.GameObject;
import worms.model.Worm;
import worms.model.programs.ProgramFactory.ForeachType;


public  class ForEachStatement extends StatementWithBody{	
	
		private ForeachType type;
		private String variableName;
		
		public ForEachStatement(ForeachType type,
				String variableName, Statement body) {
			super(body);
			this.variableName = variableName;
			this.type = type;
		}
		
		public void execute(Worm activeWorm,IActionHandler handler) {
			if (this.type == ForeachType.WORM)
				for(Worm worm: activeWorm.getWorld().getAllWorms()){
					activeWorm.getProgram().changeVariable(variableName, new Entity(worm));
					getBodyStatement().run(activeWorm, handler);
				}
			else if (this.type == ForeachType.FOOD)
				for(Food food: activeWorm.getWorld().getAllFood()){
					activeWorm.getProgram().changeVariable(variableName, new Entity(food));
					getBodyStatement().run(activeWorm, handler);
				}
			else
				for(GameObject gameObject: activeWorm.getWorld().getGameObjectsClone()){
					activeWorm.getProgram().changeVariable(variableName, new Entity(gameObject));
					getBodyStatement().run(activeWorm, handler);
				}
			activeWorm.getProgram().removeVariable(variableName);
			this.setHasBeenRunAlready(true);
		}

		
		@Override
		public boolean hasExpressionAsInputToCheck() {
			return false;
		}

		@Override
		public Class<? extends Type> getInputType(Map<String, Type> globals) {
			return null;
		}

		@Override
		public Expression<? extends Type> getInputExpression() {
			return null;
		}
		
}