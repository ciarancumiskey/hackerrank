package src.javaFiles;

import java.io.*;

public class LibraryFineCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = calculateLibraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER representing the fine due.
     * The function accepts following parameters:
     *  1. INTEGER returnedDay
     *  2. INTEGER returnedMonth
     *  3. INTEGER returnedYear
     *  4. INTEGER dueDay
     *  5. INTEGER dueMonth
     *  6. INTEGER dueYear
     */

    public static int calculateLibraryFine(int returnedDay, int returnedMonth, int returnedYear, int dueDay, int dueMonth, int dueYear) {
        // Write your code here
        if (returnedYear < dueYear) {
            return 0;
        } else if (returnedYear == dueYear) {
            if (returnedMonth < dueMonth) {
                return 0;
            } else if(returnedMonth == dueMonth) {
                if (returnedDay <= dueDay) {
                    return 0;
                } else {
                    return (15 * (returnedDay - dueDay));
                }
            } else {
                return (500 * (returnedMonth - dueMonth));
            }
        } else {
            // Even if you return it on 1/1/2025 and it was due on 31/12/2024, RIP your kneecaps
            return 10000;
        }
    }
}
