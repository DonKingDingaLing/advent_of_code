import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Challenge1Day1 {
    public static void main(String[] args) throws IOException {
        var inputFile = new File("aoc-2024/day_1/challenge_1/input.txt");
        var inputReader = new BufferedReader(new FileReader(inputFile));

        var firstList = new ArrayList<Integer>();
        var secondList = new ArrayList<Integer>();
        var distance = new ArrayList<Integer>();

        var currentLine = "";
        while((currentLine = inputReader.readLine()) != null) {
            var values = currentLine.split("   ");
            firstList.add(Integer.valueOf(values[0]));
            secondList.add(Integer.valueOf(values[1]));
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        for(int i = 0; i < firstList.size(); i++) {
            distance.add(Math.abs(firstList.get(i) - secondList.get(i)));
        }

        var result = distance.stream().mapToInt(Integer::intValue).sum();
        System.out.println(result);
    }
}