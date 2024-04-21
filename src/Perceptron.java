import java.util.List;

public class Perceptron {
    private String activationAttribute;
    private Double[] weights;
    private double learningRate;

    public Perceptron(String activationAttribute, double learningRate, int vectorSize) {
        this.activationAttribute = activationAttribute;
        this.learningRate = learningRate;
        this.weights = new Double[vectorSize];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = (2*Math.random()-1);
        }
    }


    public double classify(DataEntry entry){
        double sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += entry.getAttributes()[i] * weights[i];
        }

        return sum;
    }


    public void train(List<DataEntry> entries, int n){
        int trained = 0;

        for (int i = 0; i < n; i++) {
            for (DataEntry entry : entries){
                int actualDecAttribute = activationAttribute.equals(entry.getDecisionAttribute()) ? 1 : -1;

                double error = actualDecAttribute - classify(entry);
                if (Math.abs(error) <= 0.000001) {
                    trained++;
                    break;
                }
                trained = 0;

                for (int j = 0; j < weights.length; j++) {

                    weights[j] += error * entry.getAttributes()[j] * learningRate;
                }
            }
            if (trained >= entries.size()) break;
        }
    }

    public String getActivationAttribute() {
        return activationAttribute;
    }
}
