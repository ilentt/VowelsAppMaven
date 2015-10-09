package vn.elca.training;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelsPattern {

	public static String stringVowel1;
	public static String stringVowel2;

	public static boolean sameVowelPatternOfLongWord(String s1, String s2) throws InvalidInputException {
		// Define vowel pattern for check input string
		Pattern pattern = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);

		Matcher matcher1 = pattern.matcher(s1);
		Matcher matcher2 = pattern.matcher(s2);

		// Filter vowel string from input string
		String str1 = "";
		while (matcher1.find()) {
			str1 += matcher1.group();
		}
		stringVowel1 = str1.toUpperCase();

		String str2 = "";
		while (matcher2.find()) {
			str2 += matcher2.group();
		}

		stringVowel2 = str2.toUpperCase();

		// If vowel string exist in each input string and they are matched
		// together then return true
		if (!stringVowel1.isEmpty() && !stringVowel1.equals("") && !stringVowel2.isEmpty()
				&& !stringVowel2.equals("")) {
			if (str1.equals(str2))
				return true;
		}

		return false;
	}
	/*
	 * Main function for stand alone running public static void main(String[]
	 * args) { try { System.out.println(sameVowelPatternOfLongWord("TRABAIGRAN",
	 * "JAMACICA")); } catch (InvalidInputException e) { // TODO Auto-generated
	 * catch block e = new InvalidInputException("Input string are invalid");
	 * e.printStackTrace(); } }
	 */
}
