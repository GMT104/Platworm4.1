package worms.model;

public class MyDouble extends Type {
	
	private final double value;
	
	public static MyDouble add(MyDouble double1, MyDouble double2) {
		double value = double1.getValue() + double2.getValue();
		return new MyDouble(value);
	}

	public static MyDouble subtract(MyDouble double1, MyDouble double2) {
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
		return MyBoolean.not(MyDouble.equalTo(double1, double2));
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
		return MyBoolean.or(MyDouble.greaterThan(double1, double2),MyDouble.equalTo(double1, double2));
	}
	
	public static MyBoolean lessThanOrEqualTo(MyDouble double1, MyDouble double2) {
		return MyBoolean.or(MyDouble.lessThan(double1, double2),MyDouble.equalTo(double1, double2));
	}
	
	public static MyDouble cosine(MyDouble doub) {
		double value = Math.cos(doub.getValue());
		return new MyDouble(value);
	}
	
	public static MyDouble sine(MyDouble doub) {
		double value = Math.sin(doub.getValue());
		return new MyDouble(value);
	}
	
	public static MyDouble squareRoot(MyDouble doub) {
		double value = Math.sqrt(doub.getValue());
		return new MyDouble(value);
	}
	
	public MyDouble(double value) {
		this.value = value;
	}
	
	public MyDouble(){
		this.value = 0.0;
	}
	
	public Double getValue() {
		return value;
	}

	public int getValueAsInteger() {
		if (Integer.MIN_VALUE < value && value < Integer.MAX_VALUE)
			return (int) Math.round(value);
		else if (value > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else
			return Integer.MIN_VALUE;
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}

	@Override
	public MyDouble createObjectWithDefaultValue() {
		return new MyDouble();
	}
	
}
