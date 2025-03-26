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

	public void run() throws Exception {
		try (Scanner scan = new Scanner(System.in)) {
			String loopDoWhile;
			do {
				expressionPostFix = getExpressionNummbersFromUser(scan);
				
			
				askForHistoricOperationOfSession(scan);
				loopDoWhile = askToContinue(scan);
			} while (loopDoWhile.equals("s"));
		}

		System.out.println("Programa encerrado");
	}

	
	private List<Double> getExpressionNummbersFromUser(Scanner scan) { 
		
			System.out.println("Digite um numero: ");
			String input = scan.nextLine();// se possível reeber um x
			while(true) {
				if(!ValidatorFromInput.validatingExpressionMath(input)) {
					System.err.print("Há erros na expressão passada aqui");
				}
			}
			validator.convertMathExpressionInFixToPostFix(input);//2x+5=9

		
		return null;
	}
	private void askForHistoricOperationOfSession(Scanner scan) throws Exception {// colocar os horarios nas operações que foram
																	// armazenados/feitas datetime
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

			} else {
				throw new Exception("Entrada inválida. Digite novamente");
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
