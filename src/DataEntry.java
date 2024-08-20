public class DataEntry {
    private String decisionAttribute;
    private double[] attributes;

    public DataEntry(String decisionAttribute, double[] attributes) {
        this.decisionAttribute = decisionAttribute;
        this.attributes = attributes;
    }

    public String getDecisionAttribute() {
        return decisionAttribute;
    }

    public double[] getAttributes() {
        return attributes;
    }
}
