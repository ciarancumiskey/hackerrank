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
            // Increment the character count if it exists
            if(characterCountsMap.get(characterAtI) != null) {
                Integer characterCount = characterCountsMap.get(characterAtI);
                characterCount++;
                characterCountsMap.put(characterAtI, characterCount);
            } else {
                characterCountsMap.put(characterAtI, 1);
            }
        }
        AtomicInteger removalsRequired = new AtomicInteger();
        final int minimumAppearances = Collections.min(characterCountsMap.values());
        characterCountsMap.values().forEach(count -> {
            if(minimumAppearances < count) {
                removalsRequired.addAndGet((count - minimumAppearances));
            }
        });
        return (removalsRequired.get() <= 1) ? "YES" : "NO";
    }
}
