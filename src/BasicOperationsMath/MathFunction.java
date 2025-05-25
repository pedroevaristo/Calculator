package BasicOperationsMath;

import java.util.Arrays;

public enum MathFunction {
SIN("sin"),
COS("cos"),
LOG("log");
	private final String name;
	
	MathFunction(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static boolean isFunction(String token) {
		return Arrays.stream(values())
				.anyMatch(mf -> mf.name.equals(token.toLowerCase()));
	}
	
	public static MathFunction fromName(String name) {
		return Arrays.stream(values())
				.filter(mf -> mf.name.equals(name.toLowerCase()))
				.findFirst()
				.orElseThrow(() ->new IllegalArgumentException("Função inválida " + name));
	}
}
