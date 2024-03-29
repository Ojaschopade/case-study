package com.subscriptionservice.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "subscription")
public class Subscription {

  @Id
  @Column(name = "subscriber_name")
  private String subscriberName;

  @Column(name = "date_subscribed")
  private Date dateSubscribed;

  @Column(name = "date_returned")
  private Date dateReturned;

  @Column(name = "book_id")
  private String bookId;

  public String getSubscriberName() {
    return subscriberName;
  }

  public void setSubscriberName(String subscriberName) {
    this.subscriberName = subscriberName;
  }

  public Date getDateSubscribed() {
    return dateSubscribed;
  }

  public void setDateSubscribed(Date dateSubscribed) {
    this.dateSubscribed = dateSubscribed;
  }

  public Date getDateReturned() {
    return dateReturned;
  }

  public void setDateReturned(Date dateReturned) {
    this.dateReturned = dateReturned;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }
}
