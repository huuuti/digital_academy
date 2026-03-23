package Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static void main() throws IOException {
        Path filePathCircle = Paths.get("src/main/java/Task2/circle.txt");
        Path filePathDot = Paths.get("src/main/java/Task2/dot.txt");
        String fileCircle = Files.readString(filePathCircle);
        String fileDot = Files.readString(filePathDot);

        List<String> circle = List.of(fileCircle.split(","));
        List<String> dot = List.of(fileDot.split(";"));
        List<List<String>> dotList = new ArrayList<>();

        for (int i = 0; i < dot.size(); i++){
            dotList.add(List.of(dot.get(i).split(",")));
        }
        for (int i = 0; i < dotList.size(); i++) {
            int radius = (int) Math.pow(Double.parseDouble(circle.get(2)), 2);
            int point = (int) Math.pow(Integer.parseInt(dotList.get(i).get(0)) - Integer.parseInt(circle.get(0)), 2)
                    + (int) Math.pow(Integer.parseInt(dotList.get(i).get(1)) - Integer.parseInt(circle.get(1)), 2);
            if (point == radius) {
                System.out.println(0);
            } else if (point < radius) {
                System.out.println(1);
            } else if (point > radius) {
                System.out.println(2);
            }
        }
    }

}
