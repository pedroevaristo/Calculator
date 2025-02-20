package Validator;

import java.util.Optional;

public class ValidatorFromInput {
	public Optional<Double> validatorInput(String input) {
		try {
			double verifiedNumber = Double.parseDouble(input);
			return Optional.of(verifiedNumber);
		} catch (Exception e) {
			System.out.println("Input inválido "+input+" digite apenas numeros");
			return Optional.empty();
		}
	}
}
