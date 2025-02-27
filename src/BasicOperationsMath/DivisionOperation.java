package BasicOperationsMath;

import java.util.List;

public class DivisionOperation implements MathOperation{

	@Override
	public double calculate(List<Double> numbers) {
		double result = 0;
		for(double items: numbers) {
			result /= items;
		}
		return result;
	}

}
