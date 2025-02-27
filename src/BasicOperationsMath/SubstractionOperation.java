package BasicOperationsMath;

import java.util.List;

public class SubstractionOperation implements MathOperation{

		@Override
		public double calculate(List<Double> numbers) {
			double result = 0;
			for(Double items : numbers) {
				result -= items;
			}
			
			return result;
		}


}
