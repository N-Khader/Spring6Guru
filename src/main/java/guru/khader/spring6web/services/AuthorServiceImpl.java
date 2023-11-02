package guru.khader.spring6web.services;

import guru.khader.spring6web.domain.Author;
import guru.khader.spring6web.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> getAuthors() {

        return authorRepository.findAll();
    }
}
