package worms.model.programs.parser;

public class MyBoolean extends MyObject {
	
	private boolean value;
	
	public MyBoolean(boolean b) {
		value = b;
	}
	
	@Override
	public Object value() {
		//TODO moet boolean returnen
		return value;
	}

}
