import Data.Customer;
import Data.Order;
import Data.Product;
import Exceptions.*;
import utils.ParseCheckInput;

import java.util.Arrays;
import java.util.Scanner;

public class Shop {
    static Customer[] customers = null;
    static Product[] products = null;
    static int orderLimit = 0;

    public static void main(String[] args) throws CustomerException, AmountException, ProductException {
        customers = new Customer[]{
                new Customer("Ivan", "ivanov", 26, "+654987"),
                new Customer("QWer", "Rsvg", 32, "+65436547")
        };
        products = new Product[]{
                new Product("Milk", 100.5f),
                new Product("Coffee", 125.5f),
                new Product("Beer", 200.5f),
                new Product("Sugar", 108.5f),
                new Product("Bread", 80.5f),
                new Product("Salt", 1.5f)
        };

        Order[] orders = new Order[5];
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter separated by spaces:\ncustomer phone number/product title/product amount, or exit");
            String cmd = sc.nextLine();

            if (cmd.equals("exit") || orderLimit == 4) break;
            try {
                String[] order = ParseCheckInput.parseCheck(cmd);
                try {
                    orders[orderLimit++] = makePurchase(order[0], order[1], Integer.parseInt(order[2]));
                } catch (ProductException e) {
                    System.out.println(e.getMessage());
                    orderLimit--;
                } catch (CustomerException e) {
                    System.out.println(e.getMessage()+"\n exiting...");
                    orderLimit--;
                    break;
                } catch (AmountException e) {
                    orders[orderLimit] = makePurchase(order[0], order[1], 1);
                }
            } catch (WrongNumberOfArgumentsException | WrongArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("orders..." + orderLimit);
        }
        System.out.println("orders list...");
        for (Order order : orders)
            System.out.println(order);
        System.out.println("orders..." + orderLimit);

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
        if (customer == null) throw new CustomerException();
        if (product == null) throw new ProductException();
        if (amount > 100 || amount < 1) throw new AmountException();
        return new Order(customer, product, amount);
    }


}

