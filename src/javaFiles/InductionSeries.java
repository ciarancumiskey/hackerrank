package javaFiles;
import java.util.*;
import java.io.*;

class InductionSeries{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        //Prompt the user for the number of queries they want
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            //Clear the StringBuilder
            sb.setLength(0);
            for(int j = 0; j < n; j++) {
                //The sequence 2^0 + 2^1 + ... 2^j can simply be reduced to 2^(j+1) - 1
                sb.append((int) (a + b*(Math.pow(2, j+1) - 1))).append(" ");
            }
            //Print out the resulting series for the i-th query
            System.out.println(sb.toString());
        }
        in.close();
    }
}
