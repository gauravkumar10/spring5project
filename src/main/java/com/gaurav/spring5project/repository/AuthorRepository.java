package com.gaurav.spring5project.repository;


import com.gaurav.spring5project.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
