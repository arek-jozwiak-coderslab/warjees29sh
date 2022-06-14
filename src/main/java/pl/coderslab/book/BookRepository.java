package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("select b from Book b where b.title=?1")
    List<Book> findByOne(String title);


    @Query("select b from Book b where b.category=?1")
    List<Book> findBySecond(Category category);

    List<Book> findByRating(int rating);

    List<Book> findByAuthorsIn(List<Author> authors);

    List<Book> findByPublisher(Publisher publisher);


}
