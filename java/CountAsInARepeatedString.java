import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountAsInARepeatedString {

    /**
     * Finds the amount of times "a" will appear in a string that's repeated.
     * @param s: The string to be repeated.
     * @param charLimit: The length of the repeated sequence.
     * @return: The number of times A appears in the repeated sequence.
     */
    static long repeatedString(String s, long charLimit) {
        //Find the amount of times that you'll need to repeat the string in full
        long stringRepeats = charLimit/s.length();
        //Find the length of the partial string at the end of the repeated sequence.
        long left = charLimit - (s.length() * stringRepeats);
        int aCount = 0;
        int extraAs = 0;
        //Loop through the original string to count the number of "a"s in it
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                aCount++;
            }
        }
        //Loop through the truncated string to count the number of "a"s in it
        for(int i = 0; i < left; i++){
            if(s.charAt(i) == 'a'){
                extraAs++;
            }
        }
        /*  Multiply the number of "a"s in the original string by the amount of times
            it'll be repeated, and add on the number of "a"s in the truncated string at
            the end. */
        long aTotal = (stringRepeats * aCount) + extraAs;

        return aTotal;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
