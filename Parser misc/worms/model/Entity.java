package worms.model;

public class Entity extends Type {


	private final GameObject value;
	
	
	public Entity(){
		value = null;
	}
	
	
	public Entity(GameObject value) {
		this.value = value;
	}
	
	public GameObject getValue() {
		return value;
	}
	
	@Override
	public Entity createObjectWithDefaultValue() {
		return new Entity();
	}
	
}
