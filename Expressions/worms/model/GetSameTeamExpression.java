package worms.model;

import worms.model.Worm;

public class GetSameTeamExpression extends UnaryExpression {

	public GetSameTeamExpression(Expression e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		boolean value;
		try{
			value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getTeam() == activeWorm.getTeam();
		}
		catch (NullPointerException exc){
			// If both teams are null, worms are not in the same team.
			value = false;
		}
		return new MyBoolean(value);
	}

}
