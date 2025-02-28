package CalculatorJava;

import BasicOperationsMath.MathOperation;
import Validator.ValidatorFromInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class AppCalculator {

	private final Map<String, MathOperation> operationsMap;
	private final ValidatorFromInput validator;
	private final Queue<String> historicOperation = new LinkedList<String>();

	// injetar Dependencias
	public AppCalculator(Map<String, MathOperation> operationsMap, ValidatorFromInput validator) {
		this.operationsMap = operationsMap;
		this.validator = validator;

	}

	public void run() {
		try (Scanner scan = new Scanner(System.in)) {
			String loopDoWhile;
			do {
				List<Double> numbers = getNummbersFromUser(scan);
				String operations = getOperationFromUser(scan);
				performOperations(numbers, operations);
				askForHistoricOfAllOperation(scan);
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
				System.out.println("Operação inválida. Tente Novamente");
			}
		}
		return operation;
	}

	private void performOperations(List<Double> numbers, String operation) {
		MathOperation mathOperation = operationsMap.get(operation);
		if (mathOperation == null) {
			System.out.println("Opção inválida" + operation);
			return;
		}
		double result = mathOperation.calculate(numbers);

		String operationCalculated = numbers.get(0) +" " + operation + " " +numbers.get(1) + " = " + result;

		historicOperation.add(operationCalculated);
		System.out.println("O resultado do calculo é: " + result);

	}

	private void askForHistoricOfAllOperation(Scanner scan) {//colocar os horarios nas operações que foram armazenados/feitas datetime 
		String response;
		while (true) {
			System.out.println("Quer ver o histórico das operações ?");
			response = scan.nextLine().trim().toLowerCase();
			if (response.equals("s")) {
				for (String historic : historicOperation) {
					System.out.println(historic);
				}
				break;
			} else if (response.equals("n")) {
				break;

			}else {
				System.out.println("Entrada inválida. Digite novamente");
			}
		}
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
