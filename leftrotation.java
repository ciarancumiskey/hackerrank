import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //The number of elements in the array
        int k = in.nextInt(); //The number of left rotations to be done
        int a[] = new int[n];
        for(int i=0; i < n; i++){
            a[i] = in.nextInt();
        }
        for(int j = 0; j < n; j++){
			/* Add the array's length to bI to avoid a negative result, 
			then after adding the amount of left rotations to be done, 
			modulo the result by the array's length */
            int newPos = (j + n + k) % n; 
            System.out.print(a[newPos] + " ");
        }
    }
}
