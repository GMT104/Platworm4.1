package worms.model;

import java.util.Map;

import worms.model.Worm;

public class GetSameTeamExpression extends UnaryExpression {

	public GetSameTeamExpression(Expression e) {
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

	@Override
	public Class<? extends Type> getInputType() {
		return EntityType.class;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyBooleanType.class;
	}


}
