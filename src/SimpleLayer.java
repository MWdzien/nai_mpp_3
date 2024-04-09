import java.util.ArrayList;
import java.util.List;

public class SimpleLayer {
    List<Perceptron> neuralNetwork;

    public SimpleLayer() {
        this.neuralNetwork = new ArrayList<>();
    }

    public SimpleLayer(List<Perceptron> neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public String getOutput(DataEntry entry){
        for (Perceptron perceptron : neuralNetwork){
            if (perceptron.classify(entry) == 1){
                return perceptron.getActivationAttribute();
            }
        }
        return "Entry could not be classified";
    }

    public void addPerceptron(Perceptron perceptron) {
        this.neuralNetwork.add(perceptron);
    }
}
