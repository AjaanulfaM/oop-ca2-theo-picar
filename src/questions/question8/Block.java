package questions.question8;

public class Block {
    private double buy;
    private double quantity;

    public Block(double buy, double quantity) {
        this.buy = buy;
        this.quantity = quantity;
    }

    // Getters
    public double getBuy() {
        return this.buy;
    }

    public double getQuantity() {
        return this.quantity;
    }

    // Setters
    public void setBuy(double buy) {
        this.buy = buy;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}

