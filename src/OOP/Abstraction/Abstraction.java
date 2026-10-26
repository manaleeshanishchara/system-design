package OOP.Abstraction;

public class Abstraction {

    public static void main(String[] args) {
        System.out.println("Abstraction");

        // Example usage of the Payment abstraction
        Payment creditCardPayment = new CreditCardPayment();
        Payment payPalPayment = new PayPalPayment();
        Payment upiPayment = new UpiPayment();

        Checkout checkout1 = new Checkout(creditCardPayment);
        checkout1.processPayment();

        Checkout checkout2 = new Checkout(payPalPayment);
        checkout2.processPayment();

        Checkout checkout3 = new Checkout(upiPayment);
        checkout3.processPayment();
    }
}

interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment made using Credit Card.");
    }
}

class PayPalPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment made using PayPal.");
    }
}

class UpiPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("Payment made using UPI.");
    }
}

class Checkout {
    private Payment paymentMethod;

    public Checkout(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment() {
        paymentMethod.pay();
    }
}
