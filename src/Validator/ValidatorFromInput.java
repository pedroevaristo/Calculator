package Validator;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Stack;
import BasicOperationsMath.MathOperation;

public class ValidatorFromInput {
	public static boolean validatingExpressionMath(String inputExpression) {
		if (!areParenthesesBalanced(inputExpression)) {
			System.out.println("Erro na digitação do parenteses");
			return false;
		}
		if (!ifContainsInvalidCharacter(inputExpression)) {
			//colocar uma mensagem de erro especifico ao metodo
			return false;
		}
		if(!areCorrectUseSignsOnExpression(inputExpression)) {
			//colocar uma mensagem de erro especifico ao metodo
			
			return false;
		}
		return true;

	}

	private static boolean areParenthesesBalanced(String inputExpression) {
		Stack<Character> stackToVerifyParentheses = new Stack<>();

		for (int index = 0; index < inputExpression.length(); index++) {
			char character = inputExpression.charAt(index);
			if (character == '(') {
				stackToVerifyParentheses.push(character);
			} else if (character == ')') {
				if (stackToVerifyParentheses.isEmpty() || stackToVerifyParentheses.pop() != '(') {
					return false;
				}
			}
		}
		return stackToVerifyParentheses.isEmpty();
	}

	private static boolean ifContainsInvalidCharacter(String inputExpression) {
		for (int index = 0; index < inputExpression.length(); index++) {
			char character = inputExpression.charAt(index);
			if (!validationIfExistsSignals(character)) {
				return false;
			}
		}
		return true;
	}


	private static boolean areCorrectUseSignsOnExpression(String inputExpression) {
		for (int index = 0; index < inputExpression.length(); index++) {
			char character = inputExpression.charAt(index);

			if (isOperator(character)) {
				if (index == 0 || index == inputExpression.length() - 1) {
					return false;
				}
			}
			char nextCharacter = inputExpression.charAt(index + 1);
			if (isOperator(nextCharacter)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isOperator(char character) {
		return character == '+' || character == '-' || character == '*' || character == '/';
	}
	

	private static boolean validationIfExistsSignals(char character) {
		return Character.isDigit(character) || character == '+' || character == '-' || character == '*'
				|| character == '/' || character == '^' || character == '(' || character == ')';
	}

}
