package CalculatorJava;
import Validator.ValidatorFromInput;

import java.util.Map;

import Algorithm.ShuntingYardAlgorthm;

import java.util.HashMap;
public class Main {
	public static void main(String[]args){
		try {
			//criando as dependecias preciso estudar 
			//Qual é a função da Main ?
			ValidatorFromInput validator = new ValidatorFromInput();
			
			AppCalculator calculator = new AppCalculator(validator);//injentando as dependecias
			calculator.run();

		} catch (Exception e) {
			System.err.println("Error fatal: " + e.getMessage());
			System.exit(1);
		}
	}
}