package Algorithm;

import java.util.Stack;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import BasicOperationsMath.MathOperation;
import BasicOperationsMath.MathUtils;

public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
									// input
	// private final Map<String, MathOperation> operationMap;
	// private final Map<Character, Integer> initializeLocalOperationMath;

	public List<String> shuntingYardAlgorithm(String expression) {// 2x+5=9, x^8,

		Deque<String> operatorsStack = new ArrayDeque<>();
		List<String> outputPostFix= new ArrayList<>();
		
		String[] tokens = expression.split("\\s+");
		for (String token : tokens) {
			if(token.matches("-?\\d+(\\.\\d+)?")) {
							outputPostFix.add(token);	
			}
			else if(MathUtils.VALID_OPERATORS.contains(token.charAt(0))) {
				while(!operatorsStack.isEmpty() &&
						MathUtils.VALID_OPERATORS.contains(operatorsStack.peek().charAt(0)) &&
								MathUtils.PRIORITY.get(Character.valueOf(operatorsStack.peek().charAt(0)))
								>= MathUtils.PRIORITY.get(Character.valueOf(token.charAt(0)))) {
					outputPostFix.add(operatorsStack.pop());
				}
				operatorsStack.push(token);
			}else if(token.equals("(")) {
				operatorsStack.push(token);				
			}else if(token.equals(")")) {
				while(!operatorsStack.isEmpty() && !operatorsStack.peek().equals("(")) {
					outputPostFix.add(operatorsStack.pop());					
				}
				while(!operatorsStack.isEmpty()) {
					outputPostFix.add(operatorsStack.pop());
				}
			}

		}
		return outputPostFix;
	}

}
