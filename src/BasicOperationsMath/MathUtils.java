package BasicOperationsMath;

import java.util.Map;
import java.util.Set;

public class MathUtils {
	public static final Set<Character> VALID_OPERATORS = Set.of(
			'+',
			'-',
			'*',
			'/',
			'^'
			);
	public static final Set<Character> VALID_CHARACTERS = Set.of(
			'(',
			')',
			'='
			);
	public static final Map<Character, Integer> PRIORITY = Map.of(
			'+', 1,
			'-', 1,
			'*', 2,
			'/', 2,
			'^', 3
	);
}
