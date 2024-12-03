package javaFiles;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    /** Given an array of ints representing the original positions of people in a 
    *   queue, calculate how many of them bribed the person ahead. If anyone needed
    *   to bribe more than 2 people, then just print "Too chaotic".
    *   @param q: The queue following all of the bribing operations.
    */
    static void minimumBribes(int[] q) {
        int bribeCount = 0;
        //Keep track of the three lowest numbers encountered
        int thirdSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        //Iterate through the queue from back to front
        for(int pos = q.length - 1; pos >= 0; pos--){
            //Chaos ensues if someone bribes more than two people
            if((q[pos] - pos) > 3){
                System.out.println("Too chaotic");
                return;
            } else {
                //Given a queue [1, 2, 3, 4, 8, 5, 6, 7], the 3rd-smallest number encountered when we encounter person #8 would be #7, meaning they've bribed more than the limit of 2 people.
                if(q[pos] > thirdSmallest){
                    System.out.println("Too chaotic");
                    return;
                } else if (q[pos] > secondSmallest){
                    //This person's bribed 2 people, so increase bribeCount by 2
                    bribeCount += 2;
                } else if (q[pos] > smallest){
                    //This person bribed 1 other person, so increment bribeCount
                    bribeCount++;
                }
                //Compare this queue member against the 3 smallest observed values, and update them if necessary
                if(q[pos] < smallest){
                    thirdSmallest = secondSmallest;
                    secondSmallest = smallest;
                    smallest = q[pos];
                } else if (q[pos] < secondSmallest){
                    thirdSmallest = secondSmallest;
                    secondSmallest = q[pos];
                } else if (q[pos] < thirdSmallest){
                    thirdSmallest = q[pos];
                }
            }
        }
        System.out.println(bribeCount);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int count = 0; count < testCases; count++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }
            //At the end of each test case, count the minimum number of bribes needed
            minimumBribes(q);
        }

        scanner.close();
    }
}
