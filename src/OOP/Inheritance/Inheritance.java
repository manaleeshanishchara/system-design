package OOP.Inheritance;

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("Inheritance");

        GoldMembership gold = new GoldMembership("Manalee");
        gold.printDetails(); // inherited from Membership
        System.out.println("Bill after discount: " + gold.applyDiscount(1000)); // inherited logic
        gold.accessLounge(); // Gold-only behaviour

        System.out.println();

        SilverMembership silver = new SilverMembership("Rahul");
        silver.printDetails();
        System.out.println("Bill after discount: " + silver.applyDiscount(1000));
        silver.earnPoints(1000); // Silver-only behaviour
    }
}

class Membership {
    protected String memberName;
    protected double monthlyFee;

    Membership(String memberName, double monthlyFee) {
        this.memberName = memberName;
        this.monthlyFee = monthlyFee;
    }

    double getDiscountPercentage() {
        return 0;
    }

    // Written once here, reused by every subclass
    double applyDiscount(double amount) {
        return amount - amount * getDiscountPercentage() / 100;
    }

    void printDetails() {
        System.out.println("Member: " + memberName);
        System.out.println("Plan: " + getClass().getSimpleName());
        System.out.println("Monthly fee: " + monthlyFee);
        System.out.println("Discount: " + getDiscountPercentage() + "%");
    }
}

class GoldMembership extends Membership {
    GoldMembership(String memberName) {
        super(memberName, 999);
    }

    @Override
    double getDiscountPercentage() {
        return 20;
    }

    void accessLounge() {
        System.out.println(memberName + " can access the airport lounge");
    }
}

class SilverMembership extends Membership {
    SilverMembership(String memberName) {
        super(memberName, 499);
    }

    @Override
    double getDiscountPercentage() {
        return 10;
    }

    void earnPoints(double amount) {
        int points = (int) (amount / 100);
        System.out.println(memberName + " earned " + points + " reward points");
    }
}
