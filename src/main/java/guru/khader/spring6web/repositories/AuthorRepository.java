package guru.khader.spring6web.repositories;

import guru.khader.spring6web.domain.Author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {


}
