package src.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import src.javaFiles.SherlockAndTheValidString;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SherlockAndTheValidStringTest {

    @ParameterizedTest
    @MethodSource("testSherlockAndTheValidStringSource")
    public void testSherlockAndTheValidString(final String testString, final String expectedAnswer) {
        final String testStringIsValid = SherlockAndTheValidString.isValid(testString);
        assertEquals(expectedAnswer, testStringIsValid);
    }

    private static Arguments[] testSherlockAndTheValidStringSource() {
        return new Arguments[]{Arguments.of("abc", "YES"),
        Arguments.of("aaa", "YES"),
        Arguments.of("a", "YES"),
        Arguments.of("abb", "YES"),
        Arguments.of("abcc", "YES"),
        Arguments.of("abccc", "NO"),
        Arguments.of("abbccc", "NO"),
        Arguments.of("aabcc", "NO"),
        Arguments.of("abbc", "YES"),
        Arguments.of("aabc", "YES"),
        Arguments.of("abbcc", "NO"),
        Arguments.of("aabbcd", "NO"),
        Arguments.of("aabbccddeefghi", "NO"),
        Arguments.of("abcdefghhgfedecba", "YES"),
        Arguments.of("aabbcc", "YES")};
    }
}
