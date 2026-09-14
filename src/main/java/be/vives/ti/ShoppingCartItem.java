package be.vives.ti;

public class ShoppingCartItem {

    private final Product product;
    private int quantity;

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "{" +
                 product +
                ", quantity=" + quantity +
                '}';
    }
}
