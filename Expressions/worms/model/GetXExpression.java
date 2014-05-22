package worms.model;

import java.util.Map;

import worms.model.Worm;
import worms.model.GameObject;

public class GetXExpression extends UnaryExpression<MyDouble> {

	public GetXExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((GameObject) ((Entity) this.getExpression().getValue(activeWorm)).getValue()).getCoordinateX();
		return new MyDouble(value);
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDouble.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return Entity.class;
	}

}
