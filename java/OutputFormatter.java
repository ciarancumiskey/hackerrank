import java.util.Scanner;

public class OutputFormatter {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                //Format s1 so that it takes up 15 characters while x is 3 digits long with leading zeroes
                System.out.printf("%-15s%03d%n", s1, x);
            }
            System.out.println("================================");

    }
}



