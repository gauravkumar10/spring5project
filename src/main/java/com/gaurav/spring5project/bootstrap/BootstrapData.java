package com.gaurav.spring5project.bootstrap;

import com.gaurav.spring5project.domain.Author;
import com.gaurav.spring5project.domain.Book;
import com.gaurav.spring5project.domain.Publisher;
import com.gaurav.spring5project.repository.AuthorRepository;
import com.gaurav.spring5project.repository.BookRepository;
import com.gaurav.spring5project.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap is Started");

        Publisher publisher = new Publisher();
        publisher.setName("McGrow publishing");
        publisher.setCity("Delhi");
        publisher.setState("New Delhi");

        publisherRepository.save(publisher);
        System.out.println("PublisherCount :" + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drive nDesign", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("Computer Science","455689");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Number of Books :" + bookRepository.count());
        System.out.println("Publisher number of books : " + publisher.getBooks().size());

    }
}
