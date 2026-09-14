package be.vives.ti;

import java.util.Arrays;

public class ShoppingCart {

    private static final int MAX_NUMBER_OF_ITEMS = 5;
    private ShoppingCartItem[] cart;
    private int numberOfItems;

    public ShoppingCart() {
        numberOfItems = 0;
        cart = new ShoppingCartItem[MAX_NUMBER_OF_ITEMS];
    }

    public void addToCart(Product product, int quantity) {
        int indexOfProduct = findIndexOfProduct(product);
        if (indexOfProduct == -1) {
            if (numberOfItems == MAX_NUMBER_OF_ITEMS) {
                throw new MaximumNumberOfItemsException("Maximum capaciteit overschreden");
            }

            cart[numberOfItems] = new ShoppingCartItem(product, quantity);
            numberOfItems++;
        } else {
            ShoppingCartItem shoppingCartItem = cart[indexOfProduct];
            shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() + quantity);
        }
    }

    public void removeFromCart(Product product, int quantity) {
        int indexOfProduct = findIndexOfProduct(product);
        if (indexOfProduct == -1) {
            throw new IllegalArgumentException("Ongeldig product meegegeven");
        }

        ShoppingCartItem shoppingCartItem = cart[indexOfProduct];
        if (shoppingCartItem.getQuantity() - quantity < 0) {
            throw new IllegalArgumentException("Ongeldig aantal meegegeven");
        }

        if (shoppingCartItem.getQuantity() - quantity > 0) {
            shoppingCartItem.setQuantity(shoppingCartItem.getQuantity() - quantity);
        } else {
            // verwijderen
            for (int i = indexOfProduct; i < cart.length - 1; i++) {
                cart[i] = cart[i + 1];
            }
            cart[numberOfItems - 1] = null;
            numberOfItems--;
        }

    }

    private int findIndexOfProduct(Product product) {
        for (int i = 0; i < cart.length; i++) {
            ShoppingCartItem shoppingCartItem = cart[i];
            if (shoppingCartItem != null && shoppingCartItem.getProduct().equals(product)) {
                return i;
            }
        }
        return -1;
    }

    public double getTotal() {
        double total = 0.0;
        for (ShoppingCartItem shoppingCartItem : cart) {
            if (shoppingCartItem != null) {
                total += shoppingCartItem.getTotal();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return Arrays.toString(cart) + "\n" +
                "Totaal bedrag: " + getTotal()
                + "\nAantal items: " + numberOfItems + "\n";
    }

    // made them protected because they are not part of asked functionality
    protected int getNumberOfItems() {
        return numberOfItems;
    }

    protected ShoppingCartItem[] getCart() {
        return cart;
    }
}
