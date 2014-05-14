package worms.model;

public class MyBoolean extends MyObject {
	
	private final boolean value;
	
	public MyBoolean(boolean b) {
		value = b;
	}
	
	public Boolean getValue() {
		return value;
	}

}
