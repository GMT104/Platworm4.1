package worms.model;

import worms.model.Worm;

public class GetSameTeamExpression extends UnaryExpression<MyBoolean> {

	public GetSameTeamExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		boolean value;
		if ((activeWorm.getTeam() == null) || (((Worm) ((Entity) this.getExpression().getValue(activeWorm)).getValue()).getTeam() == null))
			value = false;
		else 
			value = (activeWorm.getTeam() == ((Worm) ((Entity) this.getExpression().getValue(activeWorm)).getValue()).getTeam());
		return new MyBoolean(value);
	}


}
