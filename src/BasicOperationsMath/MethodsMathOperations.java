package BasicOperationsMath;

import java.util.List;

public class MethodsMathOperations extends OperationsMath {

	@Override
	public Double Sum(List<Double> validatorNumbers) {
		
		double sumOfItems = 0;
		for (Double items : validatorNumbers) {
			sumOfItems += items;
		}
		return sumOfItems;
	}

	@Override
	public Double Subtraction(List<Double> validatorNumbers) {
		
		double subtractionOfItems = 0;
		for (Double items : validatorNumbers) {
			subtractionOfItems -= items;
		}
		return subtractionOfItems;
	}

	@Override
	public Double Multiplication(List<Double> validatorNumbers) {
		
		double multiplicationOfItems = 1;
		for (Double items : validatorNumbers) {
			multiplicationOfItems *= items;
		}
		return multiplicationOfItems;
	}

	@Override
	public Double Division(List<Double> validatorNumbers) {
		
		double divisionOfItems = 1;
		for (Double items : validatorNumbers) {
						
			divisionOfItems /= items;
		}
		return divisionOfItems;
	}
}
