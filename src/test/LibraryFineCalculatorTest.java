package src.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import src.javaFiles.LibraryFineCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryFineCalculatorTest {
    @ParameterizedTest
    @MethodSource("testLibraryFineArgs")
    public void testLibraryFine(int expectedFine, int returnedDay, int returnedMonth, int returnedYear, int dueDay, int dueMonth, int dueYear) {
        int actualFine = LibraryFineCalculator.calculateLibraryFine(returnedDay, returnedMonth, returnedYear, dueDay, dueMonth, dueYear);
        assertEquals(expectedFine, actualFine);
    }

    private static Arguments[] testLibraryFineArgs() {
        return new Arguments[]{Arguments.of(45, 9, 6, 2015, 6, 6, 2015),
                Arguments.of(135, 14, 7, 2018, 5, 7, 2018),
                Arguments.of(150, 16, 6, 2015, 6, 6, 2015),
                Arguments.of(195, 19, 6, 2015, 6, 6, 2015),
                Arguments.of(500, 19, 7, 2015, 6, 6, 2015),
                Arguments.of(1500, 19, 7, 2015, 6, 4, 2015),
                // Where's this mythical library that's open on New Year's Eve/Day?
                Arguments.of(5500, 31, 12, 2015, 1, 1, 2015),
                Arguments.of(10000, 19, 7, 2016, 6, 4, 2015),
                Arguments.of(10000, 19, 7, 2017, 6, 4, 2015),
                // What if Fry forgot about a book he borrowed?
                Arguments.of(10000, 19, 7, 3017, 6, 4, 1999),
                Arguments.of(0, 19, 7, 2017, 6, 4, 2019),
                // What if I were to borrow the Book of Kells and disguise it as my own work?
                Arguments.of(0, 19, 7, 1017, 6, 4, 2019),
                Arguments.of(0, 29, 11, 2024, 3, 12, 2024),
                Arguments.of(0, 9, 6, 2015, 16, 6, 2015)};
    }
}
