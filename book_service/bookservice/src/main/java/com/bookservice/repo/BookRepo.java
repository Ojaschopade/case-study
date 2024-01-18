package com.bookservice.repo;

import com.bookservice.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,String> {

}
