package OOP.Encapsulation;

public class Encapsulation {

    public static void main(String[] args) {
        System.out.println("Encapsulation");

        Cart cart = new Cart(1);
        try {
            cart.updateQuantity(-55);
        } catch (Exception e) {
            System.out.println("Exception caught " + e.getMessage());
        }
        cart.updateQuantity(5);
        System.out.println(cart.getQuantity());

    }
}

class Cart {
    private int quantity = 0;

    public Cart(int quantity) {
        this.validate(quantity);
        this.quantity = quantity;
    }

    public void updateQuantity(int quantity) {
        this.validate(quantity);
        this.quantity += quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    private void validate(int quantity) {
        if (quantity < 0) {
            throw new IllegalStateException("Quantity should be greater than 0");
        }
    }
}
