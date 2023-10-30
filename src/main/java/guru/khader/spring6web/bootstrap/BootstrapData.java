package guru.khader.spring6web.bootstrap;

import guru.khader.spring6web.domain.Author;
import guru.khader.spring6web.domain.Book;
import guru.khader.spring6web.domain.Publisher;
import guru.khader.spring6web.repositories.AuthorRepository;
import guru.khader.spring6web.repositories.BookRepository;
import guru.khader.spring6web.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        //Creating Author1
        Author nizar = new Author();

        nizar.setFirstName("Nizar");
        nizar.setLastName("Khader");

        //Creating Book1
        Book javaBook = new Book();

        javaBook.setTitle("Java Persistence");
        javaBook.setIsbn("1223");

        //Saving Author1 and Book1
        Author nizarSaved = authorRepository.save(nizar);
        Book javaBookSaved = bookRepository.save(javaBook);


        //Creating Author2
        Author khaled = new Author();

        khaled.setFirstName("Khaled");
        khaled.setLastName("Odeh");

        //Creating Book2
        Book ora = new Book();

        ora.setTitle("OWK (Oracle With Khaled)");
        ora.setIsbn("1221");


        //Creating a Publisher
        Publisher publisher = new Publisher();

        publisher.setPublisherName("NizarKhader");
        publisher.setAddress("Irbid");

        //Saving the Author2 and Book2
        Author khaledSaved = authorRepository.save(khaled);
        Book oraBookSaved = bookRepository.save(ora);

        //Saving a Publisher for both books
        Publisher savedPublisher = publisherRepository.save(publisher);


        //Creating the relationship between Author, Book and Publisher
        nizarSaved.getBooks().add(javaBookSaved);
        khaledSaved.getBooks().add(oraBookSaved);
        javaBookSaved.setPublisher(savedPublisher);
        oraBookSaved.setPublisher(savedPublisher);


        //Saving the relationship as is
        authorRepository.save(nizarSaved);
        authorRepository.save(khaledSaved);
        bookRepository.save(javaBookSaved);
        bookRepository.save(oraBookSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count() );
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}















