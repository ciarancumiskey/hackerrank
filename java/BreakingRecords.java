import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BreakingRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        //Use the first score as the default values for the record scores
        int lowestScore = scores[0], highestScore = scores[0];
        //Initialise the count variables
        int lowestScoreBrokenCount = 0, highestScoreBrokenCount = 0;
        //We've already used the first element of the array to initialise these variables, so we'll start
        //looping from the 2nd element
        for(int i = 1; i < scores.length; i++){
            if(lowestScore < scores[i]){
                lowestScore = scores[i];
                lowestScoreBrokenCount++;
            } else if(scores[i] < highestScore){
                highestScore = scores[i];
                highestScoreBrokenCount++;
            }
        }
        int[] recordsBrokenCounts = {lowestScoreBrokenCount, highestScoreBrokenCount};
        return recordsBrokenCounts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
