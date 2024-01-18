package com.bookservice.pojo;

public class BookDTO {
  public String bookId;
  public String bookName;
  public String author;
  public Integer availableCopies;
  public Integer totalCopies;

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

  @Override
  public String toString() {
    return "Book{" +
        "bookId='" + bookId + '\'' +
        ", bookName='" + bookName + '\'' +
        ", author='" + author + '\'' +
        ", availableCopies=" + availableCopies +
        ", totalCopies=" + totalCopies +
        '}';
  }
}
