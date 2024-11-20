package questions.question8;

public class Block {
    private double buy;
    private double quantity;
    private double price;
    private String symbol;

    public Block(double buy, double quantity, double price, String symbol) {
        this.buy = buy;
        this.quantity = quantity;
        this.price = price;
        this.symbol = symbol;
    }

    // Getters
    public double getBuy() {
        return this.buy;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public String getSymbol() {
        return this.symbol;
    }

    // Setters
    public void setBuy(double buy) {
        this.buy = buy;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double quantity) {
        this.quantity = quantity;
    }

    public void setSymbol(String quantity) {
        this.symbol = quantity;
    }
}

