package com.exempel.martin.client;
import java.util.ArrayList;
import java.util.Collections;

public class CalculationHandler{

	private ArrayList<String> numbers;
	private ArrayList<String> operands;

	public CalculationHandler(ArrayList<String> numbers, ArrayList<String> operands) {
		this.numbers = numbers;
		this.operands = operands;

	}

	public String sortAndCalculate() {

		int i = 0;
		String string = "";

		for (String value : operands) {
			String answer = "";
			if (value.equals("/")) {
				System.out.println(i);
				String first = numbers.get(i);
				String second = numbers.get(i + 1);
				Calculation calculation = new Calculation(
						Double.parseDouble(first), value,
						Double.parseDouble(second));
				
				answer = calculation.calculate();
				numbers.remove(first);
				numbers.remove(second);
				numbers.add(i, answer);
				i = i - 1;
			}
			i++;
		}
		removeObject(operands, "/");

		i = 0;
		System.out.println();
		for (String value : operands) {
			String answer = "";
			if (value.equals("*")) {
				String first = numbers.get(i);
				String second = numbers.get(i + 1);
				Calculation calculation = new Calculation(
						Double.parseDouble(first), value,
						Double.parseDouble(second));
				answer = calculation.calculate();
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, answer);
				i = i - 1;
			}
			i++;
		}
		removeObject(operands, "*");

		i = 0;
		for (String value : operands) {
			String answer = "";
			if (value.equals("-")) {
				String first = numbers.get(i);
				String second = numbers.get(i + 1);
				Calculation calculation = new Calculation(
						Double.parseDouble(first), value,
						Double.parseDouble(second));
				answer = calculation.calculate();
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, answer);
				i = i - 1;
			}
			i++;
		}
		removeObject(operands, "-");
		System.out.println(operands);
		i = 0;
		for (String value : operands) {
			String answer = "";
			if (value.equals("+")) {
				String first = numbers.get(i);
				String second = numbers.get(i + 1);
				Calculation calculation = new Calculation(
						Double.parseDouble(first), value,
						Double.parseDouble(second));
				answer = calculation.calculate();
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, answer);
				i = i - 1;
			}
			i++;
		}
		removeObject(operands, "+");

		i = 0;
		for (String value : operands) {
			String answer = "";
			if (value.equals("%")) {
				String first = numbers.get(i);
				System.out.println(first);
				String second = numbers.get(i + 1);
				Calculation calculation = new Calculation(
						Double.parseDouble(first), value,
						Double.parseDouble(second));
				answer = calculation.calculate();
				System.out.println(answer);
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, answer);
				i = i - 1;
			}
			i++;
		}
		removeObject(operands, "%");

		if (numbers.get(0).equals("Infinity") || numbers.get(0).equals("-Infinity")) {
			numbers.set(0, "FEL");
		}
		return numbers.get(0);
	}

	public String createString() {
		String string = "";
		ArrayList<String> stringList = new ArrayList<String>();

		for (int i = 0; i < operands.size(); i++) {
			String one = numbers.get(i);
			String two = operands.get(i);
			string += one + two;
		}
		string += numbers.get(numbers.size() - 1) + "=";
		return string;
	}

	public String getEquationResult() {
		String string = "";
		String equ =createString();
		equ += sortAndCalculate();
		return equ;
	}

	public static void main(String[] args) {
		ArrayList<String> numberList = new ArrayList<String>();
		ArrayList<String> operandList = new ArrayList<String>();

		numberList.add("40");
		operandList.add("/");
		numberList.add("0");
		operandList.add("+");
		numberList.add("5");
		
		
		CalculationHandler sort = new CalculationHandler(numberList, operandList);
		System.out.println(sort.getEquationResult());
		System.out.println(sort.sortAndCalculate());

	}

	public void removeObject(ArrayList<String> list, String obj) {

		list.removeAll(Collections.singleton(obj));

	}

	public ArrayList<String> getNumbers() {
		return numbers;
	}

	public ArrayList<String> getOperands() {
		return operands;
	}
}
