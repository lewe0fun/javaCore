package Data;

public class Product {
    private String title;
    private float price;
    private Category category;

    public Product(String title, float price,Category category) {
        this.title = title;
        this.price = price;
        this.category=category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
