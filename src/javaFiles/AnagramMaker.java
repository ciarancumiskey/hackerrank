package src.javaFiles;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AnagramMaker {

    /**
	 *	makeAnagram takes two input strings and returns the number of characters that must be deleted so a & b
	 *	become anagrams
	 *	@param String a, b - the two strings to be pared down so they become anagrams of each other
	 *	@return int requiredDeletions - the amount of characters in each string that would be deleted so a & b 
	 * 	become anagrams of each other
	 */
    static int makeAnagram(String a, String b) {
        int charCountA[] = new int[26]; //count occurances of A-Z in a
        int charCountB[] = new int[26]; //count occurances of A-Z in b
        /**
         * Loop through the input strings and increment the corresponding elements in
         * charCountA & B
         */
        for(int i = 0; i < a.length(); i++){
            charCountA[a.charAt(i) -'a']++;
        }
        for(int i = 0; i < b.length(); i++){
            charCountB[b.charAt(i) -'a']++;
        }
        int requiredDeletions = 0;
        //Loop through charCountA & B 
        for(int i = 0; i < 26; i++){
            requiredDeletions += Math.abs(charCountA[i]-charCountB[i]);
        }
        return requiredDeletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}