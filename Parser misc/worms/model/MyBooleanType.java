package worms.model;

public class MyBooleanType extends Type {

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

	@Override
	public MyBoolean createObjectWithDefaultValue() {
		return new MyBoolean(false);
	}
}
