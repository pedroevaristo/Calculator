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
			//criando as instancias
			Map<String, MathOperation> operationsMap = new HashMap<>();
			operationsMap.put("+", new AdditionOperation());
			operationsMap.put("-", new SubstractionOperation());
			operationsMap.put("*", new MultiplicationOperation());
			operationsMap.put("/", new DivisionOperation());
			
			ValidatorFromInput validator = new ValidatorFromInput();
			
			AppCalculator calculator = new AppCalculator(operationsMap, validator);//injentando as intancias
			calculator.run();

		} catch (Exception e) {
			System.err.println("Error fatal: " + e.getMessage());
			System.exit(1);
		}
	}
}