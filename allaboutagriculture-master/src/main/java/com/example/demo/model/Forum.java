package com.example.demo.model;

import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Forum")

public class Forum {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
 
 
  @ManyToOne
  @JoinColumn(name = "customer_nickname")
  private Customer customer;
 
  @Column(name = "title")
  private String title;

@Column(name = "thumbnail")
  private String thumbnail;

 
  @Column(name = "date")
  private Date date;
 
  @Column(name = "description")
  private String description;
 
  public Forum() {
    
  }
  public Forum( Customer customer, String title, String thumbnail, Date date, String description) {
     // super();
     this.customer = customer;
     this.title = title;
     this.thumbnail = thumbnail;
     this.date = date;
     this.description = description;
  }
  public int getId() {
     return id;
  }
  public void setId(int id) {
     this.id = id;
  }
  public String getTitle() {
     return title;
  }
  public void setTitle(String title) {
     this.title = title;
  }
  public String getThumbnail() {
     return thumbnail;
  }
  public void setThumbnail(String thumbnail) {
     this.thumbnail = thumbnail;
  }
  public Date getDate () {
     return date;
  }
  public void setDate (Date date ) {
     this.date  = date ;
  }

  public String getDescription() {
     return description;
  }
  public void setDescription(String description) {
     this.description = description;
  }
 
  public Customer getCustomer() {
     return customer;
  }

  public void setCustomer(Customer customer) {
     this.customer = customer;
  }
  
}
