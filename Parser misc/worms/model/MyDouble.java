package worms.model;

public class MyDouble extends MyObject {

	private final double value;
	
	public MyDouble(double value) {
		this.value = value;
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
	
}
