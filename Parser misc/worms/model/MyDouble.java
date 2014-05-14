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
		return (int) Math.round(value);
	}
	
	@Override
	public String toString() {
		return getValue().toString();
	}
	
}
