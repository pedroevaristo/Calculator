package CalculatorJava;
import BasicOperationsMath.AdditionOperation;
import BasicOperationsMath.DivisionOperation;
import BasicOperationsMath.MathOperation;
import BasicOperationsMath.MultiplicationOperation;
import BasicOperationsMath.SubstractionOperation;
import Validator.ValidatorFromInput;

import java.util.Map;
import java.util.HashMap;
public class Main {
	public static void main(String[]args){
		try {
			//criando as dependecias preciso estudar 
			//Qual é a função da Main ?
			Map<String, MathOperation> operationsMap = new HashMap<>();
			operationsMap.put("+", new AdditionOperation());//Pattern Strategy
			operationsMap.put("-", new SubstractionOperation());//Pattern Strategy
			operationsMap.put("*", new MultiplicationOperation());//Pattern Strategy
			operationsMap.put("/", new DivisionOperation());//Pattern Strategy
			
			ValidatorFromInput validator = new ValidatorFromInput();
			
			AppCalculator calculator = new AppCalculator(operationsMap, validator);//injentando as dependecias
			calculator.run();

		} catch (Exception e) {
			System.err.println("Error fatal: " + e.getMessage());
			System.exit(1);
		}
	}
}