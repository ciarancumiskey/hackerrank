import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LeftRotations {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int arraySize = scan.nextInt();
        int[] array = new int[arraySize];
        int leftRotations = scan.nextInt();
		
        for(int i = 0; i < arraySize; i++) {
            //Populate the array, use the arraySize to get the remainder in case of "overflow"
            //Assuming arraySize = 5, leftRotations = 3
            //Then the element at array[i] will be
            //the ((2+i)%5)-th element entered by the user.
            //For example, the element at array[4] will be at index
            //((2+i)%5) -> ((2+4)%5) -> (6%5) -> [1] of the entered array.
            array[(i + arraySize - leftRotations) % arraySize] = scan.nextInt();
        }
        for(int i = 0; i < arraySize; i++) {
            System.out.print(array[i] + " ");
        } 
    }
}
