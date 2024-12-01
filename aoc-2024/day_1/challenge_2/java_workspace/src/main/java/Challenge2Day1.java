import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Challenge2Day1 {
    public static void main(String[] args) throws IOException {
        var inputFile = new File("aoc-2024/day_1/challenge_2/input.txt");
        var inputReader = new BufferedReader(new FileReader(inputFile));

        var firstList = new ArrayList<Integer>();
        var secondList = new ArrayList<Integer>();

        var currentLine = "";
        while((currentLine = inputReader.readLine()) != null) {
            var values = currentLine.split("   ");
            firstList.add(Integer.valueOf(values[0]));
            secondList.add(Integer.valueOf(values[1]));
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        var similarities = firstList.stream()
                .map(x -> secondList.stream().filter(y -> Objects.equals(x, y)).count() * x)
                .toList();

        var result = similarities.stream().mapToInt(Long::intValue).sum();
        System.out.println(result);
    }
}