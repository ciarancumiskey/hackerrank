// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    /**
     * @param A: The list of all contacts' names
     * @param B: The list of all contacts' phone numbers
     * @param P: A substring of the phone number you want to search for
     * @return contactName: The name of the contact whose phone number contains P
     */
    public String solution(String[] A, String[] B, String P) {
        // write your code in Java SE 8
        TreeSet<String> matchedContacts = new TreeSet<>(); //start off with the default case
        for(int i = 0; i < B.length; i++){
            //check if P is in the i-th phone number
            if(B[i].contains(P)){
                //check if the i-th name is alphabetically smaller than contactName
                matchedContacts.add(A[i]);
            }
        }
        if(matchedContacts.isEmpty()){
            return "NO CONTACT";
        } else {
            return matchedContacts.first();
        }
    }

    
}
