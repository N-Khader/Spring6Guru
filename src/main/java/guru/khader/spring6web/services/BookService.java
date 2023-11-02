package guru.khader.spring6web.services;

import guru.khader.spring6web.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
