package src.javaFiles;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CloudJumper {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int numClouds = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] clouds = new int[numClouds];
        //Populate the clouds array
        for(int i = 0; i < numClouds; i++){
            clouds[i] = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        int jumpsCount = -1;
        //Loop through the clouds array
        for (int step = 0; step < numClouds; step++, jumpsCount++) {
            //Check if the cloud 2 steps ahead exists and is safe
            if (step < numClouds - 2 && clouds[step+2] == 0) {
                //If so, skip the next step
                step++;
            }
        }
        System.out.println(jumpsCount);
        scanner.close();
    }
}
