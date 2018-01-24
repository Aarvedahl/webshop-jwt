package io.github.aarvedahl.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleid;

    @Column
    private String articlename;

    @Column
    private String description;

    @Column
    private int price;

    @Column
    private int stock;

    @Column
    private String brand;

    /*@JsonBackReference
    @OneToMany(mappedBy = "articleid", cascade=CascadeType.MERGE)
    public List<Purchase_article> orderList; */

    public Article() { }
    public Article(int articleid) {
        this.articleid = articleid;
    }
    public Article(int articleid, String articlename, String description, int price, int stock, String brand) {
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
   // public List<Purchase_article> getOrderList() { return orderList; }

}

