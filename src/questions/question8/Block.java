package questions.question8;

public class Block {
    private int quantity;
    private double price;

    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // method to remove sellAmount amount in quantity
    public void sell(int sellAmount) {
        this.quantity = this.quantity - sellAmount;
    }
}

