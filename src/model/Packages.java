package model;


public class Packages
{
    private String name;
    private int Price;
    private String Description;

    public Packages() {
    }

    public Packages(String name, int price, String description) {
        this.name = name;
        Price = price;
        Description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
