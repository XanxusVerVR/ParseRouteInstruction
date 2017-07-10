package txttojson;
public class BagOfPrimitives {
    private String htmlInstructions;

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        this.htmlInstructions = htmlInstructions;
    }

    @Override
    public String toString() {
        return "BagOfPrimitives{" + "htmlInstructions=" + htmlInstructions + '}';
    }
    
}