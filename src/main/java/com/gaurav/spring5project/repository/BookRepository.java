package com.gaurav.spring5project.repository;

import com.gaurav.spring5project.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
