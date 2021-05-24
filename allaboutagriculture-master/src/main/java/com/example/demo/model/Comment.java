package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")

public class Comment {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
 
 
  @ManyToOne
  @JoinColumn(name = "customer_nickname")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "forum_name")
  private Forum forum;

 
  @Column(name = "comment")
  private String comment;

 
  public Comment() {
    
  }
  public Comment( Customer customer, Forum forum, String comment) {
     // super();
     this.customer = customer;
     this.forum = forum;
     this.comment = comment;
  }
  public int getId() {
     return id;
  }
  public void setId(int id) {
     this.id = id;
  }
  public String getComment() {
     return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
 
  public Customer getCustomer() {
     return customer;
  }

  public void setCustomer(Customer customer) {
     this.customer = customer;
  }

  public Forum getForum() {
     return forum;
  }

  public void setForum(Forum forum) {
     this.forum = forum;
  }
}