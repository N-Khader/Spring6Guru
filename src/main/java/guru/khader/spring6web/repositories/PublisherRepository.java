package guru.khader.spring6web.repositories;

import guru.khader.spring6web.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
