package Validator;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Stack;

public class ValidatorFromInput {
	private static int dictionarySignalMath(char signal) {
		switch (signal) {

		case '+':
			return;
		case '-':
			return;
		case '*':
			return;
		case '/':
			return;
		case '^':
			return;
		default:
			return -1;
		}
	}

	private static boolean isSignal(char chr) {
		return chr == '+' || chr == '-' || chr == '*' || chr == '/' || chr == '^';
	}

	private static boolean validatingCharacter(char chr) {
		return Character.isLetterOrDigit(chr) || (dictionarySignalMath(chr) != -1) || chr == '(' || chr == ')';
	}

	public static String convertMathExpressionInFixToPostFix(String expression) {// 2x+5=9
		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack();

		for (int index = 0; index < expression.length(); index++) {
			char chr = expression.charAt(index);

			if (!validatingCharacter(chr)) {
					throw new IllegalArgumentException("Expressão inválida: caractere "+expression);
			}
			if(Character.isLetterOrDigit(chr)) {
				output.append(chr);
			}
		}
		return null;
	}

	private boolean validatorExpressionPostFix() {

	}

}
