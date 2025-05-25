package Validator;

import java.util.List;
import java.util.Stack;

public class ValidatorFromInput {
	public static boolean validatingExpressionMath(List<String> tokens) {
		Stack<String> stack = new Stack<>();
		String previousToken = null;
		for (String token : tokens) {
			if (isOperator(token)) {
				if (previousToken == null || isOperator(previousToken)) {
					System.err.println("Erro: posicionamento inválido do operador ");
					return false;

				}
			} else if (token.equals("(")) {
				stack.push(token);
			} else if (token.equals(")")) {
				if (stack.isEmpty()) {
					System.err.println("Erro: Parênteses desbalanceados. ");
					return false;
				}
				stack.pop();
			}
			previousToken = token;
		}
		if (!stack.isEmpty()) {
			System.err.println("Erro: Parênteses desbalanceados ");
			return false;
		}
		return true;
	}

	private static boolean isOperator(String token) {
		return "+-*/^".contains(token);
	}
}
