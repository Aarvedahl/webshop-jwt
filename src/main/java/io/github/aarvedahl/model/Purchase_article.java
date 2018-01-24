package io.github.aarvedahl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Purchase_article implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int purchaseid;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="orderid", referencedColumnName = "orderid", nullable = false)
    private Purchase orderid;


    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name="articleid", referencedColumnName = "articleid", nullable = false)
    private Article articleid;

    public Purchase_article(Purchase orderid, Article articleid) {
        this.orderid = orderid;
        this.articleid = articleid;
    }

    public Purchase_article() { }

    public int getPurchaseid() { return purchaseid; }
    public void setPurchaseid(int purchaseid) { this.purchaseid = purchaseid; }
    public Purchase getOrderid() { return orderid; }
    public void setOrderid(Purchase orderid) { this.orderid = orderid; }
    public Article getArticleid() { return articleid; }
    public void setArticleid(Article articleid) { this.articleid = articleid; }



    }




