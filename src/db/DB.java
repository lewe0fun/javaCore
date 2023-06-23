package db;

import Data.Customer;
import Data.Order;
import Data.Product;

public class DB {
    public static Customer[] getCustomers() {
        return new Customer[]{
                new Customer("Ivan", "ivanov", 26, "+654987"),
                new Customer("QWer", "Rsvg", 32, "+65436547")
        };

    }

    public static Product[] getProducts() {
        return new Product[]{
                new Product("Milk", 100.5f),
                new Product("Coffee", 125.5f),
                new Product("Beer", 200.5f),
                new Product("Sugar", 108.5f),
                new Product("Bread", 80.5f),
                new Product("Salt", 1.5f)
        };
    }
    public static Order[] getOrders(){
        return new Order[5];
    }
}
