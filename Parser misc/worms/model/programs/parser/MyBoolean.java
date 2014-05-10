package worms.model.programs.parser;

public class MyBoolean extends MyObject {
	
	private boolean value;
	
	public MyBoolean(boolean b) {
		value = b;
	}
	
	@Override
	public boolean value() {
		return value;
	}

}
