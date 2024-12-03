import java.util.HashSet;
import java.util.Set;
public class InflightEntertainmentCalc {
    public static void main(String[] args){
        
    }

    public boolean checkIfTwoMovieLengthsEqualFlightTime(int flightTime, int[] movieLengths){
        if(movieLengths.length < 2) {
            return false; //You can't watch the same movie twice anyway
        }
        Set<Integer> movieLengthsSeen = new HashSet<>();
        for(int firstMovieLength : movieLengths){
            int matchingSecondMovieLength = flightTime - firstMovieLength;
            if(movieLengthsSeen.contains(matchingSecondMovieLength)){
                return true;
            }
            movieLengthsSeen.add(firstMovieLength);
        }
        return false; //No two movie lengths add up to the flight length
    }
}