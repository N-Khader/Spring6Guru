package guru.khader.spring6web.services;

import guru.khader.spring6web.domain.Author;

public interface AuthorService {
    Iterable<Author> getAuthors();
}
