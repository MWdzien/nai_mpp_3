import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File trainingDataDir = new File("trainingData/");
        double learningRate = 0.01;
        SimpleLayer simplePerceptronLayer = new SimpleLayer();
        int n = 40;

        for (File languageDir : trainingDataDir.listFiles()){
            List<DataEntry> trainingFiles = new ArrayList<>();
            Perceptron languagePerceptron = new Perceptron(languageDir.getName(), learningRate, 26);

            for (File textFile : languageDir.listFiles()){
                trainingFiles.add(DataReader.readLanguageFile(textFile, languageDir.getName()));

            }

            languagePerceptron.train(trainingFiles, n);

            simplePerceptronLayer.addPerceptron(languagePerceptron);
        }

        String out = simplePerceptronLayer.getOutput(DataReader.readLanguageFile(new File("testData/Liść.txt"), ""));

        System.out.println(out);
    }
}