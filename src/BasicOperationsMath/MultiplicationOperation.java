package BasicOperationsMath;

import java.util.List;

public class MultiplicationOperation implements MathOperation {

	@Override
	public double calculate(List<Double> numbers) {
		double result = 1;
		for(double items : numbers) {
			result *= items;
		}
		return result;
	}

}
