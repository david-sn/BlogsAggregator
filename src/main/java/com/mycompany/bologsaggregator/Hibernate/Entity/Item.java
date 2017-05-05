package com.mycompany.bologsaggregator.Hibernate.Entity;

import java.util.Date;


public class Item {

    private int item_dbid;
    private String itemTitle;
    private String itemDescriptions;
    private String itemLink;
    private Date itemPublishedDate;
    private Blog blog;

    public int getItem_dbid() {
        return item_dbid;
    }

    public void setItem_dbid(int item_dbid) {
        this.item_dbid = item_dbid;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemDescriptions() {
        return itemDescriptions;
    }

    public void setItemDescriptions(String itemDescriptions) {
        this.itemDescriptions = itemDescriptions;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public Date getItemPublishedDate() {
        return itemPublishedDate;
    }

    public void setItemPublishedDate(Date itemPublishedDate) {
        this.itemPublishedDate = itemPublishedDate;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    
    
    
    
    
    
    
}
