package worms.model;

public class MyDoubleType extends Type {
	
	public static MyDouble add(MyDouble double1, MyDouble double2) {
		double value = double1.getValue() + double2.getValue();
		return new MyDouble(value);
	}

	public static MyDouble substract(MyDouble double1, MyDouble double2) {
		double value = double1.getValue() - double2.getValue();
		return new MyDouble(value);
	}
	
	public static MyDouble multiply(MyDouble double1, MyDouble double2) {
		double value = double1.getValue() * double2.getValue();
		return new MyDouble(value);
	}
	
	public static MyDouble divide(MyDouble double1, MyDouble double2) {
		double value = double1.getValue() / double2.getValue();
		return new MyDouble(value);
	}
	
	public static MyBoolean equalTo(MyDouble double1, MyDouble double2) {
		boolean value = (double1.getValue() == double2.getValue());
		return new MyBoolean(value);
	}
	
	public static MyBoolean notEqualTo(MyDouble double1, MyDouble double2) {
		return MyBooleanType.not(MyDoubleType.equalTo(double1, double2));
	}
	
	public static MyBoolean greaterThan(MyDouble double1, MyDouble double2) {
		boolean value = (double1.getValue() > double2.getValue());
		return new MyBoolean(value);
	}
	
	public static MyBoolean lessThan(MyDouble double1, MyDouble double2) {
		boolean value = (double1.getValue() < double2.getValue());
		return new MyBoolean(value);
	}
	
	public static MyBoolean greaterThanOrEqualTo(MyDouble double1, MyDouble double2) {
		return MyBooleanType.or(MyDoubleType.greaterThan(double1, double2),MyDoubleType.equalTo(double1, double2));
	}
	
	public static MyBoolean lessThanOrEqualTo(MyDouble double1, MyDouble double2) {
		return MyBooleanType.or(MyDoubleType.lessThan(double1, double2),MyDoubleType.equalTo(double1, double2));
	}
}
