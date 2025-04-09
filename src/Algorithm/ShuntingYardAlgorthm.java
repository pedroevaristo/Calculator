package Algorithm;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import BasicOperationsMath.MathOperation;

public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
									// input
	private final Map<String, MathOperation> operationMap;


	public ShuntingYardAlgorthm(Map<String, MathOperation> operationMap) {
			this.operationMap = operationMap;
	}

	private boolean validatingCharacter(char chr) {
		return Character.isLetterOrDigit(chr) 
				|| (dictionarySignalMath(chr) != -1) 
				|| chr == '('
				|| chr == ')'
				|| chr == '=';
	}

	public String shuntingYardAlgorithm(String expression) {// 2x+5=9, x^8,
		for (int i = 0; i < expression.length(); i++) {
			char character = expression.charAt(i);
			if (!validatingCharacter(character)) {
				throw new IllegalArgumentException("Caracter inválido" + character);
			}
		}

		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);

			if (Character.isLetterOrDigit(character)) {

				output.append(character).append(' ');

			} else if (character == '(') {

				stack.add(character);

			} else if (character == ')') {

				while (!stack.isEmpty() && stack.peek() != '(') {

					output.append(stack.pop());
				}
				stack.pop();

			} else {
				if (dictionarySignalMath(character) == -1) {
					throw new IllegalArgumentException("Operador não suportado : " + character);
				}
				while (!stack.isEmpty() && dictionarySignalMath(character) <= dictionarySignalMath(stack.peek())) {
					output.append(stack.pop());
				}
				stack.push(character);
			}

		}
		while (!stack.isEmpty()) {
			output.append(stack.pop()).append(' ');
		}
		return output.toString().trim();
	}

}
