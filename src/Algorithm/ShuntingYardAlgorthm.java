package Algorithm;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import BasicOperationsMath.MathOperation;
import BasicOperationsMath.MathUtils;

public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
									// input
	private final Map<String, MathOperation> operationMap;
	private final Map<Character, Integer> initializeLocalOperationMath;


	public String shuntingYardAlgorithm(String expression) {// 2x+5=9, x^8,
		

		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<>();


}
