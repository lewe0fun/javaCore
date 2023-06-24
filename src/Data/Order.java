package Data;

public class Order {
    private Customer customer;
    private Product product;
    private int quantity;
    private float finalPrice;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.finalPrice =product.getPrice()*quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order ~~  " +
                "customer phone:" + customer.getPhone() +
                ", product title:" + product.getTitle() +
                ", quantity:" + quantity +
                ", product price:" + product.getPrice() +
                ", final price:" + finalPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }
}
