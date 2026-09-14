package be.vives.ti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
        //build
        assertThat(cart.getNumberOfItems()).isEqualTo(0);
        assertThat(cart.getCart()[0]).isNull();

        //operate
        cart.addToCart(boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(1);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[1]).isNull();
    }

    @Test
    void addToNotEmptyCart() {
        //build
        Product kurkentrekker = new Product("Kurkentrekker", 23.95);
        Product kandelaar = new Product("Kandelaar", 9.99);

        cart.addToCart(kurkentrekker, 1);
        cart.addToCart(kandelaar, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(2);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2]).isNull();

        //operate
        cart.addToCart(this.boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(3);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[3]).isNull();

    }

    @Test
    void addSomeItemsOfAProductThatIsAlreadyAddedToTheCart() {
        //build
        cart.addToCart(boekenkast, 2);

        assertThat(cart.getNumberOfItems()).isEqualTo(1);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[1]).isNull();

        //operate
        cart.addToCart(boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(1);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(4);

        assertThat(cart.getCart()[1]).isNull();
    }

    @Test
    void addNewProductToAFullCart() {
        //build
        Product kurkentrekker = new Product("Kurkentrekker", 23.95);
        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(kurkentrekker, 1);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);

        //operate
        assertThatExceptionOfType(MaximumNumberOfItemsException.class)
                .isThrownBy(() -> cart.addToCart(boekenkast, 2))
                .withMessage("Maximum capaciteit overschreden");

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);
    }

    @Test
    void addSomeItemsOfAProductThatIsAlreadyAddedToAFullCart() {
        //build
        Product kurkentrekker = new Product("Kurkentrekker", 23.95);
        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(kurkentrekker, 1);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);

        //operate
        cart.addToCart(woordenboek, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(3);
    }

    @Test
    void removeFromEmptyCart() {
        //build
        assertThat(cart.getNumberOfItems()).isEqualTo(0);
        assertThat(cart.getCart()[0]).isEqualTo(null);

        //operate
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cart.removeFromCart(this.boekenkast, 2))
                .withMessage("Ongeldig product meegegeven");

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(0);
        assertThat(cart.getCart()[0]).isEqualTo(null);

    }

    @Test
    void removeThatMakesCartEmpty() {
        //build
        cart.addToCart(boekenkast, 2);

        assertThat(cart.getNumberOfItems()).isEqualTo(1);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[1]).isNull();

        //operate
        cart.removeFromCart(this.boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(0);
        assertThat(cart.getCart()[0]).isNull();
    }

    @Test
    void removeProductNotInCart() {

        //build
        Product kurkentrekker = new Product("Kurkentrekker", 23.95);
        Product kandelaar = new Product("Kandelaar", 9.99);
        cart.addToCart(kurkentrekker, 1);
        cart.addToCart(kandelaar, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(2);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2]).isNull();

        //operate
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> cart.removeFromCart(this.boekenkast, 1))
                .withMessage("Ongeldig product meegegeven");

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(2);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2]).isNull();
    }

    @Test
    void removeTooMuchItemsOfProductFromCart() {
        //build
        Product kurkentrekker = new Product("Kurkentrekker", 23.95);
        cart.addToCart(kurkentrekker, 1);
        cart.addToCart(boekenkast, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(2);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2]).isNull();

        //operate
        assertThatThrownBy(() -> cart.removeFromCart(this.boekenkast, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Ongeldig aantal meegegeven");

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(2);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kurkentrekker);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2]).isNull();
    }

    @Test
    void removeAllItemsFromFirstProductInCart() {
        //build

        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(boekenkast, 2);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);

        //operate
        cart.removeFromCart(boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(4);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4]).isNull();

    }

    @Test
    void removeAllItemsFromLastProductInCart() {
        //build

        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);
        cart.addToCart(boekenkast, 2);

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(2);

        //operate
        cart.removeFromCart(boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(4);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4]).isNull();

    }

    @Test
    void removeAllItemsFromAProductInCart() {
        //build

        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(boekenkast, 2);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);

        //operate
        cart.removeFromCart(boekenkast, 2);

        //test
        assertThat(cart.getNumberOfItems()).isEqualTo(4);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4]).isNull();

    }

    @Test
    void removeSomeItemsFromAProductInCart() {

        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(boekenkast, 3);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(3);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);

        //operate
        cart.removeFromCart(boekenkast, 1);

        //test

        assertThat(cart.getNumberOfItems()).isEqualTo(5);

        assertThat(cart.getCart()[0].getProduct()).isEqualTo(kandelaar);
        assertThat(cart.getCart()[0].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[1].getProduct()).isEqualTo(uurwerk);
        assertThat(cart.getCart()[1].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[2].getProduct()).isEqualTo(boekenkast);
        assertThat(cart.getCart()[2].getQuantity()).isEqualTo(2);

        assertThat(cart.getCart()[3].getProduct()).isEqualTo(wijnglas);
        assertThat(cart.getCart()[3].getQuantity()).isEqualTo(1);

        assertThat(cart.getCart()[4].getProduct()).isEqualTo(woordenboek);
        assertThat(cart.getCart()[4].getQuantity()).isEqualTo(1);
    }

    @Test
    void getTotalOfEmptyCart() {
        assertThat(cart.getTotal()).isEqualTo(0);
    }

    @Test
    void getTotalOfCartWithOneProduct() {
        cart.addToCart(boekenkast, 2);

        assertThat(cart.getTotal()).isEqualTo(119.98);
    }

    @Test
    void getTotalOfCartWithMultipleProducts() {
        Product kandelaar = new Product("Kandelaar", 9.99);
        Product uurwerk = new Product("Uurwerk", 120.00);
        Product wijnglas = new Product("Wijnglas", 14.50);
        Product woordenboek = new Product("Woordenboek", 49.5);
        cart.addToCart(kandelaar, 1);
        cart.addToCart(uurwerk, 1);
        cart.addToCart(wijnglas, 1);
        cart.addToCart(woordenboek, 1);
        cart.addToCart(boekenkast, 2);

        assertThat(cart.getTotal()).isEqualTo(313.97);
    }
}