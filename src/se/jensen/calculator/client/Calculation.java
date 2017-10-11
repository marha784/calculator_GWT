package se.jensen.calculator.client;

public class Calculation {

	private int number1;
	private String operand;
	private int number2;
	private String result;
	private double double1;
	private double double2;
	private int valueType;

	public Calculation(int number1, String operand, int number2) {

		this.number1 = number1;
		this.operand = operand;
		this.number2 = number2;
		valueType = 1;
	}

	public Calculation(double double1, String operand, double double2) {
		this.double1 = double1;
		this.operand = operand;
		this.double2 = double2;
		valueType = 0;
	}

	public String calculate() {

		if (operand.equals("+")) {
			if (valueType == 1) {
				result = add();
			} else
				result = addDouble();
		} else if (operand.equals("-")) {
			if (valueType == 1) {
				result = subtract();
			} else
				result = subtractDouble();
		} else if (operand.equals("*")) {
			if (valueType == 1) {
				result = multiply();
			} else
				result = multiplyDouble();
		} else if (operand.equals("/")) {
			if (valueType == 1) {
				result = divide();
			} else
				result = divideDouble();
		} else if (operand.equals("%")) {
			if (valueType == 1) {
				result = modulo();
			} else
				result = moduloDouble();
		}

		return result;

	}

	public String add() {
		return result = Integer.toString(number1 + number2);
	}

	public String subtract() {
		return result = Integer.toString(number1 - number2);
	}

	public String multiply() {
		return result = Integer.toString(number1 * number2);
	}

	public String divide() {

		result = Double.toString(((double) number1) / ((double) number2));
		return result;
	}

	public String addDouble() {
		return result = Double.toString(double1 + double2);
	}

	public String subtractDouble() {
		return result = Double.toString(double1 - double2);
	}

	public String multiplyDouble() {
		return result = Double.toString(double1 * double2);
	}

	public String divideDouble() {

		result = Double.toString(double1 / double2);
		return result;
	}

	public String modulo() {
		return result = Double.toString(number1 % number2);
	}

	private String moduloDouble() {
		return result = Double.toString(double1 % double2);
	}

}
