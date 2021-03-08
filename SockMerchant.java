import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    /**
     * Given the number of socks in a pile and an array representing 
     * each sock's colour, this will return the number of matching 
     * pairs in the pile.
     * @param sockCount: The number of socks in the pile.
     * @param socksArray: An array representing each sock, where each
     * different number represents a different colour.
     * @return pairCount: The number of matching sock pairs in the pile.
    */
    static int calculatePairsInThePile(int sockCount, int[] socksArray) {
        int pairCount = 0;
        //A Set won't have any duplicate elements
        Set<Integer> sockColours = new HashSet<>();
        //Loop through the sock pile
        for (int i = 0; i < sockCount; i++) {
            //Check if this sock's colour is already noted
            if (!sockColours.contains(socksArray[i])) {
                //This colour isn't in sockColours, so we add it
                sockColours.add(socksArray[i]);
            } else {
                pairCount++;
                //Remove this sock colour so that any other pairs of this colour can be made
                sockColours.remove(socksArray[i]);
            }
        }
        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = calculatePairsInThePile(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
