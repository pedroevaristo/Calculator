package BasicOperationsMath;

public class MethodsMathOperations extends OperationsMath {
	
	@Override
	public Double Sum(Double x, Double y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public Double Subtraction(Double x, Double y) {
		// TODO Auto-generated method stub
		return x - y;
	}

	@Override
	public Double Multiplication(Double x, Double y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	@Override
	public Double Division(Double x, Double y) {
		// TODO Auto-generated method stub
		if(y <= 0) {
			throw new ArithmeticException("Divisão por zero não permitida ");
		}
		return x/y;
	}
}
