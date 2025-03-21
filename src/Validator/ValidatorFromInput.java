package Validator;

import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Stack;
import BasicOperationsMath.MathOperation;

public class ValidatorFromInput {
	public static boolean validatingExpressionMath(String inputExpression) {
		if(!areParenthesesBalanced(inputExpression)) {
			System.out.println("Erro na digitação do parenteses");
			return false;
		}
		if() {
			
		}
		
		return false;

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

	private static boolean areCorrectUseSignsOnExpression(String inputExpression) {
		for(int index = 0; index < inputExpression.length(); ) {
			char character = inputExpression.charAt(index);
			
			if(isOperator(character)) {
				if(index == 0 || index == inputExpression.length() - 1) {
					return false;
				}
			}
			if() {
				
			}
		}
		return 
	}
	
	private static boolean isOperator(char character) {
		return character == '+' || character=='-' || character=='*' ||  character=='/';  
	}

}
