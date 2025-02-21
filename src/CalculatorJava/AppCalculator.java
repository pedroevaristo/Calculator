package CalculatorJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import BasicOperationsMath.MethodsMathOperations;
import Validator.ValidatorFromInput;

public class AppCalculator {//é uma forma interessante de fazer. Do que em comparado o que eu imaginava que teria que ser
	private final MethodsMathOperations mathOperations;
	private final ValidatorFromInput validator;

	public AppCalculator() {
		this.mathOperations = new MethodsMathOperations();
		this.validator = new ValidatorFromInput();
	}

	public void run() {
		try (Scanner scan = new Scanner(System.in)) {
			String loopDoWhile;
			do {
				List<Double> numbers = getNummbersFromUser(scan);
				String operations = getOperationFromUser(scan);
				performOperations(numbers, operations);
				
				loopDoWhile = askToContinue(scan);
			} while (loopDoWhile.equals("s"));
		}
		System.out.println("Programa encerrado");
	}

	private List<Double> getNummbersFromUser(Scanner scan) { /* Saber a diferença entre Optional e List em metodos */
		List<Double> numbers = new ArrayList<Double>();
		int count = 0;

		while (count < 2) {
			System.out.println("Digite um numero: ");
			String input = scan.nextLine();

			Optional<Double> number = validator.validatorInput(input);

			if (number.isPresent()) {
				numbers.add(number.get());
				count++;
			} else {
				System.out.println("Entrada inválida do input " + input + "");
			}
		}
		return numbers;
	}

	private String getOperationFromUser(Scanner scan) {
		String operation;
		while (true) {
			System.out.println("Escoha a operação matematico entre: + | - | / | * | ?");
			operation = scan.nextLine().trim();

			if (operation.matches("[+\\-*/]")) {
				break;
			} else {
				System.out.println("OPeração inválida. Tente Novamente");
			}
		}
		return operation;
	}
	
	private void performOperations(List<Double> numbers, String operation) {
		double result = 0;
		switch(operation) {
        case "+":
            result = mathOperations.Sum(numbers);
            break;
        case "-":
            result = mathOperations.Subtraction(numbers);
            break;
        case "*":
            result = mathOperations.Multiplication(numbers);
            break;
        case "/":
            result = mathOperations.Division(numbers);
            break;
		}
		System.out.println("O resultado do calculo é: "+ result);
	}
	

	private String askToContinue(Scanner scan) {
		String response;
		while (true) {
			System.out.println("Deseja continuar outra operação ? (s/n)");
			response = scan.nextLine().trim().toLowerCase();
			if (response.equals("s") || response.equals("n")) {
				break;
			} else {
				System.out.println("Entrada inváida. Digite 's' para sim ou 'n' para não");
			}
		}

		return response;
	}
}
