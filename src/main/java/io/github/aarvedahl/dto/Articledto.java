package io.github.aarvedahl.dto;

public class Articledto {

    private int articleid;

    private String articlename;

    private String description;

    private int price;

    private int stock;

    private String brand;

    public Articledto() { }

    public Articledto(int articleid, String articlename, String description, int price, int stock, String brand) {
        this.articleid = articleid;
        this.articlename = articlename;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
    }

    public int getArticleid() { return articleid; }
    public void setArticleid(int articleid) { this.articleid = articleid; }
    public String getArticlename() { return articlename; }
    public void setArticlename(String articlename) { this.articlename = articlename; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

}
