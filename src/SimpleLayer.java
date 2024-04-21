import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SimpleLayer {
    List<Perceptron> neuralNetwork;
    double learningRate;
    int n;

    public SimpleLayer(String trainingDataDir) {
        this.neuralNetwork = new ArrayList<>();
        learningRate = 0.01;
        n = 100000;
        createPerceptrons(trainingDataDir);
        trainLayer(trainingDataDir);
    }

    public SimpleLayer(List<Perceptron> neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public String getOutput(DataEntry entry){
        String maxNetLang = "";
        double maxNet = 0;
        for (Perceptron perceptron : neuralNetwork){
            if (perceptron.classify(entry) > maxNet){
                maxNet = perceptron.classify(entry);
                maxNetLang = perceptron.getActivationAttribute();
            }
        }
        return maxNetLang;
    }

    private void createPerceptrons(String trainingDataDir){
        File trainingData = new File(trainingDataDir);

        for (File languageDir : trainingData.listFiles()){
            Perceptron perceptron = new Perceptron(languageDir.getName(), learningRate, 26);
            neuralNetwork.add(perceptron);
        }
    }

    public void addPerceptron(Perceptron perceptron) {
        this.neuralNetwork.add(perceptron);
    }

    public void trainLayer(String trainingDataDir){
        File trainingData = new File(trainingDataDir);
        List<DataEntry> trainingEntries = new ArrayList<>();

        for (File languageDir : trainingData.listFiles()){
            for (File textFile : languageDir.listFiles()){
                trainingEntries.add(DataReader.readLanguageFile(textFile, languageDir.getName()));
            }
        }

        for (Perceptron perceptron : neuralNetwork){
            perceptron.train(trainingEntries, n);
        }
    }
}
