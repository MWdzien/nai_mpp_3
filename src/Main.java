import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String trainingDataDir = "trainingData/";
        String testDataDir = "testData/";
        SimpleLayer simplePerceptronLayer = new SimpleLayer(trainingDataDir);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To check the test data accuracy type in \"test\".\nTo classify your own text type in \"text\".");
            String resp = scanner.nextLine();

            System.out.println("-----------------------------------");

            switch (resp) {
                case "test":
                    double correctlyClassified = 0;
                    double testFilesAmount = 0;
                    File testDir = new File(testDataDir);
                    for (File langDir : testDir.listFiles()) {
                        for (File textFile : langDir.listFiles()) {
                            if (simplePerceptronLayer.getOutput(DataReader.readLanguageFile(textFile, textFile.getName())).equals(langDir.getName())) {
                                correctlyClassified++;
                            }
                            testFilesAmount++;
                        }
                    }
                    System.out.println("Program correctly classified " + (int) correctlyClassified + " out of " + (int) testFilesAmount + " test files, which gives " + (correctlyClassified / testFilesAmount) * 100 + "% accuracy.");
                    break;
                case "text":
                    System.out.println("Paste in a text to classify");
                    String text = "";
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String line;
                    try {
                        while ((line = br.readLine()) != null) {
                            text += line;
                            if (line.isEmpty()) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String out = simplePerceptronLayer.getOutput(DataReader.readText(text));
                    System.out.println("\n-----------------------------------");
                    System.out.println(out);
                    System.out.println("-----------------------------------");
                    break;
            }
        }
    }
}