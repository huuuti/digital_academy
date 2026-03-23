package Task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    static void main() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите путь к файлу:");
        String put = scanner.nextLine();

        Path numberPath = Paths.get(put);
        String fileNumber = Files.readString(numberPath);
        List<Integer> listNumbers = Stream.of(fileNumber.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> listSum = new ArrayList<>();

        for (int i = 0; i < listNumbers.size(); i++) {
            int sum = 0;
            for (int j = 0; j < listNumbers.size(); j++){
                if (i != j) {
                    sum = sum + Math.abs(listNumbers.get(i) - listNumbers.get(j));
                }
            }
            listSum.add(sum);
        }
        System.out.println(Collections.min(listSum));
    }
}
