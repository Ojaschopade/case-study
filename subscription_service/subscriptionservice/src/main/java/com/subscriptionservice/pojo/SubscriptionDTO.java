package com.subscriptionservice.pojo;

import java.util.Date;

public class SubscriptionDTO {
  public String subscriberName;
  public Date dateSubscribed;
  public Date dateReturned;
  public String bookId;

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

  @Override
  public String toString() {
    return "Subscription{" +
        "subscriberName='" + subscriberName + '\'' +
        ", dateSubscribed=" + dateSubscribed +
        ", dateReturned=" + dateReturned +
        ", bookId='" + bookId + '\'' +
        '}';
  }
}
