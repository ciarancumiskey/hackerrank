package src.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import src.javaFiles.AngryProfessor;
import src.javaFiles.LibraryFineCalculator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AngryProfessorTest {
    @ParameterizedTest
    @MethodSource("testLibraryFineArgs")
    public void testAngryProfessor(String classExpectedToBeCancelled, int minStudentsRequired, List<Integer> studentArrivalTimes) {
        String classCancelled = AngryProfessor.angryProfessor(minStudentsRequired, studentArrivalTimes);
        assertEquals(classExpectedToBeCancelled, classCancelled);
    }

    private static Arguments[] testLibraryFineArgs() {
        final List<Integer> testCase1 = new ArrayList<>();
        testCase1.add(-1);
        testCase1.add(-3);
        testCase1.add(4);
        testCase1.add(2);
        final List<Integer> testCase2 = new ArrayList<>();
        testCase2.add(-1);
        testCase2.add(0);
        testCase2.add(1);
        testCase2.add(2);
        return new Arguments[]{Arguments.of("YES", 3, testCase1),
                Arguments.of("NO", 2, testCase1)};
    }
}
