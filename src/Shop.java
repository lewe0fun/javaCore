import Data.Customer;
import Data.Order;
import Data.Product;
import Exceptions.AmountException;
import Exceptions.CustomerException;
import Exceptions.ProductException;

public class Shop {
    static Customer[] customers = null;
    static Product[] products = null;

    public static void main(String[] args) {
        customers = new Customer[]{
                new Customer("Ivan", "ivanov", 26, "+654987"),
                new Customer("QWer", "Rsdg", 32, "+65436547")
        };
        products = new Product[]{
                new Product("Milk", 100.5f),
                new Product("Coffe", 125.5f),
                new Product("Beer", 200.5f),
                new Product("Shugar", 108.5f),
                new Product("Bread", 80.5f),
                new Product("Salt", 1.5f)
        };
        Order[] orders = new Order[5];



        try{orders[0]=makePurchase("+789546","Beer",2)}
        catch(ProductException e){
            System.out.println(e.getMessage());
        }
    }

    public static Order makePurchase(String phone, String title, int amount) throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;

        for (Customer c : customers) {
            if (c.getPhone().equals(phone)) {
                customer = c;
            }
        }
        for (Product p : products) {
            if (p.getTitle().equals(title)) {
                product = p;
            }
        }
        if (customer == null) throw new CustomerException("customer not found");
        if (product == null) throw new ProductException("Product not found");
        if (amount > 100) throw new AmountException("too big order");
        return new Order(customer, product, amount);
    }


}

