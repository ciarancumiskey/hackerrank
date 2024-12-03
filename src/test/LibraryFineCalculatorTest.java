package src.test;

import org.junit.jupiter.api.Test;
import src.javaFiles.LibraryFineCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryFineCalculatorTest {
    @Test
    public void testLibraryFine() {
        int expectedFine = 45;
        int actualFine = LibraryFineCalculator.calculateLibraryFine(9, 6, 2015, 6, 6, 2015);
        assertEquals(expectedFine, actualFine);
    }

}
