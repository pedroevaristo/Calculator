package BasicOperationsMath;

import java.util.List;

public class MethodsMathOperations extends OperationsMath {

	@Override
	public Double Sum(List<Double> validatorNumbers) {
		// TODO Auto-generated method stub
		double sumOfItems = 0;
		for (Double items : validatorNumbers) {
			sumOfItems += items;
		}
		return sumOfItems;
	}

	@Override
	public Double Subtraction(List<Double> validatorNumbers) {
		// TODO Auto-generated method stub
		double subtractionOfItems = 0;
		for (Double items : validatorNumbers) {
			subtractionOfItems -= items;
		}
		return subtractionOfItems;
	}

	@Override
	public Double Multiplication(List<Double> validatorNumbers) {
		// TODO Auto-generated method stub
		double multiplicationOfItems = 1;
		for (Double items : validatorNumbers) {
			multiplicationOfItems *= items;
		}
		return multiplicationOfItems;
	}

	@Override
	public Double Division(List<Double> validatorNumbers) {
		// TODO Auto-generated method stub
		double divisionOfItems = 1;
		for (Double items : validatorNumbers) {
						
			divisionOfItems /= items;
		}
		return divisionOfItems;
	}
}
