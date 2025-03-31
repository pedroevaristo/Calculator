	package Algorithm;
	
	import java.util.Stack;
	import java.util.Map;
	import java.util.HashMap;
	import BasicOperationsMath.MathOperation;
	
	public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
										// input
		private final Map<String, MathOperation> operationMap;
		private final Map<Character, Integer> initializeOperation;
	
		public ShuntingYardAlgorthm(Map<String, MathOperation> operationMap, Map<Character, Integer> initializeOperation) {
			this.operationMap = operationMap;
			this.initializeOperation = new HashMap<>();
			
			initializeOperations();
		}
		
		private void initializeOperations() {
			initializeOperation.put('+', 1);
			initializeOperation.put('-', 1);
			initializeOperation.put('*', 2);
			initializeOperation.put('/', 2);
			initializeOperation.put('^', 3);
			
			
		}
		
		private int dictionarySignalMath(char signal) {
			return initializeOperation.getOrDefault(signal,-1);
		}
	
		private static boolean validatingCharacter(char chr) {
			return Character.isLetterOrDigit(chr) || (dictionarySignalMath(chr) != -1) || chr == '(' || chr == ')';
		}
	
		public static String shuntingYardAlgorithm(String expression) {// 2x+5=9, x^8,
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
					stack.push(chr);
				}
				
			}
			while (!stack.isEmpty()) {
				output.append(stack.pop());
			}
			return output.toString();
		}
	
	}
