package Algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;


import BasicOperationsMath.Operator;
import BasicOperationsMath.MathFunction;


public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
									// input
	// private final Map<String, MathOperation> operationMap;
	// private final Map<Character, Integer> initializeLocalOperationMath;

	public static List<String> AlgorithmShuntingYard(List<String> tokens) {
		Deque<String> stack = new ArrayDeque<String>();
		List<String> output = new ArrayList<>();

		for (String token : tokens) {
			if (isNumber(token)) {
				output.add(token);
			} else if (isFunction(token)) {
				stack.push(token);
			} else if (isOperator(token)) {
				while (!stack.isEmpty() && isOperator(stack.peek()) && precedence(stack.peek()) >= precedence(token)) {
					output.add(stack.pop());
				}
				stack.push(token);
			} else if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					output.add(stack.pop());

				}
				if (stack.isEmpty())
					throw new RuntimeException("Parênteses desabalanceados");
				stack.pop();
				if (!stack.isEmpty() && isFunction(stack.peek())) {
					output.add(stack.pop());
				}

			}
		}

		return output;// 2x+5=9, x^8,
	}

	private static boolean isNumber(String token) {
		try {
			Double.parseDouble(token);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
	private static boolean isOperator(String token) {
		return Operator.isOperator(token);
	}
	private static int precedence( String getSymbolMath) {
		return Operator.fromSymbol(getSymbolMath).getPrecedence();
		
	}
	private static boolean isFunction(String functionMath) {
		return MathFunction.isFunction(functionMath);
		
	}
	
/*
private static boolean isFunction(String token) {
		return Arrays.asList("sin", "cos", "log").contains(token);
	}

	private static boolean isOperator(String token) {
		return "".contains(token);
	}

	private static int precedence(String operator) {
		switch (operator) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		default:
			return 0;
		}
	}
	*/

}
