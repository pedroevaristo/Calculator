package CalculatorJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Validator.ValidatorFromInput;
import BasicOperationsMath.MethodsMathOperations;

public class Main {

	public static void main(String[] args) throws Exception {// aqui é onde vai rodar todos os programas e receber os
																// inputs
		MethodsMathOperations mmo = new MethodsMathOperations();
		List<String> validatorInput = new ArrayList<String>();
		List<Double> validatorNumbers = new ArrayList<Double>();
		ValidatorFromInput validator = new ValidatorFromInput();
		Scanner scan = new Scanner(System.in);

		String loopDoWhile;
		int loopWhileInput = 2;
		int loopWhile = 0;
		String validacao;

		do {
			System.out.println("Digite seus respectivos valores:");

			while (true) {
				System.out.println("Digite um numero: ");
				String input = scan.nextLine();

				Optional<Double> receiveResult = validator.validatorInput(input);
				if (receiveResult.isPresent()) {
					validatorNumbers.add(receiveResult.get());
					loopWhile++;
					if (loopWhile == 2) {
						break;
					}
				} else {
					System.out.println("Entrada inválida do input " + input + "");
				}
			}
			loopWhile = 0;
			System.out.println("Escoha a operação matematico entre: + | - | / | * | ?");
			loopDoWhile = scan.next();
			scan.nextLine();// foi aqui que mudou, e parou de ter problemas de loop infinito

			// scan.nextLine();
			switch (loopDoWhile) {
			case "+":

				System.out.println("O resultado da soma é " + mmo.Sum(validatorNumbers));

				break;
			case "-":
				System.out.println("O resultado da subtração é " + mmo.Subtraction(validatorNumbers));
				break;
			case "*":
				System.out.println("O resultado da multiplicação é " + mmo.Multiplication(validatorNumbers));
				break;
			case "/":
				System.out.println("O resultado da Divisão é " + mmo.Division(validatorNumbers));
				break;
			}
			while (true) {
				System.out.println("Deseja realizar outra operação ? (s/n): ");

				loopDoWhile = scan.nextLine().trim().toLowerCase();
				if (loopDoWhile.equals("s") || loopDoWhile.equals("n")) {
					break;
				} else {
					System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
				}

			}
			validatorNumbers.clear();
		} while (!loopDoWhile.contentEquals("n"));

		scan.close();
		System.out.println("Programa encerrado.");
	}

}
