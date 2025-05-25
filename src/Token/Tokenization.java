package Token;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Tokenization {
	public static List<String> tonkenizer(String expression){
		List<String> tokens = new ArrayList<>();
		Pattern pattern = Pattern.compile(
		"([0-9]+(?:\\.[0-9]+)?)|"+
		"(\\+|-|\\*|/|\\^)|"+
		"([a-zA-Z]+) |"+
		"(\\s+)"				
				);
		Matcher matcher = pattern.matcher(expression);
		
		while(matcher.find()) {
			if (matcher.group(1) != null) tokens.add(matcher.group(1));
				else if(matcher.group(2) != null)  tokens.add(matcher.group(2));
				else if(matcher.group(3) != null) tokens.add(matcher.group(3));
				else if(matcher.group(4) != null) tokens.add(matcher.group(4));
			}
		return tokens;
		}
	}
