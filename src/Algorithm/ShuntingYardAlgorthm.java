package Algorithm;

import java.util.Stack;
import java.util.Map;
import BasicOperationsMath.MathOperation;

public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
									// input
	private final Map<String, MathOperation> operationMap;

	public ShuntingYard( Map<String, MathOperation> operationMap) {
		this.operationMap = operationMap;
	}

	private static int dictionarySignalMath(char signal) {
		switch (signal) {
		// como enviar para lá as expressões e numeros e operandos
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}

	private static boolean validatingCharacter(char chr) {
		return Character.isLetterOrDigit(chr) || (dictionarySignalMath(chr) != -1) || chr == '(' || chr == ')';
	}

	public static String convertMathExpressionInFixToPostFix(String expression) {// 2x+5=9, x^8,
		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack();

		for (int index = 0; index < expression.length(); index++) {
			char chr = expression.charAt(index);

			if (Character.isLetterOrDigit(chr)) {

				output.append(chr);

			} else if (chr == '(') {

				stack.add(chr);

			} else if (chr == ')') {

				while (!stack.isEmpty() && stack.peek() != '(') {

					output.append(stack.pop());
				}
				stack.pop();

			} else {
				while (!stack.isEmpty() && dictionarySignalMath(chr) <= dictionarySignalMath(stack.peek())) {
					output.append(stack.pop());
				}
			}
			stack.push(chr);
		}
		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}
		return output.toString();
	}

}
