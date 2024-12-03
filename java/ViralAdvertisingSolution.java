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

class Result {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int viralAdvertising(int numDays) {
    // Write your code here
        int totalLikes = 0;
        int numViewers = 5;
        while(numDays > 0) {
            // Half (or whatever it rounds down to) of the viewers like the ad
            int numDailyLikes = numViewers / 2;
            totalLikes += numDailyLikes;
            // Those who liked the ad share it with 3 friends each
            numViewers = numDailyLikes * 3;            
            numDays--;
        }
        return totalLikes;
    }

}

public class ViralAdvertisingSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
