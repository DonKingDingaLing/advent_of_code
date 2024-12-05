import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge2Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        var inputFile = new File("aoc-2024/day_2/challenge_2/input.txt");
        var inputReader = new BufferedReader(new FileReader(inputFile));

        var validReports = inputReader.lines()
                .map(currentLine -> Arrays.stream(currentLine.split(" "))
                    .map(Integer::valueOf)
                    .toList())
                .filter(Challenge2Day2::isSafe)
                .count();

        System.out.println(String.format("Result: %s", validReports));
    }

    public static boolean isSafe(List<Integer> report) {
        if(isSafePermutation(report)) {
            return true;
        }

        for(int i = 0; i < report.size(); i++) {
            var permutation = new ArrayList<>(report);
            permutation.remove(i);
            if(isSafePermutation(permutation))
                    return true;
        }
        return false;
    }

    public static boolean isSafePermutation(List<Integer> report) {
        Boolean lastDirection = null;
        for (int i = 0; i < report.size() - 1; i++) {
            var distance = report.get(i) - report.get(i + 1);
            var increasing = distance < 0;
            distance = Math.abs(distance);
            var directionInconsistent = lastDirection != null && lastDirection != increasing;
            var distanceInconsistent = distance < 1 || distance > 3;

            if (distanceInconsistent || directionInconsistent) {
                return false;
            }

            lastDirection = increasing;
        }
        return true;
    }
}