package org.techforumist.jwt.dto;

import java.util.Date;

public class Purchasedto {

    private int orderid;
    private Date orderdate;
    private boolean canceled;
    private int userid;

    public Purchasedto(int orderid, Date orderdate, boolean canceled, int userid) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.canceled = canceled;
        this.userid = userid;
    }

    public Purchasedto() {
    }

    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid = orderid; }
    public Date getOrderdate() { return orderdate; }
    public void setOrderdate(Date orderdate) { this.orderdate = orderdate; }
    public boolean isCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }
}
