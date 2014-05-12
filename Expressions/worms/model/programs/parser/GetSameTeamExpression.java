package worms.model.programs.parser;

import worms.model.Worm;

public class GetSameTeamExpression extends UnaryExpression {

	public GetSameTeamExpression(Expression e) {
		super(e);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ((Worm) this.getExpression().getValue(activeWorm)).getTeam()==(activeWorm.getTeam());
	}

}
