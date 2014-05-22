package worms.model;

public class MyBoolean extends Type {


	private final boolean value;

	
	public static MyBoolean and(MyBoolean bool1, MyBoolean bool2) {
		boolean bool = bool1.getValue() && bool2.getValue();
		return new MyBoolean(bool);
	}
	
	public static MyBoolean or(MyBoolean bool1, MyBoolean bool2) {
		boolean bool = bool1.getValue() || bool2.getValue();
		return new MyBoolean(bool);
	}
	
	public static MyBoolean not(MyBoolean bool1) {
		boolean bool = ! bool1.getValue();
		return new MyBoolean(bool);
	}

	
	public MyBoolean(boolean b) {
		value = b;
	}
	
	public MyBoolean(){
		value = false;
	}
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}

	@Override
	public MyBoolean createObjectWithDefaultValue() {
		return new MyBoolean();
	}
	
}
