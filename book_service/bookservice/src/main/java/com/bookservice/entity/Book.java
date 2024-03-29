package com.bookservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book")
public class Book {

  @Id
  @Column(name = "book_id")
  private String bookId;

  @Column(name = "book_name")
  private String bookName;

  @Column(name = "author")
  private String author;

  @Column(name = "available_copies")
  private Integer availableCopies;

  @Column(name = "total_copies")
  private Integer totalCopies;

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getAvailableCopies() {
    return availableCopies;
  }

  public void setAvailableCopies(Integer availableCopies) {
    this.availableCopies = availableCopies;
  }

  public Integer getTotalCopies() {
    return totalCopies;
  }

  public void setTotalCopies(Integer totalCopies) {
    this.totalCopies = totalCopies;
  }
}
