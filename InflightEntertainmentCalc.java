import java.util.HashSet;
import java.util.Set;
public class InflightEntertainmentCalc {
    public static void main(String[] args){
        
    }

    public boolean checkIfTwoMovieLengthsEqualFlightTime(int flightTime, int[] movieLengths){
        if(movieLengths.length < 2) {
            return false; //You can't watch the same movie twice anyway
        }
        for(int i = 0; i < movieLengths.length; i++){
            //Start the second loop after your position in the first one
            for(int j = i + 1; j < movieLengths.length; j++){
                if(movieLengths[i] + movieLengths[j] == flightTime){
                    return true;
                }
            }
        }
        return false; //No two movie lengths add up to the flight length
    }
}