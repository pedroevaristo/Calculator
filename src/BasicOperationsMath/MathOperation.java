package BasicOperationsMath;

import java.util.List;


public interface MathOperation {//aplicando o padrão de projeto strategy para os metodos concretos
	public abstract double calculate(List<Double> numbers);

}
