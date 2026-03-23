package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Task1 {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задаем n");
        int n = scanner.nextInt();
        System.out.println("Задаем m");
        int m = scanner.nextInt();

        List<Integer> g = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++){
                g.add(j);
            }
        }

        String put = "";
        int i = 0;
        boolean finish = true;
        while (finish){
            put = put + g.get(i);
            i = i + m - 1;
            if (g.get(0) == g.get(i)){
                finish = false;
            }
        }
        System.out.println(put);
    }
}
