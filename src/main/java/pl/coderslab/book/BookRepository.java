package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //#1
    List<Book> findByTitle(String title);

    //#2
    List<Book> findByCategory(Category category);

    //#3
    List<Book> findByCategoryId(long id);
}
