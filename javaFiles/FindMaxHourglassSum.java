package javaFiles;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindMaxHourglassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxHourglass = Integer.MIN_VALUE;
        //Cycle through the input array
        for(int rowNum = 0; rowNum < 4; rowNum++){
            //Cycle through each row
            for(int colNum = 0; colNum < 4; colNum++){
                //Sum up the elements of the current hourglass
                int currentHourglassSum = arr[rowNum][colNum]
                    + arr[rowNum][colNum+1]
                    + arr[rowNum][colNum+2]
                    + arr[rowNum+1][colNum+1]
                    + arr[rowNum+2][colNum]
                    + arr[rowNum+2][colNum+1]
                    + arr[rowNum+2][colNum+2];
                //Check the current hourglass sum against the current maximum
                if(maxHourglass < currentHourglassSum)
                    maxHourglass = currentHourglassSum;
            }
        }
        return maxHourglass;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];
        //Cycle through each row in the array
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            //Fill in the i-th row of the array
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
