package worms.model;

public class Entity extends MyObject {

	private final GameObject value;
	
	public Entity(GameObject value) {
		this.value = value;
	}
	
	public GameObject getValue() {
		return value;
	}
	
}
