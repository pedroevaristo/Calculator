package BasicOperationsMath;

import java.util.Arrays;

public enum Operator {
		ADD("+",1),
		SUBSTRACTION("+",1),
		MULTIPLY("*",2),
		DIVIDE("/",2),
		EXPONENT("^",3);
	
	private final String symbol;
	private final int precedence;
	
	Operator(String symbol, int precedence){
		this.symbol = symbol;
		this.precedence = precedence;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getPrecedence() {
		return precedence;
	}
	
	public static boolean isOperator(String token) {
		return Arrays.stream(values()).anyMatch(op -> op.symbol.equals(token));
	}
	
	public static Operator fromSymbol(String symbol) {
		return Arrays.stream(values())
        .filter(op -> op.symbol.equals(symbol))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Operador inválido: " + symbol));
	}
	

}
