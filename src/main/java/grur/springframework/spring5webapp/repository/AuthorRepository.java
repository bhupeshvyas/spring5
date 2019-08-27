package grur.springframework.spring5webapp.repository;
import grur.springframework.spring5webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>   {
}
