import Data.*;
import Exceptions.*;
import db.DB;
import utils.ParseCheckInput;

import java.util.Random;
import java.util.Scanner;

public class Shop {

    static int orderLimit = 0;

    public static void ordering() {

        Order[] orders = DB.getOrders();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter separated by spaces:\ncustomer phone number/product title/product amount, or exit");
            String cmd = sc.nextLine();

            if (cmd.equals("exit") || orderLimit == 4) break;
            try {
                String[] order = ParseCheckInput.parseCheck(cmd);
                try {
                    orders[orderLimit++] = makePurchase(order[0], order[1], Integer.parseInt(order[2]));
                } catch (TooMuchSaleException | ProductException e) {
                    System.out.println(e.getMessage());
                    orderLimit--;
                } catch (CustomerException e) {
                    System.out.println(e.getMessage() + "\n exiting...");
                    orderLimit--;
                    break;
                } catch ( AmountException e) {
                    try {
                        orders[orderLimit] = makePurchase(order[0], order[1], 1);
                    } catch (ProductException | CustomerException | AmountException ex) {
                        System.out.println(ex.getMessage());
                    } catch (TooMuchSaleException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            } catch (WrongArgumentException |  WrongNumberOfArgumentsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("orders..." + orderLimit);
        }
        System.out.println("orders list...");
        for (Order order : orders)
            System.out.println(order);
        System.out.println("orders..." + orderLimit);

    }

    public static Order makePurchase(String phone, String title, int amount) throws CustomerException, ProductException, AmountException, TooMuchSaleException {
        Customer customer = null;
        Product product = null;

        for (Customer c : DB.getCustomers()) {
            if (c.getPhone().equals(phone)) {
                customer = c;
            }
        }
        for (Product p : DB.getProducts()) {
            if (p.getTitle().equals(title)) {
                product = p;
            }
        }
        if (customer == null) throw new CustomerException();
        if (product == null) throw new ProductException();
        if (amount > 100 || amount < 1) throw new AmountException();
        Order order = new Order(customer, product, amount);
        makeDiscount(order);
        return order;
    }

    public static void makeDiscount(Order order) throws TooMuchSaleException {

        int randomDiscount = Discount.values()[new Random().nextInt(Discount.values().length)].value;
        if (order.getProduct().getCategory().equals(Category.PREMIUM) && randomDiscount > 15) {
            throw new TooMuchSaleException();
        } else {
            System.out.println("apply " + randomDiscount + "% discount...");
            order.setFinalPrice(order.getFinalPrice() - (order.getFinalPrice() / 100 * randomDiscount));
        }
    }

    public static void setValueDiscount() {
        int value = 0;
        for (Discount discount : Discount.values()) {
            discount.value = value;
            value += 5;
        }
    }
}

