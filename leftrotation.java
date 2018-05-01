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
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int bI = 0; bI < n; bI++){
            int newPos = (bI + n + k) % n; //Add the array's length to bI to avoid a negative result, then after adding the amount of left rotations to be done, modulo the result by the array's length
            int temp = a[newPos];
            System.out.print(a[newPos] + " ");
        }
    }
}
