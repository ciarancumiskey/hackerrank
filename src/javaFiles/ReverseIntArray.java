package javaFiles;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseIntArray {

    /**
     * Reverses the inputted int array.
     * @param a: The input array to be reversed
     * @return: The reversed form of the input array
     */
    static int[] reverseArray(int[] a) {
        //Create the output array
        int[] reversedArr = new int[a.length];
        for(int i = 0; i < a.length; i++){
            //Set the i-th element as the i-th-to-last element of the input array
            reversedArr[i] = a[a.length - 1 - i];
        }
        return reversedArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        System.out.println("How many elements does your array have?");
        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];
        
        System.out.println("Please enter your array, with each element separated by a space.");
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
