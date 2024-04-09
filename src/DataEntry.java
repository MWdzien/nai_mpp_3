public class DataEntry {
    private String decisionAttribute;
    private Double[] attributes;

    public DataEntry(String decisionAttribute, Double[] attributes) {
        this.decisionAttribute = decisionAttribute;
        this.attributes = attributes;
    }

    public String getDecisionAttribute() {
        return decisionAttribute;
    }

    public Double[] getAttributes() {
        return attributes;
    }

    public void setDecisionAttribute(String decisionAttribute) {
        this.decisionAttribute = decisionAttribute;
    }

    public void setAttributes(Double[] attributes) {
        this.attributes = attributes;
    }
}
