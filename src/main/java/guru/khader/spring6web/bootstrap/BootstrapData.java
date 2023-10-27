package guru.khader.spring6web.bootstrap;

import guru.khader.spring6web.domain.Author;
import guru.khader.spring6web.domain.Book;
import guru.khader.spring6web.repositories.AuthorRepository;
import guru.khader.spring6web.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        Author nizar = new Author();

        nizar.setFirstName("Nizar");
        nizar.setLastName("Khader");

        Book javaBook = new Book();

        javaBook.setTitle("Java Persistence");
        javaBook.setIsbn("1223");

        Author nizarSaved = authorRepository.save(nizar);
        Book javaBookSaved = bookRepository.save(javaBook);

        Author khaled = new Author();

        khaled.setFirstName("Khaled");
        khaled.setLastName("Odeh");

        Book ora = new Book();

        ora.setTitle("OWK (Oracle With Khaled)");
        ora.setIsbn("1221");


        Author khaledSaved = authorRepository.save(khaled);
        Book oraBookSaved = bookRepository.save(ora);

        nizarSaved.getBooks().add(javaBookSaved);
        khaledSaved.getBooks().add(oraBookSaved);

        authorRepository.save(nizarSaved);
        authorRepository.save(khaledSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count() );

    }
}















