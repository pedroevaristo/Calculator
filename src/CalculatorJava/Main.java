package CalculatorJava;

import java.util.Scanner;

import BasicOperationsMath.MethodsMathOperations;

public class Main {

	public static void main(String[] args) throws Exception {// aqui é onde vai rodar todos os programas e receber os
																// inputs
		MethodsMathOperations mmo = new MethodsMathOperations();
		Scanner scan = new Scanner(System.in);

		String loopDoWhile;
		System.out.println(
				"Digite seus respectivos valores: x e y, e escoha a operação matematico\nPara sair digite sair\n(+)Sum\n(-)Subtraction\n(*)Multiplication\n(/)Division");

		do {
			System.out.println("Digite o número 1");
			Double number1 = scan.nextDouble();
			System.out.println("Digite o número 2");
			Double number2 = scan.nextDouble();
			System.out.println("Qual é entre: + | - | / | * | ?");
			loopDoWhile = scan.next();

			//scan.nextLine();
			switch (loopDoWhile) {
			case "+":
				System.out.println("O resultado da soma é " +  mmo.Sum(number1, number2));
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
		} while (!loopDoWhile.contentEquals("sair"));
		
		scan.close();
	}

}
