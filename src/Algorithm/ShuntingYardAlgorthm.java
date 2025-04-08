	package Algorithm;
	
	import java.util.Stack;
	import java.util.Map;
	import java.util.HashMap;
	import BasicOperationsMath.MathOperation;
	
	public class ShuntingYardAlgorthm {// aqui vai ter o algoritmo que vai converter e verificar as expressão passad no
										// input
		private final Map<String, MathOperation> operationMap;
		private final Map<Character, Integer> initializeLocalOperationMath;
	
		public ShuntingYardAlgorthm(Map<String, MathOperation> operationMap, Map<Character, Integer> initializeLocalOperationMath) {
			this.operationMap = operationMap;
			this.initializeLocalOperationMath = new HashMap<>();
			
			initializeOperations();
		}
		
		private void initializeOperations() {
			initializeLocalOperationMath.put('+', 1);
			initializeLocalOperationMath.put('-', 1);
			initializeLocalOperationMath.put('*', 2);
			initializeLocalOperationMath.put('/', 2);
			initializeLocalOperationMath.put('^', 3);		
			
		}
		
		private int dictionarySignalMath(char signal) {
			return initializeLocalOperationMath.getOrDefault(signal,-1);
		}
	
		private boolean validatingCharacter(char chr) {
			return Character.isLetterOrDigit(chr) || (dictionarySignalMath(chr) != -1) || chr == '(' || chr == ')' || chr == '=';
		}
	
		public String shuntingYardAlgorithm(String expression) {// 2x+5=9, x^8,
			for(int i =0; i< expression.length(); i++) {
				char character = expression.charAt(i);
				if(!validatingCharacter(character)) {
					throw new IllegalArgumentException("Caracter inválido" + character);				
				}
			}
			
			
			StringBuilder output = new StringBuilder();
			Stack<Character> stack = new Stack();
	
			for (int index = 0; index < expression.length(); index++) {
				char character = expression.charAt(index);
	
				if (Character.isLetterOrDigit(character)) {
	
					output.append(character);
	
				} else if (character == '(') {
	
					stack.add(character);
	
				} else if (character == ')') {
	
					while (!stack.isEmpty() && stack.peek() != '(') {
	
						output.append(stack.pop());
					}
					stack.pop();
	
				} else {
					while (!stack.isEmpty() && dictionarySignalMath(character) <= dictionarySignalMath(stack.peek())) {
						output.append(stack.pop());
					}
					stack.push(character);
				}
				
			}
			while (!stack.isEmpty()) {
				output.append(stack.pop());
			}
			return output.toString();
		}
	
	}
