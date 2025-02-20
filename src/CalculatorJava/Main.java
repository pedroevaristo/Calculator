package CalculatorJava;

public class Main {
	public static void main(String[]args){
		try {
			AppCalculator calculator = new AppCalculator();
			calculator.run();

		} catch (Exception e) {
			System.err.println("Error fatal: " + e.getMessage());
			System.exit(1);
		}
	}
}