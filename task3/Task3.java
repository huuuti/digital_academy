package Task3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static List<TestsData> listTest = new ArrayList<>();

    static void main() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите путь к файлу tests:");
        String put = scanner.nextLine();
        File testsFile = new File(put);
        System.out.println("Укажите путь к файлу values:");
        String putValue = scanner.nextLine();
        File valuesFile = new File(putValue);

        Values values = objectMapper.readValue(valuesFile, Values.class);
        Tests tests = objectMapper.readValue(testsFile, Tests.class);

        for (int i = 0; i < tests.getTests().size(); i++){
            TestsData testsData = tests.getTests().get(i);
            if (testsData.getValues() == null){
                listTest.add(tests.getTests().get(i));
            } else {
                recursValues(testsData);
            }
        }
        listTest.forEach(lTest -> {
            String result = values.getValues().stream().filter(val -> val.getId().equals(lTest.getId())).findFirst().get().getValue();
            lTest.setValue(result);
        });
        jobFile();
    }

    private static void recursValues(TestsData test){
        if (test.getValues() == null){
            listTest.add(test);
        }
        else{
            for (int i = 0; i < test.getValues().size(); i++){
                recursValues(test.getValues().get(i));
            }
        }
    }

    private static void jobFile() throws IOException {
        File myFile = new File("report.json");
        myFile.createNewFile();
        FileWriter fileWriter = new FileWriter("report.json");
        fileWriter.write("{\"tests\":[");
        for (int i = 0; i < listTest.size(); i++){
            try {
                fileWriter.write(listTest.get(i).toString());
            } catch (IOException e){
                throw new RuntimeException(e);
            }
            if (i != listTest.size() -1 ){
                fileWriter.write(",");
            }
        }
        fileWriter.write("]}");
        fileWriter.close();
    }
}
