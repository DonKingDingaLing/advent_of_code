import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Challenge1Day2 {
    public static void main(String[] args) throws IOException {
        var inputFile = new File("aoc-2024/day_2/challenge_1/input.txt");
        var inputReader = new BufferedReader(new FileReader(inputFile));

        var validReports = inputReader.lines()
                .map(currentLine -> Arrays.stream(currentLine.split(" "))
                    .map(Integer::valueOf)
                    .toList())
                .filter(report -> {
                    Boolean lastDirection = null;
                    for(int i = 0; i < report.size() - 1; i++) {
                        var distance = report.get(i)-report.get(i+1);
                        var increasing = distance < 0;
                        distance = Math.abs(distance);

                        if((lastDirection != null && lastDirection != increasing)
                                || (distance < 1 || distance > 3)) {
                            return false;
                        }

                        lastDirection = increasing;
                    }
                    return true;
                })
                .count();

        System.out.println(String.format("Result: %s", validReports));
    }
}