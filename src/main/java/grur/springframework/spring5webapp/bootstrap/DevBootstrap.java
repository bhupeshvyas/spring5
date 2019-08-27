package grur.springframework.spring5webapp.bootstrap;

import grur.springframework.spring5webapp.models.Author;
import grur.springframework.spring5webapp.models.Book;
import grur.springframework.spring5webapp.models.Publisher;
import grur.springframework.spring5webapp.repository.AuthorRepository;
import grur.springframework.spring5webapp.repository.BookRepository;
import grur.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository,
                        PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author author1 = new Author("Bhupesh", "Vyas");
        Publisher publisher1 = new Publisher("Helper Collins", "USA");
        Book book = new Book("Domain Drieven Development", "2321", publisher1);
        author1.getBooks().add(book);
        book.getAuthors().add(author1);
        authorRepository.save(author1);
        publisherRepository.save(publisher1);
        bookRepository.save(book);


        Author author2 = new Author("Rahul", "Khandelwal");
        Publisher publisher2 = new Publisher("Worx", "INDIA");
        Book book1 = new Book("J2EE ADVANCE", "1221", publisher2);
        author2.getBooks().add(book1);
        book1.getAuthors().add(author2);
        authorRepository.save(author2);
        publisherRepository.save(publisher2);
        bookRepository.save(book1);

    }
}
