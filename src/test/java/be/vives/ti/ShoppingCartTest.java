package be.vives.ti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private Product boekenkast;
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        boekenkast = new Product("Boekenkast", 59.99);
        cart = new ShoppingCart();
    }

    @Test
    void addToEmptyCart() {

    }

    @Test
    void addToNotEmptyCart() {

    }

    @Test
    void addSomeItemsOfAProductThatIsAlreadyAddedToTheCart() {

    }

    @Test
    void addNewProductToAFullCart() {

    }

    @Test
    void addSomeItemsOfAProductThatIsAlreadyAddedToAFullCart() {

    }

}