package CalculatorJava;

import java.util.ArrayList;
import java.util.List;
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
		
		String validacao;

		do {
			System.out.println("Digite seus respectivos valores: (ou digite (sair))\n");
			

				System.out.println("Digite um numero: ");
				String input = scan.nextLine();
				
				if(input.equalsIgnoreCase("sair")) {
					System.exit(0);
				}
		
				validatorInput.add(input);
				validator(validatorInput);

			System.out.println("Escoha a operação matematico entre: + | - | / | * | ?");
			loopDoWhile = scan.next();

			// scan.nextLine();
			switch (loopDoWhile) {
			case "+":
				System.out.println("O resultado da soma é " + mmo.Sum(validator, validator));
				break;
			case "-":
				System.out.println("O resultado da subtração é " + mmo.Subtraction(number1, number2));
				break;
			case "*":
				System.out.println("O resultado da multiplicação é " + mmo.Multiplication(number1, number2));
				break;
			case "/":
				System.out.println("O resultado da Divisão é " + mmo.Division(number1, number2));
				break;
			}
			System.out.println("Deseja realizar outra operação ? (s/n): ");
			loopDoWhile = scan.next();
		} while (!loopDoWhile.contentEquals("n"));

		scan.close();
	}

}
