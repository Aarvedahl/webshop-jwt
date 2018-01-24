package io.github.aarvedahl.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    @Column
    private Date orderdate;

    @Column
    private boolean canceled;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid", nullable = false)
    private Users userid;


    @JsonManagedReference
    @OneToMany(mappedBy = "orderid", cascade=CascadeType.MERGE)
    private List<Purchase_article> articleList;

    public Purchase(int orderid){
        this.orderid = orderid;
    }
    public Purchase() { }
    public Purchase(int orderid, Users userid, Date orderdate, Boolean canceled) {
        this.orderid = orderid;
        this.userid = userid;
        this.orderdate = orderdate;
        this.canceled = canceled;
    }

    public Purchase(Date orderdate, boolean canceled, Users userid) {
        this.orderdate = orderdate;
        this.canceled = canceled;
        this.userid = userid;
    }

    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid = orderid; }
    public Users getUserid() { return userid; }
    public void setUserid(Users userid) { this.userid = userid; }
    public Date getOrderdate() { return orderdate; }
    public boolean getCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
    public void setOrderdate(Date orderdate) { this.orderdate = orderdate; }
    public List<Purchase_article> getArticleList() { return articleList; }
    public void setArticleList(List<Purchase_article> articleList) { this.articleList = articleList; }
}
