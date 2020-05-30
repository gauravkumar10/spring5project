package com.gaurav.spring5project.repository;

import com.gaurav.spring5project.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository< Publisher, Long > {
}
