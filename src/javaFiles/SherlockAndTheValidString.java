package src.javaFiles;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SherlockAndTheValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING denoting whether the input string was valid.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        if(s.length() <= 3) {
            // There's no way for 2 different characters to show up such that one appears at least twice more than the other
            return "YES";
        }
        // Write your code here
        final HashMap<Character, Integer> characterCountsMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character characterAtI = s.charAt(i);
            characterCountsMap.put(characterAtI, characterCountsMap.getOrDefault(characterAtI, 0) + 1);
        }
        // Create a hashmap to track how many times a letter count shows up. For example, for "aabbcc", "a", "b" and
        // "c" all appear 2 times, so the count map should be {[2, 3]} for the 3 different letters. "aabbc" results in
        // a map of {[1, 1], [2, 2]}.
        final HashMap<Integer, Integer> countMap = new HashMap<>();
        characterCountsMap.values().forEach(count -> {
            countMap.put(count, countMap.getOrDefault(count, 0) + 1);
        });

        if(countMap.size() == 1) {
            return "YES";
        } else if (countMap.size() > 2) {
            // If there are letters which appear 3 different amounts of times (e.g. A appears 1 time, B appears 2
            // times, C appears 3 times) then it's impossible to just remove 1 letter such that there'll only be one
            // letter remaining that appears 1 more time than any other letter.
            return "NO";
        } else {
            Object[] countKeys = countMap.keySet().toArray();
            Object[] countValues = countMap.values().toArray();
            int charCount1 = (int) countKeys[0];
            int charCount2 = (int) countKeys[1];
            int countOfCounts1 = (int) countValues[0];
            int countOfCounts2 = (int) countValues[1];
            if((charCount1 + 1 == charCount2 && countOfCounts2 == 1) || (charCount2 + 1 == charCount1 && countOfCounts1 == 1)) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }
}
