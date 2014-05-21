package worms.model;

import worms.model.Worm;

public class GetSameTeamExpression extends BooleanUnaryExpression {

	public GetSameTeamExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		boolean value;
		if ((activeWorm.getTeam() == null) || (((Worm) this.getExpression().getValue(activeWorm).getValue()).getTeam() == null))
			value = false;
		else 
			value = (activeWorm.getTeam() == ((Worm) this.getExpression().getValue(activeWorm).getValue()).getTeam());
		return new MyBoolean(value);
	}


}
