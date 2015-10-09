package vn.elca.training;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class VowelsPatternTest {

	private String str1;
	private String str2;
	private boolean result;
	/**
	 * @param str1
	 * @param str2
	 * @param result
	 */
	public VowelsPatternTest(String str1, String str2, boolean result) {
		this.str1 = str1;
		this.str2 = str2;
		this.result = result;
	}
	
	@Parameters(name = "{index}: sameVowelPatternOfLongWord({0}, {1}) => result: {2}")
	public static Iterable<Object[]> dataTest() {
		return Arrays.asList(new Object[][] {
			{"HORIDE","TOBRITE",true},
			{"TRABAIGRAN","JAMAICA",true},
			{"TRABAIGRAN","JAMACICA",true},
			{"HANEMO","TENAMO",false},
			{"HANEMO","TANEMU",false},
			{"HANEMO","HANEMONI",false},
		});
	}
	
	@Test
	public void testSameVowelPatternOfLongWord() {
		try {
			assertEquals(result,VowelsPattern.sameVowelPatternOfLongWord(str1, str2));
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e = new InvalidInputException("Input string are invalid!");
			e.printStackTrace();
		}
	}
}
