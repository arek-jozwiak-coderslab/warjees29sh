package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.person.Person;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
@ResponseBody
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/add")
    public String saveBook() {
        Book book = new Book();
        book.setTitle("Java 2");
        bookDao.save(book);
        return "saved";
    }

    @RequestMapping("/edit")
    public String editBook() {
        Book book = bookDao.findById(1l);
        book.setTitle("Java 22");
        bookDao.update(book);
        return "saved";
    }

    @RequestMapping("/delete")
    public String deleteBook() {
        Book book = bookDao.findById(1l);
        bookDao.delete(book);
        return "saved";
    }

    @RequestMapping("/get")
    public String getBook() {
        Book book = bookDao.findById(1l);
        System.out.println(book.getTitle());
        return book.getTitle();
    }

    @RequestMapping("/add-with-publisher")
    public String saveBookWithPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Java 2");
        book.setPublisher(publisher);
        bookDao.save(book);
        return "saved";
    }

    @RequestMapping("/list")
    public String getList() {
        List<Book> list = bookDao.getList();
        return list.stream()
                .map(b -> b.getTitle())
                .peek(s -> System.out.println(s))
                .collect(Collectors.joining(" ---- "));
    }
}
