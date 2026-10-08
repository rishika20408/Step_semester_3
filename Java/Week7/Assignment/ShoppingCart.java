class CartData {
    private double[] prices;
    private int itemCount;
    private final String cartId;

    CartData(String cartId, int size) {
        this.cartId = cartId;
        prices = new double[size];
        itemCount = 0;
    }

    void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    int getItemCount() {
        return itemCount;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        CartData cart = new CartData("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}