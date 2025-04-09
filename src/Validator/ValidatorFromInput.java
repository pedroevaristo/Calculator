package Validator;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Stack;
import BasicOperationsMath.MathOperation;
import BasicOperationsMath.MathUtils;

public class ValidatorFromInput {
	public static boolean validatingExpressionMath(String inputExpression) {
		if (!areParenthesesBalanced(inputExpression)) {
			System.err.println("Error : os parenteses estão desbalanceados. Certifique que '(' tenha o correspondete ')'. ");
			return false;
		}
		if (!ifContainsInvalidCharacter(inputExpression)) {
			System.out.println("Error: a expressão contém caracteres inválidos. Verifique os operadores (+, -, * , / , ^), números , parênteses e  ' = '");
			return false;
		}
		if (!areCorrectUseSignsOnExpression(inputExpression)) {
			// colocar uma mensagem de erro especifico ao metodo
			System.out.println("Error: Erro no posicionamento dos operadores.");
			return false;
		}
		return true;

	}

	private static boolean areParenthesesBalanced(String inputExpression) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : inputExpression.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	private static boolean ifContainsInvalidCharacter(String inputExpression) {
		for (char c :  inputExpression.toCharArray()) {
			if(!Character.isDigit(c) && !MathUtils.VALID_CHARACTERS.contains(c) && !MathUtils.VALID_OPERATORS.contains(c)) {
				return false;			
			}
		}
		return true;
	}

	private static boolean areCorrectUseSignsOnExpression(String inputExpression) {
		for (int i = 0; i < inputExpression.length(); i++) {
			char c = inputExpression.charAt(i);

			if (MathUtils.VALID_OPERATORS.contains(c)) {
				if (i == 0 || i == inputExpression.length() - 1) {
					return false;
				}
			}

			if (i + 1 < inputExpression.length() && MathUtils.VALID_OPERATORS.contains(inputExpression.charAt(i + 1))) {
				return false;
			}
		}
		return true;
	}

}
